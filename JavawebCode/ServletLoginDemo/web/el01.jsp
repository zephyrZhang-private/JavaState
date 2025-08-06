<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/8/6
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式-01</title>
</head>
<body>

<%
    String name = (String) request.getAttribute("name");
    out.print(name);
%>
<br>
<!-- 简化获取 : $键 -->
name1:${name}<br>
name2:${requestScope.name}<br>

<!--四大对象设置同一属性不同值
pageContext 优先级最大 其次 request session application
-->
<%
    pageContext.setAttribute("age",1);
    request.setAttribute("age",10);
    session.setAttribute("age",20);
    application.setAttribute("age",50);

%>

age:${age}<br>
age1:${pageScope.age}<br>
age2:${requestScope.age}<br>
age3:${sessionScope.age}<br>
age4:${applicationScope.age}<br>


<%--模型存值取值--%>
<%
    User user = new User("zhaoSi","200021");
    pageContext.setAttribute("user",user);
%>

user:${user}
<br>

<%--集合存储 - list集合--%>

<%
    //存储list集合
    List<User> list = new ArrayList<>();
    list.add(new User("zhangsan","123456"));
    list.add(new User("zhaosi","123456"));

    //将list集合放入域对象
    pageContext.setAttribute("list",list);
%>

<%--这里对应的是setAttribute中的key,取出的是值--%>
list[0]:${list[0]}
<br>
list[1]:${list[1]}
<br>
list[0].username:${list[0].username}
list[0].password:${list[0].password}
<br>
list[1].username:${list[1].username}
list[1].password:${list[1].password}
<br>


<%
    //存入map集合
    Map<String,String> map = new HashMap<>();
    map.put("java","001");
    map.put("py","002");
    map.put("cpp","003");

    //存入域对象
    request.setAttribute("map",map);

    Map<String ,User> map1 = new HashMap<>();
    map1.put("u1",new User("zhangw","1601"));
    map1.put("u2",new User("zhangd","1501"));

    request.setAttribute("map1",map1);
%>

<%--通过el表达式取出map--%>
map:${map}
<br>
map.java:${map.java}
<br>
map1.u1.name:${map1.u1.username}

</body>
</html>
