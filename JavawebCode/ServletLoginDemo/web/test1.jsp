<%@ page import="entity.EmpInfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
</head>
<body>

<%
    //定义在public void _jspService 方法中
    int a = 3;
    //可以直接写Java代码
    //打印到控制台
    System.out.println("hello jsp");
    //打印到浏览器
    out.println("hello jsp");

    EmpInfo empInfo = new EmpInfo();
%>

<%!
    //成员变量,public final class test1_jsp 类中定义
    int b = 6;
    public class DogKing{

    }
    public void loud(){
        System.out.println("DogQueen");
    }
%>

<%--定义局部变量,同等out.write方法--%>
<%=b %>

</body>
</html>
