<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div class="container">
    <h1>教室管理系统</h1>
    <div class="signIn">
        <form action="login" method="post">
            <input type="text" class="userName" name="userName" placeholder="账号"  />
            <input type="password" class="userPwd pass" name="userPwd"  placeholder="密码"  /><br>
            <input type="submit" name="login" value="登录" />
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/register">没有账号,点击注册</a>
</div>
</body>
</html>
