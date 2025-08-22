package filter;


import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login.jsp")
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String autoLogin = request.getParameter("autoLogin");

        if (autoLogin != null) {
            String username = autoLogin.split(":")[0];
            String password = autoLogin.split(":")[1];
            User user = new User(username, password);

            UserService userService = new UserServiceImpl();
            User user1 = userService.findUserByUser(user);
            if (user1 != null) {
                //将完整的user信息写进session
                request.getSession().setAttribute("user", user1);
                //跳转进书城首页
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
            }
        }else
            filterChain.doFilter(request, response);
    }
}
