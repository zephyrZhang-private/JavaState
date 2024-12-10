package com.info2soft;

public class ClassTest01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "罗伟康";
        person.sex = "女";
        person.birthday = "2004-08-20 18:00:00";
        person.age = 18;
        person.favorite();
        person.callPhone("110");
    }
}

class Person{
    String name;
    int age;
    String birthday;
    String sex;

    public void favorite(){
        System.out.println("大家好，我是"+name+"，性别"+sex+"，于"+birthday+"时出生,今年刚满"+age+"岁，我的特长是唱、跳、rap，目前为止已经练习篮球两年半......");
    }

    public void callPhone(String telephone){
        System.out.println("看我"+name+"不顺眼，快打"+telephone+"搞我，求求你......");
    }
}