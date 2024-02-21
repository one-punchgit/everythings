package com.zb.thing.basic.json;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;

public class JsonUtils {

    /**
     * 对象转 json 字符串
     *
     * @param object 待转的对象
     * @return
     */
    public static String getJson(Object object) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }

    /**
     * json 字符串转对象
     *
     * @param jsonString 待转的 json 字符串
     * @return
     */
    public static Object getObject(String jsonString, Class c) {
        //第一个参数待转的 json 字符串  第二个参数  待转的实体类对象
        return JSON.parseObject(jsonString, c);
    }

}