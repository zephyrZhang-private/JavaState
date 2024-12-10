package personal.io1.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
实例：使用字符流将a.txt拷贝到c.txt

分析：
FileWriter、FileReader
1.先从a.txt读入内存
2.在从内存写出到c.txt
 */
class Demo3 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("a.txt");
            fileWriter = new FileWriter("c.txt");
//            读写
            int num = 0;
            char[] chars = new char[2];//大小小于等于1kb
            while ((num = fileReader.read(chars)) != -1){
                fileWriter.write(chars,0,num);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileReader != null || fileWriter != null){
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }}




    }
}
