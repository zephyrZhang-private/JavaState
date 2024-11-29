package com.personal.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
字节流

字符流：有编码操作的字符
字节流：操作字节

实例：使用字节流拷贝b.txt到d.txt

1.使用字节输入流写入到内存
2.使用字节输出流实现拷贝

 */
public class Demo5 {
    public static void main(String[] args) {
//        创建输入输出流
        try(FileInputStream fileInputStream = new FileInputStream("b.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("d.txt");
            FileOutputStream fileOutputStream1 = new FileOutputStream("e.txt")) {
//            一次读一个字节到d.txt
//            int num=0;
//            while ((num=fileInputStream.read())!=-1){
//                fileOutputStream.write(num);
//            }

//            一次读多个字节到e.txt
            int num1 = 0 ;
            byte[] bytes = new byte[2];
            while ((num1=fileInputStream.read(bytes))!=-1){
                fileOutputStream1.write(bytes,0,num1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
