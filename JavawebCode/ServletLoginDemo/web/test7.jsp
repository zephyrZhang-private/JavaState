<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>四大内置对象</title>
</head>
<body>
<%--    pageContext : 对应当前JSP
        request : 对应servlet中HttpServletRequest
        session : 对应Httpsession
        application : 对应ServletContext
--%>
<%
    //通过pageContext可以获取其他八大内置对象
    pageContext.setAttribute("like","page");
    request.setAttribute("like","request");

    //通过pageContext给request赋值,与上行代码效果一致
    pageContext.setAttribute("like","request",PageContext.REQUEST_SCOPE);

    session.setAttribute("like","session");
    application.setAttribute("like","application");

    //请求转发
    request.getRequestDispatcher("/test8.jsp").forward(request,response);

    //重定向
    response.sendRedirect("/test8.jsp");

    //通过pageContext实现请求转发
    pageContext.forward("/test8.jsp");

%>
</body>
</html>
