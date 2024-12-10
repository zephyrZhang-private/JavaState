package com.personal.study;

import java.util.HashMap;
import java.util.Map;

class Demo3 {
    public static void main(String[] args) {
        String[] strings = new String[5];
        strings[0] = "happy every day";
        strings[1] = "good morning";
        strings[2] = "what is happened";
        strings[3] = "so";
        strings[4] = "you are so stupid";

        Map<String,Integer> map = new HashMap<>();
        for (String member : strings) {
            for(String key : member.split(" ")){
                if (map.get(key) == null ){
                    map.put(key,1);
                }else {
                    map.put(key,map.get(key) + 1);
                }
            }
        }

        System.out.println(map);
    }
}
