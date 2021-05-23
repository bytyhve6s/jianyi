/**
 * Created by Administrator on 2018/2/2.
 */
$(document).ready(function () {
    function orderClick(a) {

        var id = $(a).attr("orderId");
        $.ajax({
            url: "/queryOrderById",
            data: {
                id: id
            },
            type: "POST",
            success: function (data) {
                // 设置寄件人信息
                var mailingUser = data.mailingUser;
                $("#mailing_name").val(mailingUser.userName);
                $("#mailing_company").val(mailingUser.companyName);
                $("#mailing_address").val(mailingUser.address);
                $("#mailing_phone").val(mailingUser.mobilePhone);
                $("#mailing_tel").val(mailingUser.telphone);

                // 设置收件人信息
                var collUser = data.collUser;
                $("#coll_name").val(collUser.userName);
                $("#coll_company").val(collUser.companyName);
                $("#coll_address").val(collUser.address);
                $("#coll_phone").val(collUser.mobilePhone);
                $("#coll_tel").val(collUser.telphone);

                // 设置订单信息
                var order = data.order;
                $("#order_num").val(order.orderNum);
                $("#mailing_time").val(order.mailingTime);
                $("#mailing_state").val(order.mailingState);
                $("#destination").val(order.destination);
                $("#receiving_clerk").val(order.receivingClerk);
                $("#shiping_type").val(order.shipingType);
                $("#service_type").val(order.serviceType);
                $("#next_station").val(order.nextStation);
                $("#record_msg").val(order.recordMsg);
                $("#sign_msg").val(order.signMsg);
                $("#delivery").val(order.delivery);
                $("#since").val(order.since);

                // 设置货物信息
                $("#goods_length").val(order.goodsLength);
                $("#actual_weight").val(order.actualWeight);
                $("#distribution_way").val(order.distributionWay);
                $("#packing_num").val(order.packingNum);
                $("#goods_width").val(order.goodsWidth);
                $("#banlance_weight").val(order.banlanceWeight);
                $("#packing_type").val(order.packingType);
                $("#item_name").val(order.itemName);
                $("#goods_height").val(order.goodsHeight);
                $("#volume").val(order.volume);
                $("#over_length").val(order.overLength);
                $("#over_weight").val(order.overWeight);
                $("#max_length").val(order.maxLength);
                $("#over_weight_num").val(order.overWeightNum);
                $("#num").val(order.num);
                $("#receipt").val(order.receipt);
                $("#receipt2").val(order.receipt2);
                $("#declared_value").val(order.declaredValue);
                $("#goods_type").val(order.goodsType);
                $("#note").val(order.note);
            }
        })

        //function calculate() {
        $("#calculate").click(function () {
            var length = $("#goods_length").val();
            var width = $("#goods_width").val();
            var height = $("#goods_height").val();
            var num = $("#num").val();
            var v = length * width * height * num;
            $("#volume").val(v);
        })

    }
})

