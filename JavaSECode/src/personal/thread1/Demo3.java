package personal.thread1;

/*
线程创建

 - 只靠系统的线程,无法完成自定义的功能,可以自己创建线程  --Tread类
 - 系统任务区:run方法

案例:需要打印1-10的数
  - 通过创建Thread类的子类,重写run方法实现,通过线程与任务绑定去工作,灵活性很低
  - 将任务剥离出来,Thread只做线程的工作,让runnable做任务,线程需要功能时,将任务指给相关线程
 */


public class Demo3 {
    public static void main(String[] args) {

//      多态:父类引用指向子类对象
//      new出来的对象就处于新生态 --只是一个对象而已,不能抢CPU
        Thread thread = new MyThread();
//      start就绪态 --有抢CPU能力
        thread.start();
//      如果直接手动调用run方法,它只是一个普通方法,没有任务区的功能
//      调用方法的位置是什么线程.方法的里面就是什么线程 --main
//      run作为任务区,一旦手动调用就会工作,违背了就绪态抢CPU的工作原理,必须通过start进入就绪态
//        thread.run();


//      Thread.currentThread().getName():获取当前线程的名字 --主线程名字:main
        System.out.println(Thread.currentThread().getName() + " main");
    }
}

//创建Thread的子类,重写run方法,实现自定义功能
class MyThread extends Thread{
    @Override
//  run就是任务区
    public void run() {
        for (int i = 1; i <= 10; i++) {
//          Thread.currentThread().getName():获取当前线程的名字
//          子线程的名字Tread-x  x从0开始取值
            System.out.println(Thread.currentThread().getName()+" i:"+i);
        }
    }
}