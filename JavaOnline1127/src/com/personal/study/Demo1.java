package com.personal.study;


import java.io.FileWriter;
import java.io.IOException;

/*
基本流的使用
分类：字节流、字符流
区别：
1.读字节、读字符
2.字符流有编码操作

-- 字符写出流
将Hello World 打印到txt文件中
以内存为参照，从内存输出到磁盘：输出流
hello world适用于字符流
FileWriter字符写出流
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
//        1.创建FileWriter对象,关联输出文件
//        FileWriter构造方法自动识别当前工程路径
//        如果创建文件已存在，直接覆盖
//        当前的路径必须实际存在，否则报错--FileNotFountException
//        异常的声明
        FileWriter fileWriter  = new FileWriter("a.txt");
//        2.写数据，执行writer方法时，只是写入了缓冲区，并没落盘
//        字符流变码操作就在缓冲区
        fileWriter.write("hello world");
//        3.刷新
//        把数据刷入磁盘
        fileWriter.flush();
//        4.关闭流
//        附加功能：完成最后的刷新
//        当流被关闭后，不能在继续写入数据
        fileWriter.close();
    }
}
