<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/8/13
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名:<input type="text" id="username"><span id="s1"></span>
<br>


<script src="jquery-3.6.0.js"></script>

<script>
    $(function() {
        $("input#username").blur(function() {
            var  username = $("#username").val();
            if(username == ""){
                $("span#s1").html("用户名不能为空")
                return ;
            }else {
                //如果用户名不为空,向后台发送异步请求
                $.ajax({
                    //发送的请求方式
                    type: "GET",
                    //请求后台资源
                    url: "${pageContext.request.contextPath}/checkUsername?username=" + username,
                    //后台响应前台数据后需要执行的回调函数
                    success: function(data){
                        $("span#s1").html(data);
                    }
                })
            }
        })
    })
</script>
</body>
</html>
