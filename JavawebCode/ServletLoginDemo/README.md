# 项目说明
ServletDemo02案例,完善功能如下:
* 完善登录功能
  * 使用session保存登录状态
  * 使用其他功能前先验证登录状态
  * 注销后删除登录状态
* 添加验证码功能
* 添加记住密码功能 
 
> 最后使用过滤器继续完善上述功能

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


# Filter过滤器
## Filter配置
````
<filter>
  <filter-name>myFilter</filter-name>
  <filter-class>src.filter.MyFilter</filter-class>
</filter>
<filter-mapping>
  <filter-name>myFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>
````
> 在web应用中,可以开发多个Filter,组合起来称为一个Filter链
* 注解,按照类全名称字符串顺序决定作用顺序
* web.xml,按照filter-mapping注册顺序,自上而下
* web.xml配置高于注解
* 注解和web.xml同时配置,会创建多个Filter对象,过滤多次

## 登录状态、自动登录过滤器
* 保持登录状态,验证session在服务器中是否存在,使用的页面*.do命名
* 自动登录,过滤login.html页面,获取cookie中的用户信息,校验数据库获取所有信息,写入session后跳转

# JSP原理
* 在如今前后端分离的推进下被剔除的技术
* 本质为了减少servlet前端开发的工作量
* 实际还是一个servlet,jsp文件被编译为*_jsp.java -> *_jsp.class
* jsp中可以写Java代码,还可以写标签
* 理解为主,能看懂代码
* <%= %> : 局部变量,out.write
* <%! %> : 成员变量,全局变量,定义在jsp对应servlet类中
* <% %>  : 局部变量,定义在jsp对应servlet类中service方法

## jsp注释方法
* <%----%> : jsp注释,注释内容不会被编译不会发送到客户端
* <!---->  : HTML注释,通过客户端可查看注释内容

## el表达式
* 对jsp代码的简化