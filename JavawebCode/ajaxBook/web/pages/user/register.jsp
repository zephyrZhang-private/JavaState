<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正维书院注册页面</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp"%>

    <script>
        //页面加载完成之后
        $(function() {
            //给注册绑定单击事件
            $("#submit").click(function() {
                //验证用户名:必须由字母\数字\下划线组成,长度4-12位
                var usernameText = $("#username").val();
                //创建正则表达式对象
                var usernamePatt = /^\w{4,12}$/;
                //使用test方法验证
                if (!usernamePatt.test(usernameText).val()) {
                    //提示用户结果
                    $("span.errorMsg").html("用户名不合法!")
                    return false;
                }

                //验证密码 : 必须由字母\数字\下划线组成,长度4-12位
                //获取密码
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱里的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!emailPatt.test(emailText)) {
                    //4 提示用户
                    $("span.errorMsg").text("邮箱格式不合法！");

                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();

                //去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")

                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");
            });

            // 给验证码的图片，绑定单击事件
            $("#code_img").click(function () {
                // 在事件响应的 function 函数中有一个 this 对象。这个 this 对象，是当前正在响应事件的 dom 对象
                // src 属性表示验证码 img 标签的 图片路径。它可读，可写
                this.src = "http://localhost:8080/kaptcha.jpg?d=" + new Date();
            })

            //给登录绑定单击事件
            $("#login_btn").click(function(){
                location.href = "http://localhost:8080/pages/user/login.jsp";
            })
        })
    </script>

    <style>
        .login_form{
            height:420px;
            margin-top: 25px;
        }
    </style>

</head>
<body>
    <div id="login_header">
        <img src="/static/img/logo.gif">
    </div>

    <div class="login_banner">
        <div id="l_content">
            <span class="login_word">欢迎注册</span>
        </div>
        <div id="content">
            <div class="login_form">
                <div class="login_box">
                    <div class="tit">
                        <h1>注册正维书院</h1>
                        <span class="errorMsg">${msg}</span>
                    </div>
                    <div class="form">
                        <form method="POST" action="userServlet">
                            <input type="hidden" name="action" value="register">
                            <label>用户名称 : </label>
                            <input type="text" class="itxt" placeholder="请输入用户名"
                                value="${username}" autocomplete="off"
                                tabindex="1" name="username" id="username">
                            <br>
                            <br>
                            <label>用户密码 : </label>
                            <input class="itxt" type="password" placeholder="请输入密码"
                                   autocomplete="off" tabindex="1" name="password" id="password" />
                            <br>
                            <br>
                            <label>确认密码：</label>
                            <input class="itxt" type="password" placeholder="确认密码"
                                   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                            <br>
                            <br>
                            <label>电子邮件：</label>
                            <input class="itxt" type="text" placeholder="请输入邮箱地址"
                                   value="${email}"
                                   autocomplete="off" tabindex="1" name="email" id="email" />
                            <br>
                            <br>
                            <label>验证码：</label>
                            <input class="itxt" type="text" name="code" style="width: 150px;" id="code" />
                            <img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 80px;height: 40px;">
                            <br>
                            <br>
                            <input type="submit" value="注册" id="sub_btn" />
                            <input type="button" value="登录" id="login_btn"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--静态包含页脚内容--%>
    <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
