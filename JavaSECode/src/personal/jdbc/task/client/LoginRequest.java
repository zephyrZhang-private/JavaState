package personal.jdbc.task.client;

import personal.jdbc.task.servlet.ServletRequest;
import util.entry.User;

import java.util.Scanner;

public class LoginRequest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请在控制台输入用户名");
        String username = scanner.nextLine();
        System.out.println("请在控制台输入用户密码");
        String password = scanner.nextLine();
        User user = new User(username, password);
        ServletRequest servletRequest=new ServletRequest();
        User u1 = servletRequest.findUser(user);
        if (u1 != null) {
            System.out.println("登录成功");
        }else System.out.println("无效用户");
    }
}
