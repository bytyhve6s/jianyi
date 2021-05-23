package com.oyid.jianyi.controller;

import com.oyid.jianyi.common.Result;
import com.oyid.jianyi.dto.Order;
import com.oyid.jianyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oyid.jianyi.common.ResultGenerator.ok;

/**
 * Created by Administrator on 2018/1/30.
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 增加订单
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> addOrder(@RequestBody Order order) {
        orderService.insert(order);
        return ok();
    }

    /**
     * 更新订单
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result updateOrder(@RequestBody Order order) {
        orderService.updateByPrimaryKey(order);
        return ok();
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteOrder(@PathVariable("id") int id) {
        orderService.deleteByPrimaryKey(id);
        return ok();
    }

    /**
     * 通过主键查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryOrderById/{id}",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Order> queryOrderById(@PathVariable("id") int id){
        Order order = orderService.selectByPrimaryKey(id);
        return ok(order);
    }
    /**
     * 查询所有订单
     *
     * @return
     */
    @RequestMapping(value = "/queryOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<Order>> queryOrder() {
        List<Order> list = orderService.selectAll();
        return ok(list);
    }
}
