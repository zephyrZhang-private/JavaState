package personal.thread1;

/*
演示多个线程同时工作:两个线程
任务区:指的是当前线程完成功能的地方,同过方法描述
  - 主线程
    - 任务区 main方法
  - 垃圾回收线程
    - 原理:通过每个对象的finalize方法对当前对象的内存进行回收
    - 任务区 finalize()方法

注意:
  - 多个线程之间一定是抢CPU,我们永远不要试图干预CPU的行为
  - 任务区执行完成后,线程立即结束,进程中所有线程结束后,进程结束
  - 如果任务没有结束,线程不会结束
 */

public class Demo2 {
    public static void main(String[] args) throws InterruptedException { //主线程
        new Person();//垃圾
        //垃圾回收机制的开关 -- 马上启动垃圾回收
        System.gc();

//      sleep后面的单位是毫秒
//      作用:让当前线程休息1000毫秒,休息期间不会抢CPU
        Thread.sleep(1000);
        System.out.println("main");
    }
    static class Person{
//      注意:finalize方法在实现功能时不能重写,此处重写的目的是为了研究多线程的工作
//      只要person的对象被当作垃圾回收，就会触发垃圾回收线程，从而触发这个方法
        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize");
        }
    }
}
