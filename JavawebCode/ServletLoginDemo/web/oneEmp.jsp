<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/7
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>oneEmp</title>
</head>
<body>

<%--enctype="multipart/form-data":表单中使用这个属性,servlet请求req.getParamter获取不到结果--%>
    <form action="/empUpdate.do" method="post" >
        员工编号 : <input type="text" name="empNo" value="${oneEmp.empNo}" readonly><br>
        员工姓名 : <input type="text" name="empName" value="${oneEmp.empName}"><br>
        员工职级 : <input type="text" name="empJob" value="${oneEmp.empJob}"><br>
        员工经理 : <input type="text" name="empManger" value="${oneEmp.empManger}"><br>
        入职日期 : <input type="text" name="empDate" value="${oneEmp.empDate}"><br>
        员工绩效 : <input type="text" name="salary" value="${oneEmp.salary}"><br>
        部门编号 :
        <select name="deptno">
            <c:forEach items="${deptList}" var="dept">
                <option value="${dept.deptno}" ${dept.deptno == oneEmp.deptNo?'selectd':''}>${dept.dname}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="提交修改">

    </form>

</body>
</html>
