package com.faris.servlet;


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
import java.util.List;


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
        String savePath ="D:\\KERJA\\MGS\\SOAL-JAVAWEB\\MgsStore\\src\\main\\webapp\\images";
//        File fileSaveDir = new File(savePath);
        part.write(savePath+File.separator+fileName);
        String filePath = savePath+File.separator+fileName;

        if (request.getParameter("id_produk") != null) {
            produk.setId_produk(Integer.parseInt(request.getParameter("id_produk")));
        }
        produk.setNama_produk(request.getParameter("namaProduk"));
        System.out.println(filePath);
        produk.setPath_produk(filePath);

        service.Save(produk);
        response.sendRedirect("produk");
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id_produk = request.getParameter("id_produk");
        if(id_produk != null){
            service.delete(Integer.parseInt(id_produk));
            response.sendRedirect("/produk");
        }

        List<Produk> produks = service.find();
        request.setAttribute("produks", produks);
        request.getRequestDispatcher("/produk.jsp").forward(request, response);

    }
}
