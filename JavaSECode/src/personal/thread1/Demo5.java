package personal.thread1;

/*
4个售票员售票

分析:
  - 4个线程模拟4个售票员
  - 一份数据4个售票员卖1份票

采用线程与任务分离的方式
 */
public class Demo5 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t0 = new Thread(ticket);
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t0.start();
        t1.start();
        t2.start();
        t3.start();

    }
}

class Ticket implements Runnable{
    int num = 20;
    @Override
    public void run() {
//      线程同步处理,这里的this就是锁,解决临界资源问题 -- 线程安全
        synchronized (this) {
            while (true) {
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
                    System.out.println("剩余" + num);
//              System.out.println(Thread.currentThread().getName());
                } else {
                    return;
                }
            }
        }
    }
}
