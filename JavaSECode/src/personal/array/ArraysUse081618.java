package com.info2soft;

import java.util.Arrays;

public class ArraysUse081618 {
    public static void main(String[] args) {
        //    选择排序
        int[] arr1={3,6,1,77,9,44,44,67,234,664,11,333};
        searchOrder(arr1);
//    冒泡排序
        int[] arr2={3,4,5,22,66,88,11,44,11,333,111,33,333,112};
        circolOrder(arr2);
//    二分查找
        int[] arr3={3,4,5,66,77,88,99,100,999};
        int temp =binriySearch(arr3,9999);
        System.out.println(temp);
    }

//选择排序
    public static void searchOrder(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minA = i;
            for (int j = i + 1; j < arr.length-1; j++) {
                if (arr[minA] > arr[j]) {
                    minA = j;
                }
                }
            if (minA != i) {
                int temp = arr[minA];
                arr[minA] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        }
//    冒泡排序
    public static void circolOrder(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[i+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
//    二分查找
    public static int binriySearch(int[] arr,int key){
        int min=0;
        int max=arr.length-1;
        while (min <= max) {
            int med = (min+max)/2;
            if (arr[med] == key){
                return med;
            }else if (arr[med] > key){
                max = med-1;
            }else {
                min = med+1;
            }
        }
        return -1;
    }

}
