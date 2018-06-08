<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faris
  Date: 6/7/2018
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<>html
<head>
    <title>Penjualan</title>
</head>
<body>

<h2 style="text-align: center">Penjualan</h2>
<form action="/penjualan" method="post" align="center">

    <input type="text" name="id_barang" placeholder="Id Barang" style="margin-bottom: 10px"><br>

    <input type="text" name="tgl_penjualan" placeholder="Tanggal Penjualan" style="margin-bottom: 10px"><br>

    <input type="text" name="bayar" placeholder="Bayar" style="margin-bottom: 10px"><br>

    <button type="submit" >Simpan</button><br>
</form>

<table border="1" align="center">
    <thead>
    <tr>
        <th>No</th>
        <th>Id Barang</th>
        <th>Tanggal Penjualan</th>
        <th>Bayar</th>
        <th>Sisa</th>
        <th>Total</th>
        <th>Aksi</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${penjualans}" var="penjualan" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${penjualan.id_barang}</td>
            <td>${penjualan.tgl_penjualan}</td>
            <td>${penjualan.bayar}</td>
            <td>${penjualan.sisa}</td>
            <td>${penjualan.total}</td>
            <td>
                <a href=" ${loop.index+1} ">Edit</a>
                <a href="/penjualan?id_penjualan=${penjualan.id_penjualan}" >Hapus</a>
            </td>
        </tr>
    </c:forEach>


    </tbody>
</table>

</body>
</html>
