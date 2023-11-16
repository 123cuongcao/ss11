package com.example.demo10.controller;

import com.example.demo10.modal.Bike;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AuthController", value = "/AuthController")
public class AuthController extends HttpServlet {
    List<Bike> bikes = Arrays.asList(
            new Bike("https://www.royalenfield.com/content/dam/royal-enfield/vietnam/motorcycles/himalayan/colours/new-colors/studio-shots/rock-red/side-view.png", "xe rất dep", "xe moto", "cuong"),
            new Bike("https://www.royalenfield.com/content/dam/royal-enfield/vietnam/motorcycles/interceptor/colours/studio-shots/new/mark-2/side-view.png", "xe rất dep", "xe moto", "cuong"),
            new Bike("https://www.royalenfield.com/content/dam/royal-enfield/vietnam/motorcycles/continental-gt/colours/studio-shots/new/mr-clean/side-view.png", "xe rất dep", "xe moto", "cuong")
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "ABOUT":
                request.getRequestDispatcher("/WEB-INF/views/page/about.jsp").forward(request, response);
                break;
            case "PRODUCT":
                request.getRequestDispatcher("/WEB-INF/views/page/product.jsp").forward(request, response);
                break;
            case "INFORMATION":
                request.getRequestDispatcher("/WEB-INF/views/page/information.jsp").forward(request, response);
                break;
            case "CART":
                request.getRequestDispatcher("/WEB-INF/views/page/cart.jsp").forward(request, response);
                break;
            case "BAIVIET":
                request.setAttribute("bikes", bikes);
                request.getRequestDispatcher("/WEB-INF/views/page/baiviet.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}