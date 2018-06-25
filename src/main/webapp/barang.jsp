<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faris
  Date: 6/7/2018
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Barang</title>
</head>
<body>

<h2 style="text-align: center">Produk</h2>

<form action="/barang" method="post" enctype="multipart/form-data" align="center">
    <input type="text" name="nama_barang" placeholder="Nama Barang" style="margin-bottom: 10px"><br>

    <input type="text" name="harga_barang" placeholder="Harga Barang" style="margin-bottom: 10px"><br>

    <input type="file" name="foto_barang"><br>

    <button type="submit" >Simpan</button><br>
</form>

<%--<table border="1" align="center">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th>No</th>--%>
        <%--<th>Nama Barang</th>--%>
        <%--<th>Harga Barang</th>--%>
        <%--<th>Foto Barang</th>--%>
        <%--<th>Aksi</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<c:forEach items="${barangs}" var="barang" varStatus="loop">--%>
        <%--<tr>--%>
            <%--<td>${loop.index+1}</td>--%>
            <%--<td>${barang.nama_barang}</td>--%>
            <%--<td>${barang.harga_barang}</td>--%>
            <%--<td>${barang.foto_barang}</td>--%>
            <%--<td>--%>
                <%--<a href=" ${loop.index+1} ">Edit</a>--%>
                <%--<a href="/barang?id_barang=${barang.id_barang}" >Hapus</a>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>

</body>
</html>
