package personal.io2.study;

import java.io.*;

/*
转换流

  * 转换输入流：可以指定字符集读取某个文件的数据
  * 转换输出流：可以指定字符集将数据写入某个文件

作用：可以实现字节流和字符流的转化，并设置编码，一些常用的字符流直接继承自转换流，实现编码功能

  * 字节流 -- 操作的字节
  * 字符流 -- 操作的字符

编码：字符转字节
解码：字节转字符
 */
public class Demo2 {
    public static void main(String[] args) {
//        read();
        write();
    }

    public static void read(){
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("src/com/personal/study/Demo1.java"),"utf-8")){
            char[] arr = new char[128];
            int num = 0;
            while ((num=in.read(arr)) != -1){
                System.out.println(new String(arr,0,num));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void write(){
        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("demo2.txt",true),"utf-8")){
            out.write("Hello Demo2 utg8编码");

            out.write("这里是Demo2的write方法");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
