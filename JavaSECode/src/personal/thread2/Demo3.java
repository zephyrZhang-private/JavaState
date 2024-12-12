package personal.thread2;

/*

线程安全问题:临界资源 --线程之间共享数据

  - 多个线程,一个任务,一份数据
  - 多个线程,多个任务,一份数据
    - 同时锁住多个线程
    - 利用数据对象

*/

public class Demo3 {
    public static void main(String[] args) {
        Message message = new Message();

        Input input = new Input(message);
        Output output = new Output(message);

        Thread thread = new Thread(input);
        Thread thread1 = new Thread(output);

        thread.start();
        thread1.start();


    }
}


class Message {
    String name;
    int age;
}


class Input implements Runnable {
    Message message;

    public Input(Message message) {
        this.message = message;
    }

    int i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (message) {
                if (i == 0) {
                    message.name = "张伟";
                    message.age = 25;
                } else {
                    message.name = "房青霖";
                    message.age = 37;
                }
                i = (i + 1) % 2;
            }
        }
    }
}

class Output implements Runnable {
    Message message;

    public Output(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (message) {
                System.out.println(message.name + message.age);
            }
        }
    }
}



