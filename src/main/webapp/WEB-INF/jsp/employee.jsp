
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>员工crud操作</title>
</head>
<body>
<shiro:principal property="username"></shiro:principal>
<shiro:principal property="password"></shiro:principal>
<form method="post" action="/employee/login1">
    <p><input type="text" name="username" value="" placeholder="账号"></p>
    <p><input type="text" name="password" value="" placeholder="密码"></p>
    <input type="submit" value="登录">
</form>
<a href="/employee/save">员工添加</a><br>
<a href="/employee/edit">员工编辑</a><br>
<a href="/employee/delete">员工删除</a><br>
</html>
