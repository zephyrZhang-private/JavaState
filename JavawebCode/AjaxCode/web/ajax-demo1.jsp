<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/8/13
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button id="btn" value="异步请求服务器" onclick="fun2()">发送数据格式为json的原生ajax请求</button>
    <span id="s2"></span>

<script>
    function fun2(){
        //准备Ajax数据 js对象
        var user = {
            username:"zhang",
            password:"123456"
        }
        //获取Ajax对象
        var x = new XMLHttpRequest();
        x.onreadystatechange = function () {
            if (x.readyState == 4 && x.status == 200) {
                //将后台响应的数据转换成json格式的数据
                var data = JSON.parse(x.responseText);
                console.log(data);
                document.getElementById("s2").innerHTML = "姓名" + user.username + "密码" + user.password;
            }
        }
        //发送ajax请求
        x.open('POST',"${pageContext.request.contextPath}/demo2",true);
        //设置请求头
        x.setRequestHeader('Content-Type', 'application/x-www-form-data');
        //将js对象转换成json格式的字符串
        x.send(JSON.stringify(user));
    }
</script>
</body>
</html>
