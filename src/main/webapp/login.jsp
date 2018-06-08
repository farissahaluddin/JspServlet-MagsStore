<%--
  Created by IntelliJ IDEA.
  User: Faris
  Date: 6/6/2018
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h2 style="text-align: center">Login MGS-Store</h2>

    <form action="/login" method="post" align="center">

        <input type="text" name="username" placeholder="Username" style="margin-bottom: 10px"><br>
        <input type="password" name="password" placeholder="Password" style="margin-bottom: 10px"><br>
        <input type="submit" value="login">
    </form>

</body>
</html>