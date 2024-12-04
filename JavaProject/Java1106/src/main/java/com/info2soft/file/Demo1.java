package com.info2soft.file;

import java.io.File;

public class Demo1 {
    public static void main(String[] args) {
        File file = new File("/Java1106");
//        boolean flag = file.mkdirs();
        boolean flag = file.delete();
        System.out.println(flag);

    }
}
