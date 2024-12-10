package personal.thread1.task;

/*
实例化两个线程，同时对一个数字进行操作。
一个线程对这个数字进行加1，另外一个线程对这个数字进行减一。
输出每一次的操作之后的这个数字的值。
*/

public class task1 {

    static int number = 20;

    public static void main(String[] args) {
        Thread thread0 = new Thread(new Sum(),"加");
        thread0.start();
        Thread thread1 = new Thread(new Subtract(),"减");
        thread1.start();
    }

    static class Sum implements Runnable{
        @Override
        public void run() {
           number++;
            System.out.println(Thread.currentThread().getName() + " number:"+number);
        }
    }

    static class Subtract implements Runnable{
        @Override
        public void run() {
            number--;
            System.out.println(Thread.currentThread().getName() + " number:"+number);
        }
    }

}