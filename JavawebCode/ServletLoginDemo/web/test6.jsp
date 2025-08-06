<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求转发02</title>
</head>
<body>
<h1>请求转发成功</h1>
<%
    String name = request.getParameter("name");
    System.out.println(name);
%>
</body>
</html>
