package com.personal.study;

import java.util.HashMap;
import java.util.Map;

public class Demo4 {
    public static void main(String[] args) {
        String s = "aa@sohu.com,bb@163.com,cc@sina.com";
        String[] strings = s.split(",");
        Map<String,String> map = new HashMap<>();
        for (String string : strings) {
            String[] temp = string.split("@");
            map.put(temp[0],temp[1]);
        }
        System.out.println(map);
    }
}
