package com.ljn.util;

import java.util.HashMap;

public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private HashMap<String, Object> data = new HashMap<>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    private Result() {

    }

    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage("成功");
        result.setCode(1);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage("失败");
        result.setCode(0);
        return result;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(HashMap<String, Object> hashMap) {
        this.setData(hashMap);
        return this;
    }
}
