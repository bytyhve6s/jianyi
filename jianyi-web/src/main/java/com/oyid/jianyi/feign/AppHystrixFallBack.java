package com.oyid.jianyi.feign;

import com.alibaba.fastjson.JSON;
import com.oyid.jianyi.dto.Order;
import com.oyid.jianyi.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
@Component
public class AppHystrixFallBack implements AppFeign {
    @Override
    public String addUser(@RequestBody User user) {
        return null;
    }

    @Override
    public String updateUser(@RequestBody User user) {
        return null;
    }

    @Override
    public String deleteUser(@PathVariable("id") int id) {
        return null;
    }

    @Override
    public String queryUserById(@PathVariable("id") int id) {
        return null;
    }

    @Override
    public String queryUser() {
        return null;
    }

    @Override
    public String addOrder(@RequestBody Order order) {
        return null;
    }

    @Override
    public String updateOrder(@RequestBody Order order) {
        return null;
    }

    @Override
    public String deleteOrder(@PathVariable("id") int id) {
        return null;
    }

    @Override
    public String queryOrderById(@PathVariable("id") int id) {
        return null;
    }

    @Override
    public String queryOrder() {
        return null;
    }
}
