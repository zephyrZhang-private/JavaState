package personal.thread1.task;

/*
写出以下程序可能得执行结果

class MyThread extends Thread{
	public void run()
	{
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("MyThread running");
	}
}
public class ThreadTest{

	public static void main(String argv[])
		{
			MyThread t = new MyThread();
			t.run();
			t.start();
			System.out.println("Thread Test");
	    }
}

结果：
  MyThread running
  Thread Test
  MyThread running

*/

public class task3 {
    public static void main(String argv[])
    {
        MyThread t = new MyThread();
        t.run();
        t.start();
        System.out.println("Thread Test");
    }
}
class MyThread extends Thread{
    public void run()
    {
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("MyThread running");
    }
}