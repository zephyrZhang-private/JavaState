package com.personal.study;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
打印流:特殊功能的流,实现打印
  特殊方法:
    println
    print
分类:
  * 字节打印流 -- PrintStream
  * 字符打印流 -- PrintWriter

 */
public class Demo3 {
    public static void main(String[] args){
//      标准输出流是字节打印流 -- 默认绑定控制台
        PrintStream printStream = System.out;
        printStream.println("你好,我是标准输出流,我是字节打印流");
        printStream.close();
//      字节打印流 -- 支持绑定三种设备
        /*
        支持绑定的设备越多越好
        - File类型的文件
        - 字符串类型的文件
        - 字节输出流
         */

        try (
//      File类型文件绑定
        PrintStream printStream1 = new PrintStream(new File("demo3.txt"));
//      字符串类型文件绑定
        PrintStream printStream2 = new PrintStream("demo3.txt");
//      字节输出流
        PrintStream printStream3 = new PrintStream(new FileOutputStream("demo3.txt"));
        ){
//          解释 println方法的优点
//          353: 00000000 00000000 00000001 01100001 字节流只识别一个字节,高三位砍掉,01100001 -- 97 --  a
            printStream1.write(353);
            printStream1.println();
//          353: 00000000 00000000 00000001 01100001
//          print实现原理:先将353转换成字符串,在转换成字节数组
            printStream1.write(String.valueOf(353).getBytes());
            printStream1.println(353);//这里不是353,而是3 5 3字符串,使用print方法打印出来的都是字符串
        }catch (IOException e){
            e.printStackTrace();
        }

        /*
        字符打印流
        - File类型文件
        - 字符串类型文件
        - 字节输出流
        - 字符写出流
         */

//      注意!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        /*
        方法: public PrintWriter(Writer out , boolean autoFlush){}
        autoFlush - boolean 变量
        true: println printf 或 format 方法将自动刷新输出缓冲区
        但是执行print方式时需要手动刷新
         */
        try(
                PrintWriter printWriter = new PrintWriter(new File("demo3.txt"));
                PrintWriter printWriter1 = new PrintWriter("demo3.txt");
                PrintWriter printWriter2 = new PrintWriter(new FileOutputStream("demo3.txt"));
                PrintWriter printWriter3 = new PrintWriter(new FileWriter("demo3.txt"))
                ) {

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
