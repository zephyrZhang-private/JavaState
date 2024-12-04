package com.info2soft.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo2 {
    public static void main(String[] args) {
        String[] strings = getData();
        Map<String,String> map = setHashMap(strings);
        System.out.println(map);
    }

    public static String[] getData(){
        String s = "aa@sohu.com,bb@163.com,cc@sina.com";
        return s.split(",");
    }

    public static Map<String, String> setHashMap(String[] strings){
        HashMap<String,String> hashMap = new HashMap<>();
        for (String string : strings) {
            String[] str = string.split("@");
            String key = str[0].trim();
            String  value = str[1].trim();
            hashMap.put(key,value);
        }
        return hashMap;
    }
}
