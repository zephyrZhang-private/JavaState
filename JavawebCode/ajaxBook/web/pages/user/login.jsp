<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/8/19
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>正维书院登录页面</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>

    <script>
      $(function() {
        $("#register_btn").click(function() {
          location.href = "http://localhost:8080/pages/user/register.jsp";
        })
      })
    </script>


</head>
<body>

<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>正维书院</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        ${(empty msg) ? "请输入用户名和密码" : msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <%--注意：这个value保持跟servlet里面对应处理的方法要一致--%>
                        <input type="hidden" name="action" value="login"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${username}"/>
                        <br>
                        <br>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br>
                        <br>
                        <input type="submit" value="登录" id="sub_btn"/>
                        <input type="button" value="注册" id="register_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>
