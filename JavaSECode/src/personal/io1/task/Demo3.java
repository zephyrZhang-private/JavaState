package personal.io1.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Demo3 {
    public static void main(String[] args) {
        writeRandomNum();
    }

    public static void writeRandomNum(){
        Random random = new Random();
/*        try (PrintWriter printWriter = new PrintWriter ("src/com/personal/task1/demo3.txt")){
            int num = 1;
            while (num <101){
                int i = random.nextInt(10000);
                printWriter.print(num);
                printWriter.print("、");
                printWriter.print(i);
                printWriter.println();
                num++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
 */

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/personal/task1/demo3new.txt"))){
            for (int i =0; i<100 ; i++){
                bufferedWriter.write(i+".."+random.nextInt(20000));
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
