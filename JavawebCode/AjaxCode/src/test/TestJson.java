package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestJson {
    @Test
    public void test1() throws IOException {
        Person person = new Person();
        person.setUsername("John");
        person.setAge(22);
        person.setAddress("USA");
        person.setBirthday(new Date());

        //将person类型的数据转换成json格式字符串
        ObjectMapper mapper = new ObjectMapper();
        String json_value = mapper.writeValueAsString(person);
        System.out.println(json_value);

        //将json格式的数据转换成java对象
        Person p = mapper.readValue(json_value,Person.class);
        System.out.println(p);
    }

    @Test
    public void test2() throws IOException {
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("Mark",22,"USA",new Date());
        Person person2 = new Person("Eric",37,"CHN",new Date());
        Person person3 = new Person("Mark",62,"ENG",new Date());
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        //将list数据转换成json格式的数据
        ObjectMapper mapper = new ObjectMapper();
        String json_value = mapper.writeValueAsString(persons);
        System.out.println(json_value);

        //将json格式的数据转换成list集合
        List list = mapper.readValue(json_value,new TypeReference<List<Person>>(){});
        System.out.println(list);
    }

    @Test
    public void test3() throws IOException {

        Map<String,Person> map = new HashMap<>();
        Person person1 = new Person("Mark",22,"USA",new Date());
        Person person2 = new Person("Eric",37,"CHN",new Date());
        Person person3 = new Person("Mark",62,"ENG",new Date());
        map.put("p1",person1);
        map.put("p2",person2);
        map.put("p3",person3);

        ObjectMapper mapper = new ObjectMapper();

        //将map集合转换成json格式的数据
        String json_value = mapper.writeValueAsString(map);
        System.out.println(json_value);

        //将json字符串转换成map
        Map<String,Person> map1 = mapper.readValue(json_value,new TypeReference<Map<String,Person>>(){});
        System.out.println(map1);
    }
}
