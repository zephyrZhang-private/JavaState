package com.info2soft;

import java.util.HashSet;
import java.util.Objects;

/*
HashSet
set:无序,不可重复
无序:插入顺序与存储顺序不一致，存储后位置固定
 */
public class Demo4 {
    public static void main(String[] args) {
//        HashSet<String> hashSet1 = new HashSet();
//        hashSet1.add("java");
//        hashSet1.add("php");
//        hashSet1.add("c++");
//        hashSet1.add("python");
//        System.out.println(hashSet1);
//        String s = "java";
//        String s1 = "php";
//        String s2 = "c++";
//        String s3 = "python";
//        System.out.println(s.hashCode()%16);
//        System.out.println(s1.hashCode()%16);
//        System.out.println(s2.hashCode()%16);
//        System.out.println(s3.hashCode());
        HashSet<Person> set = new HashSet();
        set.add(new Person("wangwu",20));
        set.add(new Person("zhangsan",21));
        set.add(new Person("lisi",22));
        set.add(new Person("wangwu",21));
        System.out.println(set);
    }
    static class Person{
        private String name;
        private int age;

        public Person(){}
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
//            return name.hashCode()+age*100;
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
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
    }
}