package servletTest;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/*
第二种创建servlet的方法:通过继承实现servlet接口的子类GenericServlet
  优点:简化代码
  缺点:难处理请求方式
*/
public class Servlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet02");
//        post方法的处理
//        get方法的处理
    }
}
