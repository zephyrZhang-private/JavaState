<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>六大动作</title>
</head>
<body>
<%--useBean 操作模型对象--%>
<jsp:useBean id="empinfo" class="entity.EmpInfo">定位Java模型</jsp:useBean>
<jsp:setProperty name="empinfo" property="empNo" value="1601">给empNo赋值</jsp:setProperty>
<jsp:getProperty name="empinfo" property="empNo"/>取出empNo值
</body>
</html>
