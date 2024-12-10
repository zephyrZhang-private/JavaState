package com.info2soft.map;

import java.util.*;

/*
HashSet和HashMap:
单列集合和双列集合
HashSet的值等同于HashMap的key，他们的底层实现都是哈希表
HashMap也是去重，无序
map.put方法，key相同时，会覆盖value的值
map.putIfAbsent方法，key相同时，不覆盖value
 */

/*
有一个字符串"josgjsjagwajsogi!!!*se**af(gjwsjgvoier"
要求:1.转化成字符串 :  a(字符的个数)b()c()..   2.区分大小写   3.只读取字母
 */

/*
1、切割串存人数组
2、过滤特殊符号
3、装入map
4、打印map
 */
public class Demo1 {
    public static void main(String[] args) {
        char[] chars = getData();
        System.out.println(Arrays.toString(chars));
        Map<Character,Integer> map = new HashMap<>();
        map = setMap(chars);
        System.out.println(map);
        String s = getMap(map);
        System.out.println(s);
    }

    public static char[] getData(){
        String str = "josgjsjagwaj!!sogi**seaf((gjwsj))gvoier";
        char[] chars = str.toCharArray();
        char[] chars1 = new char[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ( c>=65 && c <=90 || c >= 97 && c<= 122 ){
                chars1[index] = c;
                index ++;
            }
        }
        return Arrays.copyOf(chars1,index);
    }
     public static Map<Character, Integer> setMap(char[] chars){
        Map<Character,Integer> map= new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (map.containsKey(c)){
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else {
                map.put(c, 1);
            }
        }
//        System.out.println(map);
        //Map集合转Set集合，利用entry特性
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(set);
        list.sort((c1,c2)->c1.getKey().compareTo(c2.getKey()));
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
            linkedHashMap.put(characterIntegerEntry.getKey(),characterIntegerEntry.getValue());
        }
        return linkedHashMap;
    }
//    public static String getMap(Map<Character,Integer> map){
//        StringBuffer sb = new StringBuffer();
//        for (Character k:map.keySet()){
//            Integer v = map.get(k);
//            sb.append(k+"("+v+")");
//        }
//        return sb.toString();
//    }
    public static String getMap(Map<Character,Integer> map){
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        Iterator<Map.Entry<Character,Integer>> iterator = set.iterator();
        StringBuffer stringBuffer = new StringBuffer();
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            stringBuffer.append(entry.getKey()+"("+entry.getValue()+")");
        }
        return stringBuffer.toString();
    }

}
