package com.info2soft;

import java.util.Arrays;

public class ArrayTest01 {
    //数组选择排序，[8,5,3,9,10,2]
    public static void main(String[] args) {
        int[] arr = {8,1000, 5, 3, 9, 10, 2,100,11,16,13,19,22,100,500 };
        toScore(arr);
        System.out.println(Arrays.toString(arr));
//        bubbleScot(arr);
//        System.out.println(Arrays.toString(arr));
    }

//    选择排序
    public static void toScore(int[] arr1){
        for (int i = 0; i < arr1.length - 1; i++) {
            int minA = i;
            for (int j = i+1; j < arr1.length ; j++) {
                if (arr1[minA] > arr1[j]) {
                    minA = j;
                }
            }
            if(i!=minA){
                int temp = arr1[i];
                arr1[i] = arr1[minA];
                arr1[minA]=temp;
            }
        }
    }
//    冒泡排序
    public static void bubbleScot(int[] arr1){
        for (int i = 0; i < arr1.length-1; i++) {
            for (int j = 0; j < arr1.length-1-i; j++) {
                if(arr1[j]>arr1[j+1]){
                    int temp = arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }
        }
    }
}
