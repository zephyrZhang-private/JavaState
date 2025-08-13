<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/7/17
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn" value="异步加载服务器" onclick="f1()">发送格式为key:value的原生ajax请求</button>
<span id="s1"></span>
<script>

    //同步请求,会导致整个网页都刷新
/*    function f1(){
        location.href="${pageContext.request.contextPath}/demo1";
    }*/

    //异步请求方式
    function f1() {
        //创建一个ajax对象
        var x = new XMLHttpRequest();
        //客户端监听到服务器响应数据,需要执行的回调函数
        x.onreadystatechange = function () {
            /*
            * readyState : 描述服务器向浏览器响应数据的结果和状态
            * 0 请求没有初始化
            * 1 浏览器和服务器刚刚建立联系
            * 2 ajax请求成功被服务器接受
            * 3 服务器正在处理用户发送的ajax请求
            * 4 服务器成功处理用户发送的ajax请求,并做好响应准备
            * */
            if (x.readyState == 4 && x.status == 200) {
                //正常的响应状态码
                    //获取后台向前台响应的文本形式数据
                    data = x.responseText;
                    document.getElementById("s1").innerHTML = data;
                    console.log(data);
            }
        }

        //发送ajax请求 参数1 请求方式 参数2 后台url 参数3 是否是ajax请求
        x.open("get","${pageContext.request.contextPath}/demo1?username=zhang&password=1231","true")
        //发送ajax请求
        x.send(null);
    }


</script>

</body>
</html>
