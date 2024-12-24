package personal.thread3;

/*

案例：计算1-1000之间的和,用两个线程计算

*/

import java.util.concurrent.*;

public class Demo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> num1 = executorService.submit(new SumNumber1());
        Future<Integer> num2 = executorService.submit(new SumNumber2());
        int sum = num1.get()+num2.get();
        System.out.println("1-1000的和:" + sum);
        executorService.shutdown();
    }
}
class SumNumber1 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 500; i++) {
            sum+=i;
        }
        return sum;
    }
}
class SumNumber2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 500; i++) {
            sum+=i;
        }
        return sum;
    }
}