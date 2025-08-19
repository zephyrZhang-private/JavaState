package controller;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            User loginUser = userService.login(username, password);
            if (loginUser == null) {
                req.setAttribute("msg","信息错误");
                req.setAttribute("username",username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }else {
                resp.sendRedirect(req.getContextPath() + "/pages/user/login_success.jsp");
            }
        }else if (action.equals("register")) {
            //获取前台提交的用户名\密码\邮箱\验证码
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String code = req.getParameter("code");

            if (code.equalsIgnoreCase("abcd")){
                if (userService.checkUsername(username)){
                    req.getSession().setAttribute("msg","用户名已存在");
                    req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
                }else {
                    userService.register(new User(null, username, password, email));
                    req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
                }
            }else {
                req.setAttribute("msg","验证码错误");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
