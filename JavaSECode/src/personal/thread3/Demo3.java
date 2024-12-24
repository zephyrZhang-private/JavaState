package personal.thread3;

/*

Callable接口：与Runnable接口类似，实现之后表示一个线程任务
Callable具有泛型返回值，可以声明异常
Runnable的run方法无法声明异常，只能异常处理
原型：
public interface Callable<V>{
    public V call() throws Exception;
}

*/

import java.util.concurrent.*;

public class Demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//      创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//      返回值是一个Future对象
        Future future = executorService.submit(new MyCallable());
//      接收返回值通过Future的get方法,get方法是个阻塞式方法,会等到任务执行完,接收返回值
        System.out.println(future.get());
//      关闭线程池
        executorService.shutdown();
    }
}
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
        return 666+"";
    }
}