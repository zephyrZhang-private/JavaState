package personal.thread1;

/*
将任务剥离出来,Thread只做线程的工作,让runnable做任务,线程需要功能时,将任务指给相关线程


工作中多使用线程与任务分离的方式

实现灵活性和可操作性
*/

public class Demo4 {
    public static void main(String[] args) {
//      只是创建了一个任务
        Test test = new Test();

//      我有两个线程
//      把任务同时指给了两个线程  -- start即可
        Thread t1 = new Thread(test);
        t1.start();

        Thread t2 = new Thread(test);
        t2.start();
    }
}

//只是任务类 -- 跟线程没有关系
class Test implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i:" +i);
        }
    }
}