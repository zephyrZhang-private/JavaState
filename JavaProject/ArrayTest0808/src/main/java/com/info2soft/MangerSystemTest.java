package com.info2soft;

import java.util.Arrays;
import java.util.Scanner;

public class MangerSystemTest {
    public static void main(String[] args) {
        System.out.println("===============欢迎使用起义军数字管理系统===============");
        int[] arr = {1,5,6,3,8,4,52,1,45};
        int i;
        do {
            System.out.println("请选择功能:0、查找\t1、增加\t2、删除\t3、修改\t4、查看\t5、排序\t6、退出");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            if (i == 0){
                System.out.println("请输入要查找的数字");
                Scanner scanner1 = new Scanner(System.in);
                int num1 =  scanner1.nextInt();
                int num2 = search(arr,num1);
                System.out.println(num2);
            }
            else if (i == 1) {
                int[] arr1 = Arrays.copyOf(arr,arr.length+1);
                int temp = add();
                arr1[arr.length] = temp;
                System.out.println(Arrays.toString(arr1));
                arr = arr1;
            }
            else if (i == 2) {
                int d = delete(arr);if (d != -1){
                int[] arr1 = Arrays.copyOf(arr,arr.length-1);
                int num = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[d] != arr[j]){
                        arr1[num] = arr[j];
                        num++;
                    }
                }
                arr = arr1;
                System.out.println(Arrays.toString(arr));} else if (d == -1) {
                    System.out.println("找不到要删除的元素");
                }
            }
            else if (i == 3) {
                modify(arr);
            }
            else if (i == 4) {
                list(arr);
            }
            else if (i == 5) {
                order(arr);
            }
            else if (i == 6) {
                exit();
                System.out.println("程序正在退出ing.......");
            }
        } while (i > 0 && i < 7);
    }

    public static int search(int[] arr,int key){
        int count=1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] >= arr[i]){
                count++;
            }
        }
        if (count == arr.length){
            int min = 0;
            int max = arr.length-1;
            while (min <= max){
                int med = (min+max)/2;
                if (arr[med] > key){
                    max = med;
                }else if (arr[med] < key){
                    min = med;
                }else {
                    return med;
                }
            }
            return -1;
        } else{
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == key){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int add() {
            System.out.println("请输入要添加的数字");
            Scanner sc1 = new Scanner(System.in);
            int a = sc1.nextInt();
            return a;
    }
    public static int delete(int[] arr) {
        System.out.println("请输入要删除的数字");
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] ==d){
                return i;
            }
        }
        return -1;
    }
    public static void list(int[] arr){
        System.out.println(Arrays.toString(arr));
        System.out.println("此功能是显示所有元素，如需查找，选择功能0");
    }
    public static void modify(int[] arr){
        System.out.println("请输入要修改的数字");
        Scanner scanner = new Scanner(System.in);
        int temp1 = scanner.nextInt();
        System.out.println("请输入要重新载入的数字");
        Scanner scanner1 = new Scanner(System.in);
        int temp2 = scanner1.nextInt();
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == temp1){
                arr[i] = temp2;
        }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void order(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void exit(){
        System.exit(0);
    }


}
