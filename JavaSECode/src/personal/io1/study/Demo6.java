package personal.io1.study;

import java.io.*;

/*
缓冲流：本身也是流，但是它没有读写能力，只能提高读写的效率 --催化剂

代码分析：缓冲流内部接收了读入写出流类型，通过调用普通流完成读写与关闭

分类：
1.字节缓冲输入流  BufferedInputStream
2.字节缓冲输出流  BufferedOutputStream
3.字符缓冲读入流  BufferedReader
4.字符缓冲写出流  BufferedWriter

实例：使用缓冲流实现文件内容拷贝

a.txt -> e.txt
 */
public class Demo6 {
    public static void main(String[] args) throws IOException {
//      1.缓冲流不能读写，只能提高效率，需要借助普通流实现读入、写出操作

        BufferedReader bufferedReader = new BufferedReader(new FileReader("e.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("f.txt"));

//      2.完成读写 -- 方法与普通流一样
//        一次读取一个字符
        int num = 0;
//        while ((num=bufferedReader.read()) != -1){
//            bufferedWriter.write(num);
//        }

//        一次读取多个字符
//        char[] chars = new char[2];
//        while ((num=bufferedReader.read(chars)) != -1){
//            bufferedWriter.write(chars,0,num);
//        }

//        字符缓冲流特有：一次读取一行；字节缓冲流没有
        /*
        readline
        返回值是当前行的内容，数据读完时，返回null
        原理：遇到换行符，停止读,不读换行符
        需要补充换行符
         */
        String data;
        while ((data = bufferedReader.readLine()) != null){
            bufferedWriter.write(data);
          /*
          平台不一样,换行符的表示不一样
            1.\r\n
            2.\n
          解决：newline,跨平台的换行方式
           */
            bufferedWriter.newLine();
        }


//      3.关闭流，此处未实现自动关闭流功能
        bufferedReader.close();
        bufferedWriter.close();
    }
}
