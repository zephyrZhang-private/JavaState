package filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("*.do")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //多态,强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("userLogin");

        if (user == null) {
            System.out.println("用户未登录跳转了");
            //说明用户是未登录状态
            response.sendRedirect(request.getContextPath() + "/login.html");
        }else {
            //继续向后跳转到下一个过滤器或servlet
            filterChain.doFilter(request,response);
        }
    }
}
