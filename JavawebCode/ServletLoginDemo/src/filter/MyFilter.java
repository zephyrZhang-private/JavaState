package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//想过滤哪个服务器就写哪个服务器路径 -- @WebFilter过滤器注解
//特定的过滤器功能,过滤编码解码问题,到达所有服务器前都要到达过滤器,过滤器路径设置/*
@WebFilter("/servletContext")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---初始化---");
    }

    @Override
    //工作的方法
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        System.out.println("---过滤前---");
        //向后传递
        filterChain.doFilter(servletRequest,servletResponse);

        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("---过滤后---");
    }

    @Override
    public void destroy() {
        System.out.println("---销毁---");
    }
}
