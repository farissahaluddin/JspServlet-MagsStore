<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faris
  Date: 6/7/2018
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Distributor</title>
</head>
<body>

    <h2 style="text-align: center">Distributor</h2>

    <form action="/distributor" method="post" align="center">
        <input type="text" name="nama_distributor" placeholder="Nama Distributor" style="margin-bottom: 10px"><br>

        <input type="text" name="alamat_distributor" placeholder="Alamat Distributor" style="margin-bottom: 10px"><br>

        <input type="text" name="email" placeholder="Email" style="margin-bottom: 10px"><br>

        <input type="text" name="telepon" placeholder="No Telepon" style="margin-bottom: 10px"><br>

        <button type="submit" >Simpan</button><br>
    </form>

    <table border="1" align="center">
        <thead>
        <tr>
            <th>No</th>
            <th>Nama Distributor</th>
            <th>Alamat Distributor</th>
            <th>Email</th>
            <th>No Telepon</th>
            <th>Aksi</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${distributors}" var="distributor" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${distributor.nama_distributor}</td>
                <td>${distributor.alamat_distributor}</td>
                <td>${distributor.email}</td>
                <td>${distributor.telepon}</td>
                <td>
                    <a href=" ${loop.index+1} ">Edit</a>
                    <a href="/distributor?id_distributor=${distributor.id_distributor}" >Hapus</a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>


</body>
</html>
