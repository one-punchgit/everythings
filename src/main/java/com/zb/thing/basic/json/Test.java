package com.zb.thing.basic.json;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zb.thing.basic.pojo.TimeSeriesModel;

public class Test {
    public static void main(String[] args) {
        String json = JsonUtils.getJson(new TimeSeriesModel());
        System.out.println(json);
//        String jsonString1 = "{ \"name\": " +
//                "\"John\"}";
//        String jsonString2 = "{ \"name\":\"John\"}";
//
//        System.out.println(isJsonEqual(jsonString1,jsonString2));

    }


    private static boolean isJsonEqual(String jsonStr1, String jsonStr2) {
        JsonObject obj = JsonParser.parseString(jsonStr1).getAsJsonObject();
        JsonObject obj1 = JsonParser.parseString(jsonStr2).getAsJsonObject();
        return obj.equals(obj1);
    }
}
