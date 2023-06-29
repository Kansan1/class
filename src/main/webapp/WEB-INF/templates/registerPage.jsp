<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <meta charset="UTF-8">
</head>
<body>
<div class="container">
    <h1>账户注册</h1>
    <div class="signIn">
        <form  action="register" method="post">
            <input type="text" name="userName" class="userName" placeholder="账号" />
            <input type="password" name="userPwd" required class="pass" placeholder="密码" /><br>
            <input type="password" name="userPwd1" required class="pass" placeholder="确认密码" /><br>
            <input type="submit" value="注册" />
        </form><br>
        <c:if test="${not empty errorMsg4}">
            <p style="color: red">${errorMsg4}</p>
        </c:if>
    </div>
</div>
</body>
</html>
