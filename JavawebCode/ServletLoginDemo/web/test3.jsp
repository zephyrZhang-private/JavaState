<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>三大指令---include</title>
</head>
<body>
    Baby
    <%-- 静态包含,翻译时进行jsp合并，最后生成一个.java文件--%>
    <%@include file="test2.jsp"%>

    <%-- 动态包含,文件不合并,用到就被执行,性能上考虑静态包含--%>
    <jsp:include page="test2.jsp" ></jsp:include>
</body>
</html>
