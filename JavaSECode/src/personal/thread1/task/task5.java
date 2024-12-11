package personal.thread1.task;

/*
总经理今天很忙

任务清单:
开除那个不靠谱的副总经理;
给各部门总监开会;
陪VIP客户吃饭,打牌,KTV,桑拿,按摩...;
去香港给妻子买个 华为牛逼版 作为生日礼物;
去机场接女儿送到公司旁边的希尔顿饭店休息;
陪老妈去医院看腰间盘突出;
辅导儿子做作业
请帮助总经理用多线程的方式完成今天的任务

*/

public class task5 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        T4 t4 = new T4();
        T5 t5 = new T5();
        T6 t6 = new T6();
        T7 t7 = new T7();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}

class T1 extends Thread{
    @Override
    public void run() {
        System.out.println("开除那个不靠谱的副总经理");
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        System.out.println("给各部门总监开会");
    }
}

class T3 extends Thread{
    @Override
    public void run() {
        System.out.println("陪VIP客户吃饭,打牌,KTV,桑拿,按摩...");
    }
}

class T4 extends Thread{
    @Override
    public void run() {
        System.out.println("去香港给妻子买个 华为牛逼版 作为生日礼物");
    }
}

class T5 extends Thread{
    @Override
    public void run() {
        System.out.println("去机场接女儿送到公司旁边的希尔顿饭店休息");
    }
}

class T6 extends Thread{
    @Override
    public void run() {
        System.out.println("陪老妈去医院看腰间盘突出");
    }
}

class T7 extends Thread{
    @Override
    public void run() {
        System.out.println("辅导儿子做作业");
    }
}