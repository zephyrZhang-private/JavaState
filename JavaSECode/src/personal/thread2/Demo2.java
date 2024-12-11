package personal.thread2;

/*

线程同步：同比代码块和同步方法
    同步代码块效率优于同步方法

*/

public class Demo2 {
    public static void main(String[] args) {
//      案例:两个线程打印1-10的数
        SyncBlock syncBlock = new SyncBlock();

        SyncMethod syncMethod = new SyncMethod();

        Thread thread = new Thread(syncMethod);
        Thread thread1 = new Thread(syncMethod);
        thread.start();
        thread1.start();
    }

    static class SyncBlock implements Runnable{
        int num = 10;
        @Override
        public void run() {
//          同步代码块
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i:" + i + " num:" + num--);
                }
            }
        }
    }

    static class SyncMethod implements Runnable{

        static int num = 10;
//      同步方法
        @Override
        public void run() {
            print();
        }

//      1.非静态同步方法
        public synchronized void print(){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " i:" + i + " num:" + num--);
            }
        }
//      2.静态同步方法
        static public synchronized void print1(){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " i:" + i + " num:" + num--);
            }
        }
    }
}
