package com.info2soft;

import java.util.Arrays;

public class ArraysUse0816 {
    public static void main(String[] args) {
//        将两个数组合并
        int[] arr1={1,5,6,33,77,45,63};
        int[] arr2={7,12,11,56,84,10,2};
//        for循环遍历
        test1(arr1,arr2);
//        工具copyOf
        test2(arr1,arr2);
//        copyOf与System.arrayscopy连用
        test3(arr1,arr2);
    }
//    for循环遍历存储
    public static void test1(int[] arr1,int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length+i] = arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
    public static void test2(int[] arr1,int[] arr2){
        int[] arr3 = Arrays.copyOf(arr1,arr1.length+arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            arr3[i+arr1.length] = arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
    public static void test3(int[] arr1,int[] arr2){
        int[] arr3=Arrays.copyOf(arr1,arr1.length+arr2.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
        System.out.println(Arrays.toString(arr3));
    }


}
