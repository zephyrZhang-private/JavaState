# 项目说明
ServletDemo02案例,完善功能如下:
* 完善登录功能
  * 使用session保存登录状态
  * 使用其他功能前先验证登录状态
  * 注销后删除登录状态
* 添加验证码功能
* 添加记住密码功能

# ServletContext对象
## ServletContext概述
* 全局对象,拥有作用域,作用范围是整个工程
* 服务器启动时,会创建一块共享的存储区域(ServletContext)
* 服务器关闭时销毁

## 获取ServletContext对象
* GenericServlet提供getServletContext方法,推荐this.getServletContext();
* HttpServletRequest提供getServletContext方法
* HttpServlet提供getServletContext方法

## ServletContext作用
### 获取项目真实路径
> 获取当前项目在服务器发布的真实路径
````
String realPath = servletContext.getRealPath("/");
````
### 获取项目上下文路径
> 获取当前项目上下文路径(应用程序名称)
````
System.out.println(servletContext.getContextPath());
System.out.println(req.getContextPath());
````

### 全局容器
> ServletContext拥有作用域,可以存储数据到全局容器中
* 存储数据:servletContext.setAttribute("name",value);
* 获取数据:servletContext.getAttribute("name");
* 删除数据:servletContext.removeAttribute("name");

## ServletContext特点
* 唯一性:一个应用对应一个ServletContext
* 生命周期:只要容器不关闭,ServletContext会一直存在


# Servlet中的作用域
* HttpServletRequest:一次请求
* Httpsession:一次会话
* ServletContext:服务器生命周期
