package servletTest;

import javax.servlet.*;
import java.io.IOException;
/*

第一种创建servlet类的方法:直接实现servlet接口

    servlet生命周期四个阶段
      实例化:由tomcat创建servlet对象
          1. 当用户访问对应路径创建对应servlet对象
          2. tomcat启动时创建servlet对象
          3. <load-on-startup>1</load-on-startup>
             - 参数为0或正数,tomcat启动时创建
             - 参数为负数,访问时创建
             - 数值越小,优先级越高
      初始化:init方法实现
      工作:service服务
      销毁:destroy负责销毁
          tomcat服务器停止服务
*/
public class Servlet01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
