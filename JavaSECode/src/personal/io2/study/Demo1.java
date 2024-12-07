package com.personal.study;

import java.io.IOException;
import java.io.InputStream;

/*
IO流

标准输入输出流
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
//      标准输入流,in是System类的一个字段
//      “标准”输入流,此流已打开并准备提供输入数据,通常,此流对应于键盘输入或者主机环境或用户指定的另一个输入源
//      这个流是默认打开的,并且关联的设备默认是控制台--键盘
        InputStream in = System.in;
//      read成为阻塞式方法;让程序停滞某个状态,用户输入结束后,程序继续
//        int s = in.read();
        while (true){
            int s = in.read();
//          "标准"输出流,此流已打开并准备接收输出数据,通常,此流对应于显示器输出或者由主机环境或用户指定的另一个输出目标
            System.out.println(s);
        }
    }
}