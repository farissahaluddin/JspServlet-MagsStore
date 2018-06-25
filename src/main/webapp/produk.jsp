<%--
  Created by IntelliJ IDEA.
  User: Faris
  Date: 6/22/2018
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/produk" method="post" enctype="multipart/form-data" align="center">

    <input type="text" name="namaProduk" placeholder="Nama Produk" style="margin-bottom: 10px"><br>

    <input type="file" name="file"><br>

    <button type="submit">Simpan</button><br>
</form>

</body>
</html>
