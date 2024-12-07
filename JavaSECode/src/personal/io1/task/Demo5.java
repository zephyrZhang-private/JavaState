package com.personal.task1;

import java.io.*;

public class Demo5 {
    public static void main(String[] args) {
        readThreeJavaFile();
    }

    public static void readThreeJavaFile(){
        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/com/personal/task1/Demo1.java"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/com/personal/task1/Demo2.java"));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader("src/com/personal/task1/Demo3.java"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/personal/task1/demo5.txt"))){

                String data;
                while ((data = bufferedReader1.readLine()) != null){
                    bufferedWriter.write(data);
                    bufferedWriter.newLine();
                }
            while ((data = bufferedReader2.readLine()) != null){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            while ((data = bufferedReader3.readLine()) != null){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
