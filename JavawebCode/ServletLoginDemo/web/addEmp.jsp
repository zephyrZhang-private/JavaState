<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/7
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增表单</title>
</head>
<form action="/empAdd.do" method="post">
    员工编号 : <input type="text" name="empNo"><br>
    员工姓名 : <input type="text" name="empName"><br>
    员工职级 : <input type="text" name="empJob"><br>
    员工经理 : <input type="text" name="empManger"><br>
    入职日期 : <input type="text" name="empDate"><br>
    员工绩效 : <input type="text" name="salary"><br>
    部门编号 :
    <select name="deptno">
        <c:forEach items="${deptList}" var="dept">
            <option value="${dept.deptno}">${dept.dname}</option>
        </c:forEach>
    </select>
    <input type="submit" value="添加">
</form>
</body>
</html>
