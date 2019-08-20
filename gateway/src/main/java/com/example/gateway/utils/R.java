package com.example.gateway.utils;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/20 11:30
 */
public class R {

    private int code;
    private String msg;

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
