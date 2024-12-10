package personal.io2.study;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
Properties: 本质上就是Map
作用: 存储属性

文件格式是以键值对形式存在,并且以行为单位，一行是一个键值对
键值之间的间隔可以是等号(=)可以是空格( )或冒号(:)

优点：

 - 有几个好用的方法 -- load  store

 */
public class Demo6 {
    public static void main(String[] args) throws IOException {
//      系统的属性存储在一个.properties文件里面
        Properties properties = System.getProperties();
//      调用它的方法list关联标准输出流,直接将数据有格式的打印到控制台
//        properties.list(System.out);

//      可以使用properties存储Java项目中的属性信息
        Properties properties1 = new Properties();

//      读取文件信息 -- load方法是从文件加载数据到properties对象
        properties1.load(new FileReader("src/config.properties"));
        String v = properties1.getProperty("username");
        System.out.println("name:"+v);

//      遍历 -- propertyNames获取所有的key

        Set<String> set = properties1.stringPropertyNames();
        for (String s : set) {
            System.out.println("key:"+s+" value:"+properties1.getProperty(s));
        }

        properties1.setProperty("sex","man");
//      可以将数据写回磁盘
        properties1.store(new FileWriter("src/config.properties"),"change sex language");
    }
}
