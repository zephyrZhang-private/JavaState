package com.info2soft;

public class Demo2 {
    public static void main(String[] args) {
        try{
        ExTest exTest = new ExTest();
        System.out.println(exTest.Math(5,0));
        }catch (Exception e){
            System.out.println("处理异常");
        }
        System.out.println("发生异常后的情况继续执行");

    }



}

class ExTest{
    public double Math(int a , int b){
        return Math.floorDiv(a, b);
    }
}
