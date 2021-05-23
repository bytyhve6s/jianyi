package com.oyid.jianyi.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oyid.jianyi.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
public class FastJsonUtil {

    public static JSONObject parseToJsonObject(String s) {
        return JSON.parseObject(s);
    }

    public static <T> List<T> parseToList(String s, Class<T> entityType) {
        JSONObject jsonObject = parseToJsonObject(s);
        ResultDto resultDto = JSON.toJavaObject(jsonObject, ResultDto.class);
        String content = resultDto.getContent();
        List<T> list = JSON.parseArray(content,entityType);
        return list;
    }

    public static <T> T parseToBean(String s, Class<T> entityType) {
        JSONObject jsonObject = parseToJsonObject(s);
        if (jsonObject != null) {
            JSON json = (JSON) jsonObject.get("content");
            return JSON.toJavaObject(json, entityType);
        }
        return null;
    }
}
