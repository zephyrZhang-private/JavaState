<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九大内置对象</title>
</head>
<body>

<%--在请求转发下,pageContext获取不到值,其他可以--%>
<%--在重定向下,pageContext,request获取不到值,其他可以--%>
<%= pageContext.getAttribute("like") %>
<%= request.getAttribute("like") %>
<%= session.getAttribute("like") %>
<%= application.getAttribute("like") %>

<%-- 1.作用范围最大的是四大域对象
     2. 会从pageContext开始查找,找到即显示,找不到依次request - session - application--%>
<%= pageContext.findAttribute("like1") %>

</body>
</html>
