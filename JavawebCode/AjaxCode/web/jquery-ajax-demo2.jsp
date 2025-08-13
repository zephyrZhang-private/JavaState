<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/8/13
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名:<input type="text" id="username"><span id="s1"></span>
<br>

<script src="jquery-3.6.0.js"></script>
<script>
    $(function () {
        $("input#username").blur(function () {
            var username = $("#username").val();
            if (username == "") {
                $("span#s1").html("用户名不能为空")
                return;
            } else {
                $.get("${pageContext.request.contextPath}/checkUsername",
                    {"username": username},
                    function (data) {
                        $("span#s1").html(data);
                        console.log(data);
                    }, "text")
            }
        })
    })
</script>
</body>
</html>
