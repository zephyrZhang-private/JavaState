package requestResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletDemo01 extends HttpServlet {
    /*
    HttpServletRequest:是请求的子类,完成客户端到服务器的功能
    HttpServletResponse:是响应的子类,完成服务器到客户端的功能

    案例: 从客户端发送用户名和密码到服务器,与已知数据对比
         ==返回登陆成功
         !=返回登陆失败
        1. 客户端发送数据:http://localhost:8080/demo01?username=zhangsan&password=123456
        2. 服务器在doGet方法中(默认Get请求),接受数据:request对象的String get Parameter(String,name)方法
        3. 判断结果，响应对应信息:response对象的流
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决客户端到服务器的编码
        req.setCharacterEncoding("UTF-8");

        //接受客户端的数据
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");

        //解决服务器到客户端的编码
        resp.setContentType("text/html;charset=utf-8");

        //通过这个流,将响应写回客户端
        PrintWriter out = resp.getWriter();
        if (name.equals("zhangsan") && pwd.equals("123456")) {
            //登陆成功
            out.write("登陆成功");
        }else {
            //登陆失败
            out.write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
