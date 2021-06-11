/**
 * Created by Administrator on 2018/2/5.
 */
var app = new Vue({
    el: '#app',
    data: {
        orderList: [],
        mailingUser: "",
        collUser: "",
        order: "",
        shipingTypeOption: [
            {text: '标准快运', value: '1'},
            {text: '特快', value: '2'}
        ],
        selectShipingTypeShow: false,
        shipingTypeCurrentValue: {
            text: '',
            value: null,
        },
        serviceTypeOption: [
            {text: '派送', value: '1'},
            {text: '自取', value: '2'}
        ],
        selectServiceTypeShow: false,
        serviceTypeCurrentValue: {
            text: '',
            value: null,
        },
        packingTypeOption: [
            {text: '简易包装', value: '1'},
            {text: '复杂包装', value: '2'}
        ],
        selectPackingTypeShow: false,
        packingTypeCurrentValue: {
            text: '',
            value: null,
        },
        distributionWayOption: [
            {text: '中转', value: '1'},
            {text: '周转', value: '2'}
        ],
        selectDistributionWayShow: false,
        distributionWayCurrentValue: {
            text: '',
            value: null,
        },
        isOverLength: true,
        isOverWeight: true,
        isReceipt: true,
    },
    created: function () {
        var self = this;
        self.loaderModeFlag = true;
        self.init();
    },
    methods: {
        init: function () {
            var self = this;
            self.$http.get(contextPath + "/index_new", {}).then((response) => {
                var orderList = response.data.orderList;
                self.orderList = orderList;
                var mailingUser = response.data.mailingUser;
                var collUser = response.data.collUser;
                for (var i = 0; i < orderList.length; i++) {
                    if (i == 0) {
                        var obj = orderList[0];
                        if (obj.overLength == "1") {
                            self.isOverLength = false;
                        } else {
                            self.isOverLength = true;
                        }
                        if (obj.overWeight == "1") {
                            self.isOverWeight = false;
                        } else {
                            self.isOverWeight = true;
                        }
                        if (obj.receipt == "1") {
                            self.isReceipt = false;
                        } else {
                            self.isReceipt = true;
                        }
                        self.setOrderMailingUser(obj, mailingUser);
                        self.setOrderCollUser(obj, collUser);
                        Vue.set(obj, 'mailingTime', self.formatDate(new Date(obj.mailingTime), "yyyy-MM-dd hh:mm:ss"));
                        self.order = obj;
                        self.optionsSet();
                    }
                }
            }, (response) => {

            });
        },
        setOrderMailingUser: function (obj, mailingUser) {
            // 寄件人信息
            Vue.set(obj, 'mailingUserId', mailingUser.id);
            Vue.set(obj, 'mailingUserName', mailingUser.userName);
            Vue.set(obj, 'mailingMobilePhone', mailingUser.mobilePhone);
            Vue.set(obj, 'mailingAddress', mailingUser.address);
            Vue.set(obj, 'mailingTelphone', mailingUser.telphone);
            Vue.set(obj, 'mailingCompanyName', mailingUser.companyName);
            /*obj.mailingId = mailingUser.id;
             obj.mailingUserName = mailingUser.userName;
             obj.mailingMobilePhone = mailingUser.mobilePhone;
             obj.mailingAddress = mailingUser.address;
             obj.mailingTelphone = mailingUser.telphone;
             obj.mailingCompanyName = mailingUser.companyName;*/
        },
        setOrderCollUser: function (obj, collUser) {
            // 收件人信息
            Vue.set(obj, 'collUserId', collUser.id);
            Vue.set(obj, 'collUserName', collUser.userName);
            Vue.set(obj, 'collMobilePhone', collUser.mobilePhone);
            Vue.set(obj, 'collAddress', collUser.address);
            Vue.set(obj, 'collTelphone', collUser.telphone);
            Vue.set(obj, 'collCompanyName', collUser.companyName);
            // obj.collId = collUser.id;
            // obj.collUserName = collUser.userName;
            // obj.collMobilePhone = collUser.mobilePhone;
            // obj.collAddress = collUser.address;
            // obj.collTelphone = collUser.telphone;
            // obj.collCompanyName = collUser.companyName;
        },
        calculate: function () {
            var self = app;
            var order = self.order;
            var goodsHeight = order.goodsHeight;
            var goodsLength = order.goodsLength;
            var goodsWidth = order.goodsWidth;
            var num = order.num;
            var actualWeight = order.actualWeight;
            if (goodsLength == '' || goodsWidth == '' || goodsHeight == '' || num == '' || actualWeight == '') {
                alert("长、宽、高、件数和实际重量不能为空");
                return;
            }
            order.volume = goodsLength * goodsWidth * goodsHeight * num;
            if (order.volume * 250 < actualWeight) {
                order.banlanceWeight = actualWeight;
            } else {
                order.banlanceWeight = order.volume * 250;
            }
        },
        newOrder: function () {
            var self = app;
            var order = self.order;
            self.order = self.setOrder(order);
        },
        oneOrder: function (id) {
            var self = this;
            self.$http.get(contextPath + "/queryOrderById", {params: {id: id}}).then((response) => {
                var order = response.data.order;
                var mailingUser = response.data.mailingUser;
                var collUser = response.data.collUser;
                self.setOrderMailingUser(order, mailingUser);
                self.setOrderCollUser(order, collUser);
                Vue.set(order, 'mailingTime', self.formatDate(new Date(order.mailingTime), "yyyy-MM-dd hh:mm:ss"));
                self.order = order;
                self.optionsSet();
            }, (response) => {

            });
        },
        saveOrder: function () {
            var self = this;
            var order = self.order;
            var params = JSON.stringify(order);
            self.$http.get(contextPath + "/saveOrder",
                {params: {order: params}}
                //{'headers': {'Content-Type': 'application/json'}}
            ).then((response) => {
                var result = response.data.result;
                if (result == 'success') {
                    this.$messagebox.confirm("添加成功，刷新页面！").then(action => {
                        window.location.href = "http://localhost:7802/html/index_new.html";
                    });
                }
            }, (response) => {

            });
        },
        mailUser: function (userName, index) {
            var self = this;
            self.$http.get(contextPath + "/queryUserByName",
                {params: {userName: userName}}
            ).then((response) => {
                var user = response.data.user;
                if (user.id == '' || user.id == null || user.id == ' ') {
                    if (index == 1) {
                        Vue.set(self.order, 'mailingUserId', "");
                    } else {
                        Vue.set(self.order, 'collUserId', "");
                    }
                    return;
                }
                var order = self.order;
                this.$messagebox.confirm("客户名称：" + user.userName + " 手机：" + user.mobilePhone + " 地址：" + user.address + "<br/>确定是这个客户吗？").then(action => {
                    if (index == 1) {
                        self.setOrderMailingUser(order, user);
                    } else {
                        self.setOrderCollUser(order, user);
                    }
                    self.order = order;
                });
            }, (response) => {

            });
        },
        setOrder: function (obj) {
            // 寄件人信息
            obj.mailingId = "";
            obj.mailingUserName = "";
            obj.mailingMobilePhone = "";
            obj.mailingAddress = "";
            obj.mailingTelphone = "";
            obj.mailingCompanyName = "";
            // 收件人信息
            obj.collId = "";
            obj.collUserName = "";
            obj.collMobilePhone = "";
            obj.collAddress = "";
            obj.collTelphone = "";
            obj.collCompanyName = "";
            obj.id = "";

            obj.goodsLength = "";
            obj.goodsWidth = "";
            obj.goodsHeight = "";
            obj.actualWeight = "";
            obj.banlanceWeight = "";
            obj.volume = "";
            obj.maxLength = "";
            obj.packingType = "";
            obj.num = "";
            obj.distributionWay = "";
            obj.itemName = "";
            obj.receipt = "";
            obj.receipt2 = "";
            obj.overLength = "";
            obj.overWeight = "";
            obj.overWeightNum = "";
            obj.goodsType = "";
            obj.declaredValue = "";
            obj.note = "";
            obj.mailingUserId = "";
            obj.packingNum = "";
            obj.orderNum = "";
            obj.mailingTime = app.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss");
            obj.mailingState = "嘉兴";
            obj.destination = "";
            obj.receivingClerk = "";
            obj.shipingType = "";
            obj.serviceType = "";
            obj.nextStation = "";
            obj.recordMsg = "";
            obj.signMsg = "";
            obj.delivery = "";
            obj.since = "";
            obj.collUserId = "";
            return obj;
        },
        formatDate: function (date, fmt) {
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
            }
            let o = {
                'M+': date.getMonth() + 1,
                'd+': date.getDate(),
                'h+': date.getHours(),
                'm+': date.getMinutes(),
                's+': date.getSeconds()
            };
            for (let k in o) {
                if (new RegExp(`(${k})`).test(fmt)) {
                    let str = o[k] + '';
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : app.padLeftZero(str));
                }
            }
            return fmt;
        },
        padLeftZero: function (str) {
            return ('00' + str).substr(str.length);
        },
        optionsSet:function () {
            var self = app;
            var a = self.shipingTypeOption;// 设置运输方式
            for (var i = 0; i < a.length; i++) {
                if (a[i].value == self.order.shipingType) {
                    self.shipingTypeCurrentValue = a[i];
                }
            }

            var b = self.serviceTypeOption;// 设置服务方式
            for (var i = 0; i < b.length; i++) {
                if (b[i].value == self.order.serviceType) {
                    self.serviceTypeCurrentValue = b[i];
                }
            }

            var c = self.packingTypeOption;// 设置打包方式
            for (var i = 0; i < c.length; i++) {
                if (c[i].value == self.order.packingType) {
                    self.packingTypeCurrentValue = c[i];
                }
            }

            var d = self.distributionWayOption;// 设置打包方式
            for (var i = 0; i < d.length; i++) {
                if (d[i].value == self.order.distributionWay) {
                    self.distributionWayCurrentValue = d[i];
                }
            }
        },
        // **********************shipingType运输方式*****************************
        currentShipingTypeSelect(item){
            let self = this;
            self.shipingTypeCurrentValue = item
            this.changeShipingTypeSelect();
            this.$emit('input', item.value);
            var order = self.order;
            Vue.set(order, 'shipingType', item.value);
            self.order = order;
        },
        changeShipingTypeSelect(){
            this.selectShipingTypeShow = !this.selectShipingTypeShow;
        },
        //*****************ServiceType服务方式*********************
        currentServiceTypeSelect(item){
            let self = this;
            self.serviceTypeCurrentValue = item
            this.serviceTypeSelect();
            this.$emit('input', item.value);
            var order = self.order;
            Vue.set(order, 'serviceType', item.value);
            self.order = order;
        },
        serviceTypeSelect(){
            this.selectServiceTypeShow = !this.selectServiceTypeShow;
        },
        //********************PackingType打包方式******************
        currentPackingTypeSelect(item){
            let self = this;
            self.packingTypeCurrentValue = item
            this.packingTypeSelect();
            this.$emit('input', item.value);
            var order = self.order;
            Vue.set(order, 'packingType', item.value);
            self.order = order;
        },
        packingTypeSelect(){
            this.selectPackingTypeShow = !this.selectPackingTypeShow;
        },
        //*************************DistributionWay分拨方式*************
        currentDistributionWaySelect(item){
            let self = this;
            self.distributionWayCurrentValue = item
            this.distributionWaySelect();
            this.$emit('input', item.value);
            var order = self.order;
            Vue.set(self.order, 'distributionWay', item.value);
            self.order = order;
        },
        distributionWaySelect(){
            this.selectDistributionWayShow = !this.selectDistributionWayShow;
        },
    }
})
