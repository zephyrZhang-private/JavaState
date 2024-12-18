package personal.thread2;

/*

线程安全问题:临界资源 --线程之间共享数据

  - 多个线程,一个任务,一份数据
  - 多个线程,多个任务,一份数据
    - 同时锁住多个线程
    - 利用数据对象

*/

public class Demo4 {
    public static void main(String[] args) {
        Message1 message1 = new Message1();

        Input1 input1 = new Input1(message1);
        Output1 output1 = new Output1(message1);

        Thread thread = new Thread(input1);
        Thread thread1 = new Thread(output1);

        thread.start();
        thread1.start();


    }
}


class Message1 {
    String name;
    int age;
    Boolean flag = false;

}


class Input1 implements Runnable {
    Message1 message1;

    public Input1(Message1 message1) {
        this.message1 = message1;
    }

    int i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (message1) {
                if (message1.flag == true) {
                    try {
                        message1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 0) {
                        message1.name = "张伟";
                        message1.age = 25;
                    } else {
                        message1.name = "房青霖";
                        message1.age = 37;
                    }
                    i = (i + 1) % 2;
                }
                message1.flag = !message1.flag;
                message1.notify();
            }
        }
    }
}

class Output1 implements Runnable {
    Message1 message1;

    public Output1(Message1 message1) {
        this.message1 = message1;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (message1) {
                if (message1.flag == false) {
                    try {
                        message1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(message1.name + message1.age);
                }
                message1.flag = !message1.flag;
                message1.notify();
            }
        }
    }
}



