package com.personal.study;

import java.io.*;

/*
字节缓冲流的使用

实例：字节缓冲流实现拷贝

f.txt -> g.txt

 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
//      1.创建缓冲字节流，借助普通流完成读写
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("f.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("g.txt"));

//      2.完成读写
//      一次读取一字节
        int num = 0;
//        while ((num = bufferedInputStream.read()) != -1 ){
//            bufferedOutputStream.write(num);
//        }

//      一次读取多个字节
        byte[] bytes = new byte[2];
        while ((num = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,num);
        }

//      3.关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
