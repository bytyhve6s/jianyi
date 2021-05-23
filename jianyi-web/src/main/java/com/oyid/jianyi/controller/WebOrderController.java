package com.oyid.jianyi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.oyid.jianyi.common.FastJsonUtil;
import com.oyid.jianyi.dto.Order;
import com.oyid.jianyi.dto.User;
import com.oyid.jianyi.feign.AppFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
@Controller
@RequestMapping("/")
public class WebOrderController {

    @Autowired
    private AppFeign appFeign;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(ModelMap map){
        String users = appFeign.queryUser();
        List<User> userList = FastJsonUtil.parseToList(users,User.class);

        String user = appFeign.queryUserById(1);
        User user1 = FastJsonUtil.parseToBean(user,User.class);

        String orders = appFeign.queryOrder();
        List<Order> orderList = FastJsonUtil.parseToList(orders,Order.class);

        String order = appFeign.queryOrderById(1);
        Order orders1 = FastJsonUtil.parseToBean(order,Order.class);
        map.put("test","哈哈哈");
        map.put("orders",orderList);
        return "index_new";
    }

    @RequestMapping(value = "/index_new",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject indexNew(ModelMap map){
        JSONObject jsonObject = new JSONObject();
        String orderAll = appFeign.queryOrder();
        List<Order> orderList = FastJsonUtil.parseToList(orderAll,Order.class);
        int mailingUserId = 0;
        int collUserId = 0;
        if(orderList != null && orderList.size() > 0){
            for (Order order : orderList){
                collUserId = order.getCollUserId();
                mailingUserId = order.getMailingUserId();
                break;
            }
        }
        String mailingUser = appFeign.queryUserById(mailingUserId);
        User mailUser = FastJsonUtil.parseToBean(mailingUser,User.class);
        String collUser = appFeign.queryUserById(collUserId);
        User coUser = FastJsonUtil.parseToBean(collUser,User.class);
        jsonObject.put("order",orderList);
        jsonObject.put("mailingUser",mailUser);
        jsonObject.put("collUser",coUser);
        return jsonObject;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public String index1(@RequestParam String name){
        User user = new User();
        user.setUserName(name);
        appFeign.addUser(user);
        return "success";
    }

    @RequestMapping(value = "/queryOrderById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryOrderById(ModelMap map, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String order = appFeign.queryOrderById(Integer.valueOf(id));
        Order orders = FastJsonUtil.parseToBean(order,Order.class);
        int mailingUserId = orders.getMailingUserId();
        int collUserId = orders.getCollUserId();
        String mailingUser = appFeign.queryUserById(mailingUserId);
        User mailUser = FastJsonUtil.parseToBean(mailingUser,User.class);
        String collUser = appFeign.queryUserById(collUserId);
        User coUser = FastJsonUtil.parseToBean(collUser,User.class);
        jsonObject.put("order",orders);
        jsonObject.put("mailingUser",mailUser);
        jsonObject.put("collUser",coUser);
        return jsonObject;
    }
}
