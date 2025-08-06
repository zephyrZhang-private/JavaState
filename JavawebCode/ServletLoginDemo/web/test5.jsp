<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求转发01</title>
</head>
<body>
<jsp:forward page="test6.jsp">
    <jsp:param name="name" value="zhangsan"/>
</jsp:forward>
</body>
</html>
