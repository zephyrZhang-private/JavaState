package personal.thread1.task;

import java.awt.*;
import java.util.Random;

/*有五个人同时过一个独木桥，一个独木桥同时只能允许一个人通过。
每一个人通过独木桥的时间是随机在 [5,10] 秒，
输出这个独木桥上每一个人的通过详情，
例如：张三开始过独木桥了... 张三通过独木桥了!*/
public class task2 {
    public static void main(String[] args) {

        Runnable runnable = new runnable();

        Thread thread0 = new Thread(runnable,"张三");
        Thread thread1 = new Thread(runnable,"李四");
        Thread thread2 = new Thread(runnable,"王五");
        Thread thread3 = new Thread(runnable,"赵六");
        Thread thread4 = new Thread(runnable,"老七");
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
    static class runnable implements Runnable{
        @Override
        public void run() {
            Random random = new Random();
            int time = random.nextInt(5) + 5;
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + ":开始过独木桥了");
                try {
                    Thread.sleep(time * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":通过独木桥了" + ",用时"+time + "秒");
            }
        }
    }
}
