package com.oyid.jianyi.dto;

/**
 * Created by Administrator on 2018/1/31.
 */
public class ResultDto {

    private String status;//状态：=> SUCCESS or ERROR

    private String msg;//提示信息

    private String content;//SUCCESS状态返回内容部分

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
