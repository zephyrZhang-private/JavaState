package com.personal.study;

import java.io.FileReader;
import java.io.IOException;

/*
基本流的使用 -- 字符读入流

练习：将a.txt的数据显示在控制台
字符流：读入-写出
分析：a.txt -> 内存 -> console
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
//        1.创建字符读入流 - FileReader
        FileReader fileReader = new FileReader("b.txt");
//        2.read一次读取一个字符，自动指向下一个
//        返回值：字符ASCII码，遇到空打印-1
        int num = 0;
//        while ((num = fileReader.read()) != -1){
//            System.out.println((char) num);
//        }
//        3.读取多个字符
        /*
        read(数组)
        这方法每次读到的多个字符被放入数组中，可以将这批数据从数组中取出
        返回值：每次读到的真实字符的个数，返回-1时表示结束
         */
        char[] chars = new char[2];
//        num = fileReader.read(chars);
//        System.out.println(new String(chars)+num);
//        num = fileReader.read(chars);
//        System.out.println(new String(chars )+num);
//        num = fileReader.read(chars);
//        System.out.println(new String(chars)+num);
//        num = fileReader.read(chars);
//        System.out.println(new String(chars)+num);
        while ((num = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, num) + "字符个数：" + num);
        }
        fileReader.close();
    }


}
