package filter;

import entity.User;
import service.LoginService;
import service.impl.LoginServiceImpl;
import utils.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/login.html")
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取cookie的userInfo信息
        String userinfo = CookieUtil.getCookie("userinfo",request);

        //判断用户是否存在
        if (userinfo != null) {
            //将用户名、密码从userinfo中取出,访问数据库,获取完整用户信息
            String name = userinfo.split(":")[0];
            String password = userinfo.split(":")[1];
            User user = new User(name,password);
            LoginService loginService = new LoginServiceImpl();
            User u = loginService.findUser(user);
            //将完整的用户信息放入session,跳转到/empInfo
            if (u != null) {
                request.getSession().setAttribute("userLogin",u);
                response.sendRedirect(request.getContextPath()+"/emp.do");
            }else  {
                System.out.println("AutoLoginElse");
                response.sendRedirect(request.getContextPath()+"/login.html");
            }


        }else {
            //跳转到login.html登录
            filterChain.doFilter(request,response);
        }
    }
}
