package servletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/servletContext")
public class ServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        javax.servlet.ServletContext servletContext = this.getServletContext();

        //获取项目的真实路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("项目真实路径:"+realPath);

        //获取上下文路径 -- 设置访问URL为/时，输出空
        System.out.println("servletContext:"+servletContext.getContextPath());
        System.out.println("request:"+req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
