package personal.thread1.task;

import java.util.Random;

/*
一个线程打印0-9的随机数字，
一个线程打印随机的26个小写字母。
*/
public class task4 {
    public static void main(String[] args) {
        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(26)+ 'a';

        Runnable runnable1 = ()->{
            System.out.println(Thread.currentThread().getName()+":"+num1);
        };

        Runnable runnable2 = ()->{
            System.out.println(Thread.currentThread().getName()+":"+(char) num2);
        };

        Thread thread = new Thread(runnable1,"线程1");
        Thread thread1 = new Thread(runnable2,"线程2");
        thread.start();
        thread1.start();
    }
}
