import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
实例：使用字符流将a.txt拷贝到c.txt
先从a.txt读入内存
在从内存写出到c.txt

代码的简化

自动关闭流
 */
public class Demo4 {
    public static void main(String[] args) {

//      自动关闭流，将流的声明创建放在try后的()中
//      实现了Closable方法的流都可以自动关闭
        try (FileReader fileReader = new FileReader("a.txt"); FileWriter fileWriter = new FileWriter("c.txt");) {
            int num = 0;
            char[] chars = new char[2];//大小小于等于1kb
            while ((num = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, num);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

