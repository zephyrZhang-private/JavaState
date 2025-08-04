package feature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    servlet特性
        单例:单个实例,有生命周期
        多线程:分割CPU时间片,线程安全问题
*/
@WebServlet("life")
public class ServletLife extends HttpServlet {
    String name;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            this.name是成员变量,其生命周期与当前所在对象一致
            servlet被所有客户端共享,this.name也被共享,可能有线程安全问题
            一般不使用成员变量
        */
        synchronized (this) {
            this.name = req.getParameter("name");
            System.out.println(name);
        }
        /*因为value是局部变量,所以不会有线程安全问题*/
        String value = req.getParameter("value");
        System.out.println(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
