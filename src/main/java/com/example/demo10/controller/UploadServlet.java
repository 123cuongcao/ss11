package com.example.demo10.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1 * 1024 * 1024,
        maxFileSize = 10 * 1024 * 1024,
        maxRequestSize = 100 * 1024 * 1024
)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("UPLOAD")) {
            String uploadPath = getServletContext().getRealPath("/uploads");
            File file = new File(uploadPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            List<String> filenames = new ArrayList<>();
            Collection<Part> listFile = request.getParts();
            for (Part p : listFile) {
                if (p.getName().equals("image")) {
                    String nameFile = p.getSubmittedFileName();
                    p.write(uploadPath + File.separator+ nameFile);
                    filenames.add(nameFile);
                } else if (p.getName().equals("avatar")) {
                   String nameFile = p.getSubmittedFileName();
                   p.write(uploadPath + File.separator+nameFile);
                    filenames.add(nameFile);
                }
            }
            request.setAttribute("image",filenames);
            request.getRequestDispatcher("/WEB-INF/views/page/about.jsp").forward(request,response);
        }


    }
}