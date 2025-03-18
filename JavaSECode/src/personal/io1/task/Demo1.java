package personal.io1.task;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) {
//        fileCopy();
        streamCopy();
    }

//  字符流拷贝
    public static void fileCopy(){
//          一次读取多个字符
        try (FileReader fileReader = new FileReader("src/com/personal/task1/demo1.txt");
             FileWriter fileWriter = new FileWriter("src/com/personal/task1/demo1FileCopy.txt")){

//            int num = 0;
//            char[] chars = new char[3];
//            while ((num = fileReader.read(chars)) != -1){
//                fileWriter.write(chars,0,num);
//            }

//          一次读取一行 -- 字符缓冲流特有
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/personal/task1/demo1.txt"));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/personal/task1/demo1Buffered.txt"))){

                String str ;
                while ((str = bufferedReader.readLine()) != null){
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//  字节流拷贝
    public static void streamCopy(){

//      一次拷贝一个字节
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/com/personal/task1/demo1.txt"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/com/personal/task1/demo1FileStream.txt"))){

//            int num = 0;
//            while ((num = bufferedInputStream.read()) != -1){
//                bufferedOutputStream.write(num);
//            }

//            一次读取多个字节
            int num=0;
            byte[] s = new byte[2];
            while ((num = bufferedInputStream.read(s)) != -1){
                bufferedOutputStream.write(s,0,num);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
