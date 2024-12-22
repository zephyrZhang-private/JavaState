package personal.thread2;

/*

生产者和消费者的概念
通过两个线程  两个人任务 一份数据去研究
模拟打印机打印输出
一个输入 一个输出
连续不间断  使用线程同步

*/

public class Demo6 {
    public static void main(String[] args) {
        Data1 data = new Data1();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }

}
class Data1{
    String name;
    int age;
    boolean flag = false;

    public  void setData(String name,int age){
        if (flag == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name;
            this.age = age;
        }
        flag = !flag;
        notify();
    }

    public void getData(){
        if (flag == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +"\t"+ age);
        }
        flag = !flag;
        notify();
    }

}

class Producer implements Runnable{
    int num = 0;
    Data1 data;


    public Producer(Data1 data) {
        this.data = data;
    }


    @Override
    public void run() {
        while (true){
            synchronized (data){
                if (num == 0){
                    data.setData("ZhangSan" ,18);
                }else {
                    data.setData("LangSing" ,28);
                }
                num=(num+1)%2;
            }
        }
    }
}

class Consumer implements Runnable{
    Data1 data;
    public Consumer(Data1 data){this.data = data;}
    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                data.getData();
            }
        }
    }
}
