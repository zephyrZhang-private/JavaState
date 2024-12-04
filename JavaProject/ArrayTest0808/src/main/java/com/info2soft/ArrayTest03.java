package com.info2soft;

import java.util.Arrays;

public class ArrayTest03 {
    public static void main(String[] args) {
        int[] arr1={4,5,9,52,32,11,25,114,44,1,2,3,4};
//      复制数组
        int[] rest1= Arrays.copyOf(arr1,10);
        System.out.println("rest1:"+Arrays.toString(rest1));
//      范围复制
        int[] rest2 = Arrays.copyOfRange(arr1,arr1.length-5,20);
        System.out.println("rest2:"+Arrays.toString(rest2));
//      对比数组
        boolean rest3 = Arrays.equals(arr1,rest2);
        System.out.println(rest3);
//      填充
        int[] rest4 = Arrays.copyOfRange(arr1,0,5);
        Arrays.fill(rest4,50);
        System.out.println(Arrays.toString(rest4));
//      排序--升序  使用的是快排和归并排序  比较复杂
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
//      二分查找
        int rest5 = Arrays.binarySearch(arr1,32);
        System.out.println(rest5);

    }
}
