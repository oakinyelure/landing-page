package com.campustradein.util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by Olusegun on 8/8/2016.
 */

public class JsonUtil{
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T fromJson(String jsonString, Class<T> objectClass){
        return new Gson().fromJson(jsonString, objectClass);
    }

    public static ResponseTransformer json(){
        return JsonUtil::toJson;
    }


}