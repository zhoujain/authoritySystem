<%--
  Created by IntelliJ IDEA.
  User: zhoujian
  Date: 2019/8/19
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登陆成功</h1>
    <a href="${pageContext.request.contextPath}/admin11">检测ROLE_ADMIN角色</a>
    <a href="${pageContext.request.contextPath}/user11">检测ROLE _USER角色</a>
    <button onclick="window.location.href='/logout'">退出登陆</button>
</body>
</html>
