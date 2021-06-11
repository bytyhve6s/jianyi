package com.oyid.jianyi.feign;

import com.alibaba.fastjson.JSON;
import com.oyid.jianyi.dto.Order;
import com.oyid.jianyi.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
@FeignClient(value = "jianyi-app", fallback = AppHystrixFallBack.class)
public interface AppFeign {

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User user);

    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
    public String updateUser(@RequestBody User user);

    @RequestMapping(value = "/user/deleteUser/{1}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id);

    @RequestMapping(value = "/user/queryUserById/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String queryUserById(@PathVariable("id") int id);

    @RequestMapping(value = "/user/queryUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String queryUser();

    @RequestMapping(value = "/order/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order);

    @RequestMapping(value = "/order/updateOrder", method = RequestMethod.POST)
    public String updateOrder(@RequestBody  Order order);

    @RequestMapping(value = "/order/deleteOrder/{id}", method = RequestMethod.POST)
    public String deleteOrder(@PathVariable("id") int id);

    @RequestMapping(value = "/order/queryOrderById/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String queryOrderById(@PathVariable("id") int id);

    @RequestMapping(value = "/order/queryOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String queryOrder();
}
