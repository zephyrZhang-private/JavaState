package com.personal.study;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//有一个字符串"josgjsjagwajsogiseafgjwsjgvoier"
//要求:1.转化成字符串 :  a(字符的个数)b()c()..   2.区分大小写   3.只读取字母
public class Demo5 {
    public static void main(String[] args) {
        String s = "josgjsja@@gwajsogis!!eafgjws==jgvoie-r";
        char[] chars = s.toCharArray();
//        System.out.println(Arrays.toString(chars));
        Map<Character,Integer> map = new HashMap<>();

        for (char c : chars) {
            if(65 <= c && c <= 90 || 97 <= c && c <= 122){
                if(map.get(c) == null){
                    map.put(c,1);
                }else {
                    map.put(c,map.get(c) + 1);
                }
            }
        }

        System.out.println(map);

    }
}
