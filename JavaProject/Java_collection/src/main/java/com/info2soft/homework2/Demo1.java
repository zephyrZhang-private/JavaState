package com.info2soft.homework2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo1 {
    public static void main(String[] args) {
        Map<String,Class> map1 = new HashMap<>();
        map1.put("1001",new Class("张惠妹",22,"表演","一班"));
        map1.put("1002",new Class("胡歌",18,"音乐","一班"));
        map1.put("1003",new Class("张艺兴",21,"医学","一班"));
        map1.put("1004",new Class("王嘉梅",28,"畜牧兽医","一班"));
        Map<String,Class> map2 = new HashMap<>();
        map2.put("2001",new Class("张惠妹",22,"表演","二班"));
        map2.put("2002",new Class("胡歌",18,"音乐","二班"));
        map2.put("2003",new Class("张艺兴",21,"医学","二班"));
        map2.put("2004",new Class("王嘉梅",28,"畜牧兽医","二班"));

        for (String key:map1.keySet()) {
            System.out.println("学号："+key+map1.get(key));
        }

        for (String key:map2.keySet()) {
            System.out.println("学号："+key+map2.get(key));
        }
    }

}
class Class{
    private String name;
    private Integer age;
    private String major;
    private String classes;

    @Override
    public String toString() {
        return "," +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(name, aClass.name) && Objects.equals(age, aClass.age) && Objects.equals(major, aClass.major) && Objects.equals(classes, aClass.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, major, classes);
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Class(String name, Integer age, String major, String classes) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.classes = classes;
    }
}
