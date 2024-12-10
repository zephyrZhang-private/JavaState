package com.info2soft;

import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
        System.out.println("insert username");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        System.out.println("insert passwd");
        Scanner scanner1 = new Scanner(System.in);
        String passwd = scanner1.nextLine();
        System.out.println("insert email");
        Scanner scanner2 = new Scanner(System.in);
        String mail = scanner2.nextLine();
        if(id.isEmpty() || passwd.isEmpty()){
            new Net();
        } else if (mail.isEmpty()) {
            Net net = new Net(id,passwd);
            net.cloud();
        }else if(id != null && !"".equals(id) && !"".equals(passwd) && passwd != null && mail != null && !"".equals(mail)){
            Net net = new Net(id,passwd,mail);
            net.cloud();
        }
    }
}
class Net{
    String id;
    String passwd;
    String mail;
    public Net(){
        System.out.println("gun,do not J8 go dead,please input passwd and username");
    }
    public Net(String id , String passwd){
        this.id = id;
        this.passwd = passwd;
        this.mail=id+"@email.com";
    }
    public Net(String id , String passwd , String mail){
        this.id=id;
        this.passwd=passwd;
        this.mail=mail;
    }

    public void cloud(){
        System.out.println(id+"\n"+passwd+"\n"+mail);
    }

}