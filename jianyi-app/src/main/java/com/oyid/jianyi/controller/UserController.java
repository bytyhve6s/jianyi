package com.oyid.jianyi.controller;

import com.oyid.jianyi.common.Result;
import com.oyid.jianyi.dto.User;
import com.oyid.jianyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oyid.jianyi.common.ResultGenerator.ok;

/**
 * Created by Administrator on 2018/1/30.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> addUser(@RequestBody User user) {
        userService.insert(user);
        return ok();
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result updateUser(@RequestBody User user) {
        userService.updateByPrimaryKey(user);
        return ok();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteUser(@PathVariable("id") int id) {
        userService.deleteByPrimaryKey(id);
        return ok();
    }

    /**
     * 通过主键查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryUserById/{id}",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> queryUserById(@PathVariable("id") int id){
        User user = userService.selectByPrimaryKey(id);
        return ok(user);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "/queryUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<User>> queryUser() {
        List<User> list = userService.selectAll();
        return ok(list);
    }
}
