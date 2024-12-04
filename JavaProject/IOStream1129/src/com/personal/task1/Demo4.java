package com.personal.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) {

        javaChar();
    }
    public static void javaChar(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/personal/task1/demo4.txt"))){

            int num = 0;
            while (num <65536){
                bufferedWriter.write((char) num);
                if (num%100 == 0){
                    bufferedWriter.newLine();
                    bufferedWriter.write(num);
                }
                num++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
