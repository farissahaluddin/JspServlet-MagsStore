<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<table border="1">
    <tr>
        <th>No </th>
        <th>nama_produk </th>
        <th>gambar </th>
        <th>aksi</th>
    </tr>
    <tbody>
    <c:forEach items="${produks}" var="produk" varStatus="loop">
    <tr>
        <td>${loop.index+1}</td>
        <td>${produk.nama_produk}</td>

        <td> <img src="<c:out value="${produk.path_produk}"/>" width="100"/></td>

        <td>
            <a href=" ${loop.index+1} ">Edit</a>
            <a href="/produk?id_produk=${produk.id_produk}" >Hapus</a>
        </td>
    </tr>
    </c:forEach>


</table>

</body>
</html>
