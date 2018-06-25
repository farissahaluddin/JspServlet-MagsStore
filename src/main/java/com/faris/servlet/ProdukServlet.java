package com.faris.servlet;

import com.faris.entity.Distributor;
import com.faris.entity.Produk;
import com.faris.service.ProdukService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/produk")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 *2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)

public class ProdukServlet extends HttpServlet {

    private ProdukService service = new ProdukService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Produk produk = new Produk();

        PrintWriter out = response.getWriter();

        Part part = request.getPart("file");
        String fileName = extractFileName(part);
        String savePath = "D:\\KERJA\\MGS\\SOAL-JAVAWEB\\MgsStore\\src\\main\\webapp\\images"+File.separator+fileName;
        File fileSaveDir = new File(savePath);

        part.write(savePath+File.separator);


        if (request.getParameter("id_produk") != null) {
            produk.setId_produk(Integer.parseInt(request.getParameter("id_produk")));
        }

        produk.setNama_produk(request.getParameter("namaProduk"));
        System.out.println(savePath);
        produk.setPath_produk(request.getParameter("savePath"));

        service.Save(produk);
        response.sendRedirect("display.jsp");

    }

    private String extractFileName(Part part) {
        String contentDisplay = part.getHeader("content-disposition");
        String[] items = contentDisplay.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
