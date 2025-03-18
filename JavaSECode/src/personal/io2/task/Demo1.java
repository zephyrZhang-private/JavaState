package personal.io2.task;

import java.io.*;
import java.util.Properties;

public class Demo1 {
    public static void main(String[] args) throws IOException {

        int count = 1;
        File file = new File("src/com/personal/task2/demo1.properties");
        if (!file.exists()){
            file.createNewFile();
            Properties properties = new Properties();
            FileOutputStream fileOutputStream = new FileOutputStream("src/com/personal/task2/demo1.properties");
            properties.setProperty("price",count + "");
            properties.store(fileOutputStream,"createFile");
            fileOutputStream.close();
        } else {
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));

            String string = properties.getProperty("price");
            int i = Integer.parseInt(string);


            if ( i>= 5){
                System.out.println("请注册");
            }else {
                i+=count;
                properties.setProperty("price",i + "");
                properties.store(new FileOutputStream("src/com/personal/task2/demo1.properties"),"Remember price");
            }
        }
    }
}
