<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.EmpInfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>

<%--<%--%>
<%--  List<EmpInfo> list = (List<EmpInfo>) request.getAttribute("empInfoList");--%>
<%--  request.setAttribute("list",list);--%>
<%--%>--%>

<table  width=\"60%\" border=\"1px\" align=\"center\" cellspacing=\"0px\" cellpadding=\"10px\" bgcolor=\"blanchedalmond\">
<tr>
      <th>员工编号</th>
      <th>员工姓名</th>
      <th>部门编号</th>
      <th>部门名称</th>
      <th>工资</th>
      <th>操作</th>
</tr>
  <jsp:useBean id="empInfoList" scope="request" type="java.util.List"/>
  <c:forEach items="${empInfoList}" var="emp" begin="0" end="${empInfoList.size()}" step="1">
    <tr>
    <td>${emp.empNo}</td>
    <td>${emp.empName}</td>
    <td>${emp.deptNo}</td>
    <td>${emp.deptName}</td>
    <td>${emp.salary}</td>
    <td><a href='#'>删除</a><a  href='#'>修改</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
