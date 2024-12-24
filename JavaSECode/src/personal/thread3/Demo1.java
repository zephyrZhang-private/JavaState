package personal.thread3;

/*

线程池：使用线程池增加线程的复用性，提高内存的工作效率

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) {
//      第一种:创建有固定线程数量的线程池,参数表示指定的线程个数
//      会自动创建三个线程放入线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);

//      创建任务对象
        Ticket ticket = new Ticket();

//      四个售票员
//      通过线程池的submit方法提交并执行任务 -- 线程回自动启动并执行任务
        executorService.submit(ticket);
        executorService.submit(ticket);
        executorService.submit(ticket);
        executorService.submit(ticket);

//      关闭线程池 -- 等所有线程任务执行完才会关闭
        executorService.shutdown();
    }
}

class Ticket implements Runnable {
    int num = 20;
    Object o = new Object();

    @Override
    public void run() {
//      线程同步处理,这里的this就是锁,解决临界资源问题 -- 线程安全
        //注意:不能直接将new的对象放在锁的位置
        while (true) {
            synchronized (o) {
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
//                    System.out.println("剩余" + num);
//                    System.out.println(Thread.currentThread().getName());
                } else {
                    return;
                }
            }
            System.out.println("剩余" + num);
            System.out.println(Thread.currentThread().getName());
        }

    }
}
