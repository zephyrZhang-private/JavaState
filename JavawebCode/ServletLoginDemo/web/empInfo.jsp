<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<a href="/selectAllDept.do">新员工</a>
<table width=\"60%\" border=\"1px\" align=\"center\" cellspacing=\"0px\" cellpadding=\"10px\"
       bgcolor=\"blanchedalmond\">
    <tr>
        <th>员工编号</th>
        <th>员工头像</th>
        <th>员工姓名</th>
        <th>员工职级</th>
        <th>员工经理</th>
        <th>入职日期</th>
        <th>部门编号</th>
        <th>工资</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${empInfoList}" var="emp" begin="0" end="${empInfoList.size()}" step="1">
        <tr>
            <td>${emp.empNo}</td>
            <td><img src="/img/${emp.image == null ? '8.jpg' : emp.image}" width="100px" height="100px"></td>
            <td>${emp.empName}</td>
            <td>${emp.empJob}</td>
            <td>${emp.empManger}</td>
            <td>${emp.empDate}</td>
            <td>${emp.deptNo}</td>
            <td>${emp.salary}</td>
            <td>
                <button onclick="empDelete(${emp.empNo})">删除</button>
                <br>
                <button onclick="empUpdate(${emp.empNo})">修改</button>
            </td>
        </tr>
    </c:forEach>
</table>

<script>

    function empDelete(empNo) {
        if (confirm("确认删除？")) {
            //访问deleteServlet
            location.href = "/empDel.do?empNo=" + empNo;
        }
    }

    function empUpdate(empNo) {
        if (confirm("确认修改？")) {
            //访问deleteServlet
            location.href = "/empOne.do?empNo=" + empNo;
        }
    }
</script>
</body>
</html>
