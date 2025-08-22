package filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class LoginFilter implements Filter{

    private static final Set<String> whiteList = new HashSet<>();

    // 在类加载时初始化白名单
    static {
        whiteList.add("/userServlet");       // 登录请求
        whiteList.add("/login.jsp");         // 登录页面
        whiteList.add("/register.jsp");      // 注册页面
        whiteList.add("/static/");           // 静态资源目录
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();

        for (String item : whiteList) {
            if (uri.contains(item)) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        //从session中获取用户状态
        User user = (User) request.getSession().getAttribute("user");
        if (user ==null){
            System.out.println("用户未登录跳转到登录页面......");
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
        }else {
            //继续向下跳转到过滤器或者servlet
            filterChain.doFilter(request, response);
        }
    }
}
