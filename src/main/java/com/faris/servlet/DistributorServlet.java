package com.faris.servlet;

import com.faris.entity.Distributor;
import com.faris.service.DistributorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/distributor")
public class DistributorServlet extends HttpServlet {

    private DistributorService service = new DistributorService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Distributor distributor = new Distributor();

        if(request.getParameter("id_distributor") != null){
            distributor.setId_distributor(Integer.parseInt(request.getParameter("id_distributor")));
        }

        distributor.setNama_distributor(request.getParameter("nama_distributor"));
        distributor.setAlamat_distributor(request.getParameter("alamat_distributor"));
        distributor.setEmail(request.getParameter("email"));
        distributor.setTelepon(request.getParameter("telepon"));

        service.Save(distributor);
        response.sendRedirect("/distributor");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id_distributor = request.getParameter("id_distributor");
        if(id_distributor != null) {

            service.delete(Integer.parseInt(id_distributor));
            response.sendRedirect("/distributor");
        }

        List<Distributor> distributors = service.find();
        request.setAttribute("distributors", distributors);
        request.getRequestDispatcher("/distributor.jsp").forward(request,response);
    }
}
