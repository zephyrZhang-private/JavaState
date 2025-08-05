package controller;

import entity.User;
import service.LoginService;
import service.impl.LoginServiceImpl;
import utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String remember = req.getParameter("rememberMe");

        User user = new User(username, password);
        LoginService loginService = new LoginServiceImpl();
        User user1 = loginService.findUser(user);

        String verifyCode=(String) req.getSession().getAttribute("verifyText");

        //测试验证问题点
        System.out.println("verifyCode:"+verifyCode);
        //对比验证码容易出问题,有需要可以忽略大小写
        if (user1 != null && code.equalsIgnoreCase(verifyCode)) {
            //保存登录状态
            req.getSession().setAttribute("user", user1);

            //复选框 记录cookie回传客户端
            if (remember != null) {
                CookieUtil.setCookie("userinfo",username+":"+password,req,resp);
            }else {
                CookieUtil.removeCookie("userinfo",req,resp);
            }
            //登录成功后转发到empInfo页面
            req.getRequestDispatcher("/empInfo").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
