package controller;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.CookieUtil;
import utils.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();


    //登陆功能代码,方法名与登陆隐藏域action值相等
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String autoLogin = req.getParameter("autoLogin");

        User loginUser = userService.login(username, password);
        if (loginUser == null) {
            req.setAttribute("msg","信息错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            //将用户信息保存在session作用域中
            req.getSession().setAttribute("user",loginUser);
            //记住密码复选框被选中
            if (autoLogin != null) {
                //记录cookie回传客户端
                CookieUtil.setCookie("autoLogin",username+":"+password,req,resp);
            }else {
                CookieUtil.removeCookie("autoLogin",req,resp);
            }
            resp.sendRedirect(req.getContextPath() + "/pages/user/login_success.jsp");
        }
    }

    //注册功能代码,方法名与登陆隐藏域action值相等
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前台提交的用户名\密码\邮箱\验证码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //获取用户输入验证码
        String code = req.getParameter("code");

        //获取session作用域中验证码
        String validate_code = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        User user = EntityUtils.copyParamToBean(req.getParameterMap(),new User());
        if (validate_code.equals(code)){
            if (userService.checkUsername(username)){
                req.getSession().setAttribute("msg","用户名已存在");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            }else {
                //userService.register(new User(null, username, password, email));
                userService.register(user);
                //取出user所有信息放入session
                userService.findUserByUser(user);
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }

    //注销代码
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session对象
        req.getSession().invalidate();
        //清理cookie
        CookieUtil.removeCookie("autoLogin",req,resp);
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
