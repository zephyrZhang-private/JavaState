package personal.io1.task;

import java.io.*;

public class Demo2 {

    public static void main(String[] args) {

        charUpDown();
    }

    public static void charUpDown(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/personal/task1/demo2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/personal/task1/demo2UpDown.txt"))){

            int num = 0;
            while ((num = bufferedReader.read()) != -1){
                if (65 <num && num <90){
                    bufferedWriter.write(num+32);
                }
                if (97 < num && num < 122){
                    bufferedWriter.write(num-32);
                }if (num == 32 || num ==10){
                    bufferedWriter.write(num);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
