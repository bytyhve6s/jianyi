/**
 * Created by Administrator on 2018/2/5.
 */
var app = new Vue({
    el: '#app',
    data: {
        isActive: false,
        appShow: true,
        successFlag: false,
        suc_flag: "",
        loaderModeFlag: false,
        agreementId: "",
        md5: "",
        serialNum: "",
        errorFlag: false,
        errorMsg: ""

    },
    created: function () {
        var self = this;
        self.init();
    },
    methods: {
        init:function () {
            var self = this;
            self.$http.get(contextPath + "/index_new",{
            }).then((response) => {
                console.log(response);
            },(response) => {

            });
        }

    }
})
