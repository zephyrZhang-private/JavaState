package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 为了简化代码,减少servlet数量,利用隐藏域
 * 通过获取隐藏域的值,反射掉用class文件创建对应的对象
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Method method;
        try {
            method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            //执行方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
