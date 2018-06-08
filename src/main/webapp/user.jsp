<%--
  Created by IntelliJ IDEA.
  User: Faris
  Date: 6/7/2018
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>

    <h2 style="text-align: center">User MGS-Store</h2>

    <form action="/userservlet" method="post" align="center">

        <input type="text" name="username" placeholder="Username" style="margin-bottom: 10px"><br>
        <input type="password" name="password" placeholder="Password" style="margin-bottom: 10px"><br>
        <input type="submit" value="Tambah">
    </form>

</body>
</html>
