/**
 * Created by Administrator on 2018/2/8.
 */
var app = new Vue({
    el: '#app',
    data: {
        mailingUser: "",
        collUser: "",
        order: ""
    },
    created: function () {
        var self = this;
        self.oneOrder();
    },
    methods: {
        oneOrder: function () {
            var id = getUrlParam("id");
            if (!id) {
                this.$messagebox.confirm("订单id丢失，请重新进入").then(action => {
                });
            }
            var self = this;
            self.$http.get(contextPath + "/queryOrderById", {params: {id: id}}).then((response) => {
                var order = response.data.order;
                var mailingUser = response.data.mailingUser;
                var collUser = response.data.collUser;
                self.setOrderMailingUser(order, mailingUser);
                self.setOrderCollUser(order, collUser);
                Vue.set(order, 'mailingTime', self.formatDate(new Date(order.mailingTime), "yyyy年MM月dd"));
                self.order = order;
                //self.optionsSet();
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
        },
        setOrderCollUser: function (obj, collUser) {
            // 收件人信息
            Vue.set(obj, 'collUserId', collUser.id);
            Vue.set(obj, 'collUserName', collUser.userName);
            Vue.set(obj, 'collMobilePhone', collUser.mobilePhone);
            Vue.set(obj, 'collAddress', collUser.address);
            Vue.set(obj, 'collTelphone', collUser.telphone);
            Vue.set(obj, 'collCompanyName', collUser.companyName);
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
    }
})