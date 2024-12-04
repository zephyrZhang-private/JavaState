package com.personal.study;

import java.io.UnsupportedEncodingException;

/*
编码 - 解码
  * 常用字符集
   - 中国:GBK
   - 欧洲:ISO-8859-1
   - 通用:UTF-8
   - 美国 ASCII
  * 对中文的处理
   - GBK:2字节
   - ISO8859-1:1字节 | 不支持中文
   - utf-8:3字节
   - Unicode:2字节 | 内部编码
   说明:GBK UTF-8 支持中文,ISO8559-1不支持中文
  * 编码:将字符串转化成字节(byte)序列的过程
  * 解码:将字节(byte)序列转化成字符串的过程
  * 编码错误:乱码 -- 在执行读写时,由于使用的字符集不同,造成了编码的错误
    - 解决:再编码再解码
 */
public class Demo4 {
    public static void main(String[] args) throws UnsupportedEncodingException {
//      编码
        byte[] arr1 = "你好".getBytes();//没有参数是默认的编码格式,与当前的工程一致
        byte[] arr2 = "你好".getBytes("GBK");//编码格式是utf8
//      解码
        String string1 = new String(arr1, "GBK");//指定的解码字符集是GBK
//      arr1字节数组的编码(utf8)与解码(GBK)字符集格式不同,会乱码
        System.out.println(string1);//浣犲ソ
        String string2 = new String(arr2,"GBK");
        System.out.println(string2);//你好
    }
}
