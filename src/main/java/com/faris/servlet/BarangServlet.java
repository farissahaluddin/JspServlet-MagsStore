package com.faris.servlet;

import com.faris.entity.Barang;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/barang")
@MultipartConfig(fileSizeThreshold = 169999999)

public class BarangServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/mgs_store";
        String user = "root";
        String pass = "super";

        String sql = "INSERT INTO tbl_barang (nama_barang, harga_barang, foto_barang) VALUES (?,?,?)";

        try {

            String nama_barang = request.getParameter("nama_barang");

            String harga_barang = request.getParameter("harga_barang");

            Part filePart = request.getPart("foto_barang");

            System.out.println("hello" + " " + nama_barang + " " + filePart);

            InputStream inputStream = null;

            if (filePart != null) {
                long fileSize = filePart.getSize();
                String fileContent = filePart.getContentType();
                inputStream = filePart.getInputStream();
            }

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nama_barang);
            preparedStatement.setInt(2, Integer.parseInt(harga_barang));
            preparedStatement.setBlob(3, inputStream);

            int rc = preparedStatement.executeUpdate();

            if (rc == 0) {
                request.setAttribute("message", "error");
                getServletContext().getRequestDispatcher("/failure.jsp").forward(request, response);
            }
            else {
                request.setAttribute("message", "tersimpan");
                getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
