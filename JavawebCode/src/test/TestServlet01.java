package test;
import javax.servlet.*;
import java.io.IOException;

/*
    Servlet是个接口,是服务器端的程序(代码 或 功能实现)
    可交互式的处理客户端发送到服务端的请求,并完成操作响应

    生命周期:描述一个事件从开始到结束的整个过程
        servlet对象是由tomcat服务器创建
        由tomcat服务器关闭而销毁
        执行顺序:
            init:初始化,只执行一次
            service:实际功能,每次客户端访问都会执行
            destroy:销毁,只执行一次
*/

/*
    http协议:
        建立连接(三次握手)
          客户端向服务器请求连接
          服务器向客户端返回连接信息
          客户端向服务器确认连接
*/
public class TestServlet01 implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("服务器初始化 -- init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("获取配置 -- getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("启动服务 -- service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("获取信息 -- getServletInfo");
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("销毁 -- destroy");
    }
}
