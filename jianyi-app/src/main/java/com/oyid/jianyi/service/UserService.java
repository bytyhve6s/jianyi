package com.oyid.jianyi.service;

import com.oyid.jianyi.dto.User;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30.
 */
public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectAll();

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
