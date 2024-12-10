package com.info2soft.collectionTest;

import java.util.*;

/*
HashSet和TreeSet区别
HashSet: 无序,不可重复 | 通过比较元素的hashcode和equals方法去重 | 底层数据结构是hash表
TreeSet: 有序,不可重复 | 通过调用元素的Comparable接口的compareTo方法或Comparator接口的compare方法 | 底层数据结构是二叉树
 */
public class Demo5 {
    public static void main(String[] args) {
        String string =
                "name:xiaoming,age:10岁,gender:male,height:172cm,weight:70kg\n" +
                        "age:20岁,height:177cm,name:xiaobai,weight:80kg,gender:male\n" +
                        "gender:female,height:176cm,weight:96kg,name:xiaolv,age:21岁\n" +
                        "gender:female,height:171cm,weight:66kg,name:xiaolv,age:25岁\n" +
                        "gender:female,height:176cm,weight:76kg,name:xiaolv,age:24岁\n" +
                        "gender:female,height:178cm,weight:75kg,name:xiaolv,age:22岁\n" +
                        "gender:female,height:168cm,weight:59kg,name:xiaolv,age:24岁\n" +
                        "gender:female,height:176cm,weight:66kg,name:xiaolv,age:45岁";

        List<Person> list = getData(string);
        System.out.println(list);
//        delData(list);
//        System.out.println(list);
        getAge(list);
        sortList(list);
        System.out.println(getList(list));

    }

    public static List<Person> getData(String line) {
        List<Person> list = new ArrayList<>();
        String[] s1 = line.split("\n");
        for (String s : s1) {
            list.add(new Person(s));
        }
        return list;
    }

    public static void delData(List<Person> list) {
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getAge() < 18) {
                iterator.remove();
            }
        }
    }

    public static void getAge(List<Person> list) {
        list.sort((p1, p2) -> p1.getAge() - p2.getAge());
        int sum = 0;
        for (Person person : list) {
            sum += person.getAge();
        }
        System.out.println("平均年龄：" + sum / list.size());
        System.out.println("最大年龄：" + list.get(list.size() - 1).getAge());
        System.out.println("最小年龄：" + list.get(0).getAge());
    }

    public static void sortList(List<Person> list) {
        list.sort((person1, person2) -> {
            int temp = person1.getAge() - person2.getAge();
            return temp == 0 ? person2.getHeight() - person1.getHeight() : temp;
        });
        System.out.println(list);
    }

    public static List<Person> getList(List<Person> list) {
        List<Person> list1 = new ArrayList<>();
        for (Person person : list) {
            if (person.getAge() >= 20 && person.getAge() <= 25 && person.getWeight() >= 60 && person.getWeight() <= 80) {
                list1.add(person);
            }
        }
        list1.sort((person1, person2) -> person1.getHeight() - person2.getHeight());
        return list1.subList(2,3);
    }


}


class Person {
    private enum Gender {
        male, female
    }

    private String name;
    private int age;
    private Gender gender;
    private int height;
    private int weight;

    public Person(String line) {
        String[] str = line.split(",");
        for (String s : str) {
            String[] temp = s.split(":");
            String key = temp[0].trim();
            String value = temp[1].trim();
            if (key.matches("name")) {
                this.name = value;
            } else if (key.equals("age")) {
                this.age = Integer.valueOf(value.replace("岁", ""));
            } else if (key.equals("height")) {
                this.height = Integer.valueOf(value.replace("cm", ""));
            } else if (key.equals("weight")) {
                this.weight = Integer.valueOf(value.replace("kg", ""));
            } else if (key.equals("gender")) {
                if (value.equals("male")) {
                    this.gender = Gender.male;
                } else this.gender = Gender.female;
            }
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + "岁" +
                ", gender=" + gender +
                ", height='" + height + "cm" +
                ", weight='" + weight + "kg" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && gender == person.gender && Objects.equals(height, person.height) && Objects.equals(weight, person.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, height, weight);
    }

    public Person() {
    }

    public Person(String name, int age, Gender gender, int height, int weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}