package com.faris.servlet;

import com.faris.entity.User;
import com.faris.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();

        if(request.getParameter("id_user") != null){
            user.setId_user(Integer.parseInt(request.getParameter("id_user")));
        }

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        userService.Save(user);
        response.sendRedirect("dashboard.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
