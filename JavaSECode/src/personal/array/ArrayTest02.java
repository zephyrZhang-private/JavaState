package com.info2soft;

/*
查找
1.顺序查找
2.二分查找
前提
数组必须是有序的
规律
1.找不到元素：返回-1
2.找到元素：返回下标
3.元素重复：找到第一个结束
 */
public class ArrayTest02 {
    public static void main(String[] args) {
//        顺序查找
        int[] arr1={1,2,999,35,45,88,99,333,66,55,999,999};
        int temp1 = normalSearch(arr1,999);
        System.out.println("普通查找下标为:"+temp1);
//        二分查找 --自写  有瑕疵
        int[] arr2={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int temp2 = erFenSearch(arr2,16);
        if(temp2 != -1){
            System.out.println("二分查找下标为:"+temp2);
        }else {
            System.out.println("二分查找错误:"+temp2);
        }
//        二分查找优化
//        中间开始查找
        int[] arr3={1,2,3,5,9,11,20,36,456,1236,9999};
        int temp3 = brianySearch(arr3,1236);
        System.out.println(temp3);

    }
//    顺序查找
    public static int normalSearch(int[] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
//    二分查找--使用for循环，但是未知循环次数不应该使用此方式
    public static int erFenSearch(int[] arr,int key){
        int min = 0;
        int max = arr.length-1;
        int med = (min+max)/2;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[med] == key){
                return med;
            }else if (arr[med] > key){
                max = med;
                med = (max+min)/2;
            }else {
                min = med;
                med = (max+min)/2;
            }
        }
        return -1;
    }

//    二分查找优化--不确定循环次数用while
    public static int erFenSearchPlus(int[] arr,int key){
        int min = 0;
        int max = arr.length-1;
//        定义条件：当最小下标和最大下标交叉或相等时，结束循环
        while(min <= max){
            int med = (min+max)/2;
            if(arr[med] == key){
                return med;
            } else if (arr[med] > key) {
                max = med-1;
            }else {
                min = med+1;
            }
        }
        return -1;
    }

//  二分查找复习书写
    public static int brianySearch(int[] arr , int key){
        int min=0;//记录下标最小值
        int max=arr.length-1;//记录下标最大值
//      原理：通过中间下标的值对比，进行二段查找，未知循环次数，使用while
        while (min<=max){//最小下标大于最大下标时结束循环
            //计算中间下标，二分查找核心
            int med=(max+min)/2;
            if (arr[med] == key){
                return med;
            } else if (arr[med] > key) {
                max = med-1;
            }else {
                min = med+1;
            }
        }
        return -1;
    }
}
