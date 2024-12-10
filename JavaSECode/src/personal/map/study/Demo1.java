package personal.map.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo1 {
    public static void main(String[] args) {

        Map<String,Student> map = new HashMap<>();
        map.put("1001",new Student("王五",36,"软工"));
        map.put("1002",new Student("赵四",28,"电子"));
        map.put("1003",new Student("张三",21,"音乐"));
        map.put("1004",new Student("刘二",19,"美工"));
        map.put("1005",new Student("李一",22,"舞蹈"));

        for(String key:map.keySet()){
            System.out.println(key+":{"+map.get(key)+"}");
        }
        map.forEach((t1,t2)->System.out.println("{"+t1+":["+t2.getName()+","+t2.getAge()+","+t2.getMajor()+"]}"));
    }

    static class Student{
        private String name;
        private Integer age;
        private String major;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(major, student.major);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, major);
        }

        @Override
        public String toString() {
            return  "name='" + name + '\'' +
                    ", age=" + age +
                    ", major='" + major + '\'';
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

        public Student(String name, Integer age, String major) {
            this.name = name;
            this.age = age;
            this.major = major;
        }
    }
}
