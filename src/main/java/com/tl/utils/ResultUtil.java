package com.tl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-10-19 15:23
 **/
public class ResultUtil {
    private String message;
    private String info;

    private Object data;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static Map<String,Object> resultMap(String message,String info){
        Map<String,Object> resutl = new HashMap<>();
        resutl.put(message,info);
        return resutl;
    }

    public static Map<String,Object> resultMap(String message,String info,Object data){
        Map<String,Object> resutl = new HashMap<>();
        resutl.put(message,info);
        resutl.put("data",data);
        return resutl;
    }

}
