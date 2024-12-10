package com.info2soft.homework1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Demo1 {
    public static void main(String[] args) {
        Map<String,Student> map= new HashMap<>();
        map.put("1001",new Student("zhangsan",18,"软工"));
        map.put("1002",new Student("lisi",18,"造价"));
        map.put("1003",new Student("wangwu",18,"土木"));
        map.put("1004",new Student("maliu",18,"新闻"));
        for(String key: map.keySet()){
            System.out.println(key+map.get(key));
        }
    }
}

class Student{
    private String name;
    private Integer age;
    private String major;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, major);
    }

    public Student(String name, Integer age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }
}
