<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/8/19
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名:<input type="text" name="username" id="username" /><span id="s1"></span>

<script src="jquery-3.6.0.js"></script>

<script type="text/javascript">
  $(function (){
    $("#username").blur(function(){
      var username = $("#username").val();
      //发送ajax请求到后段
      $.get("${pageContext.request.contextPath}/checkUser",{username:username},
          function(data){
            if (data.flag){
                $("#s1").html(data.msg).css("color", "red");
            }else {
                $("#s1").html(data.msg).css("color", "green");
            }
          },"json");

    })
  })
</script>
</body>
</html>
