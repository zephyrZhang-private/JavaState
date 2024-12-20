package personal.thread2;

/*

理解生产者消费者之间的概念
两个线程 两个任务 一份数据
生产 消费 数据

代码优化，与Demo4无大差异
数据载入和数据输出的任务交给数据对象，而不是打印和载入任务

*/


public class Demo5 {
    public static void main(String[] args) {
        Data data = new Data();
        InputTask task = new InputTask(data);
        Thread thread = new Thread(task);
        thread.start();
        OutputTask task1 = new OutputTask(data);
        Thread thread1 = new Thread(task1);
        thread1.start();
    }
}

class Data {
    String name;
    int age;
    Boolean flag = false;

    public void setData(String name, int age) {
        if (flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.name = name;
        this.age = age;
        flag = !flag;
        notify();
    }

    public void getData() {
        if (flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " " + age);
        }
        flag = !flag;
        notify();
    }
}


class InputTask implements Runnable {
    Data data;

    public InputTask(Data data) {
        this.data = data;
    }

    int i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                if (i == 0) {
                    data.setData("张三", 18);
                } else {
                    data.setData("李四", 20);
                }
                i = (i + 1) % 2;
            }
        }
    }
}

class OutputTask implements Runnable {
    Data data;

    public OutputTask(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                data.getData();
            }
        }
    }
}