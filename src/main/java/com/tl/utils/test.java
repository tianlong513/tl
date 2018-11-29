package com.tl.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-21 16:30
 **/
public class test {
    public static void main(String[] args) throws Exception {
        //调用天气接口
        JSONObject jsonObject = null;
        String url = "http://t.weather.sojson.com/api/weather/city/" + 101020500;
        String strResult = HttpClientUtils.doGet(url, null);
        jsonObject = JSON.parseObject(strResult);
        int i = 0;
        String data = jsonObject.getString("data");
        Map map = JSONObject.parseObject(data);
        List<Object> list = JSONObject.parseArray(map.get("forecast").toString());

        for (Object o : list) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> m = mapper.readValue(o.toString(), Map.class);
            if (i == 0) {
                System.out.println("今日温度:" + m.get("high") + "--" + m.get("low"));
            } else {
                System.out.println("明日温度:" + m.get("high") + "--" + m.get("low"));
            }
            i++;
            if (i > 1) {
                break;
            }
        }


    }
}
