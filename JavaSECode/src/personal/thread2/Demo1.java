package personal.thread2;

/*
4个售票员售票

分析:
  - 4个线程模拟4个售票员
  - 一份数据4个售票员卖1份票

采用线程与任务分离的方式
 */
public class Demo1 {
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
    Object o = new Object();
    @Override
    public void run() {
        /*
        synchronized 隐式的同步
        结构：synchronized(锁){//获取锁
                  同步的代码,是互斥的,同步的代码是单线程的
            }//释放锁
            锁自身具备的特点
             - 被所有线程共享 --唯一
             - 必须是一个实体 --对象

            谁能当锁
             - this
             - 字节码文件对象 --当在静态方法中使字节码文件对象,this不能在静态方法中使用,字节码文件对象生命周期与工程一致
             - 一个普通的对象

             同步案例
             String StringBuffer 安全的 StringBuilder 不安全的
             ArrayList 不安全的  Vector  安全的

 */
//      线程同步处理,这里的this就是锁,解决临界资源问题 -- 线程安全

//        synchronized (o){//使用普通对象作为锁
//        synchronized (this) {//使用this作为锁
//        synchronized (Ticket.class) {//使用字节码文件对象作为锁,一般只用this
        synchronized (o){//注意:不能直接将new的对象放在锁的位置
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
