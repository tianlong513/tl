package com.tl.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.mail.HtmlEmail;

import java.util.List;
import java.util.Map;

/**
 * @program: tl
 * @description: 邮箱验证码
 * @author:
 * @create: 2018-11-02 09:44
 **/
public class EmailUtil {
    /**
     * 调用天气接口发送邮箱
     *
     * @param emailAddress 邮箱地址
     * @param city         地区代码
     * @throws Exception
     */
    public static void emailSend(String emailAddress, Integer[] city) throws Exception {
        HtmlEmail email = new HtmlEmail();
        //邮箱服务器地址
        email.setHostName("smtp.163.com");
        email.setCharset("utf-8");

        //收件人
        email.addTo(emailAddress);
        email.setFrom("quantianlong0420@163.com");

        email.setAuthentication("quantianlong0420@163.com", "tl12345678");

        String message = null;
        for (int cityLnegth = 0; cityLnegth < city.length; cityLnegth++) {
            String toDay = null;
            String notice = null;
            String tomorrow = null;
            //市
            String parent = null;
            //区
            String qu = null;

            //调用天气接口
            JSONObject jsonObject = null;
            String url = "http://t.weather.sojson.com/api/weather/city/" + city[cityLnegth];
            String strResult = HttpClientUtils.doGet(url, null);
            jsonObject = JSON.parseObject(strResult);
            int i = 0;
            //获取data下的字字符串
            String data = jsonObject.getString("data");
            //获取地区信息
            String cityInfo = jsonObject.getString("cityInfo");
            Map cityInfoMap = JSONObject.parseObject(JSONObject.parseObject(cityInfo).toString(), Map.class);
            Map map = JSONObject.parseObject(data);
            List<Object> list = JSONObject.parseArray(map.get("forecast").toString());
            System.out.println(cityInfo);
            for (Object o : list) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> m = mapper.readValue(o.toString(), Map.class);
                if (i == 0) {
                    notice = m.get("notice").toString();
                    toDay = "今日温度:" + m.get("high") + "--" + m.get("low");
                } else {
                    tomorrow = "明日温度:" + m.get("high") + "--" + m.get("low");
                }
                i++;
                if (i > 1) {
                    break;
                }
            }
            if (message == null) {
                message = cityInfoMap.get("parent") + " " + cityInfoMap.get("city") + ":\n" + toDay + "\t" + notice + "\n" + tomorrow + "\n\n";
            } else {
                message += cityInfoMap.get("parent") + " " + cityInfoMap.get("city") + ":\n" + toDay + "\t" + notice + "\n" + tomorrow + "\n\n";
            }
        }
        email.setSubject("生活的理想，就是为了理想的生活!");
        email.setMsg(message);
        email.send();
    }

    public static void main(String[] args) throws Exception {
        Integer[] city = {101020300, 101020500, 101020900,101250101,101250501};
        String email = "927920568@qq.com";
        emailSend(email, city);
    }

}
