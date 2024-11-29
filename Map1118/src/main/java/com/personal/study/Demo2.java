package com.personal.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo2 {
    public static void main(String[] args) {

        Map<String , Student> map = new HashMap<>();
        map.put("Class1",new Student("1001","Jack"));
        map.put("Class1",new Student("1002","July"));
        map.put("Class2",new Student("2001","Rose"));
        map.put("Class2",new Student("2002","Mark"));

        for(String key:map.keySet()){
            System.out.println(key+map.get(key));
        }
        map.forEach((t1,t2)->{
            System.out.println(t1+t2.getSno()+t2.getName());
        });
    }
    static class Student{
        private String sno;
        private String name;

        @Override
        public String toString() {
            return "Student{" +
                    "sno='" + sno + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(sno, student.sno) && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sno, name);
        }

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(String sno, String name) {
            this.sno = sno;
            this.name = name;
        }
    }
}
