package com.example.demo10.controller;

import com.example.demo10.modal.Word;
import com.example.demo10.service.IWordService;
import com.example.demo10.serviceimpl.WordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold =  1024 * 1024,
        maxFileSize = 10 * 1024 * 1024,
        maxRequestSize = 100 * 1024 * 1024
)
@WebServlet(name = "WordServlet", value = "/WordServlet")
public class WordServlet extends HttpServlet {
    IWordService wordService = new WordService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       switch (action){
           case "FIND":
                request.setAttribute("list", wordService.findWord(request.getParameter("find")));
                request.getRequestDispatcher("/WEB-INF/views/page/dictionary.jsp").forward(request,response);
               return;
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
        switch(action){
            case "UPLOAD":
                request.getParameter("text");
                String uploadPath = getServletContext().getRealPath("/uploads");
                File file = new File(uploadPath);
                if(!file.exists()){
                    file.mkdirs();
                }
                Iterable<Part> listFile = request.getParts();
                listFile.forEach(a->{
                    if(a.getName().equals("image")){
                        String nameFile = a.getSubmittedFileName();
                        try {
                            a.write(uploadPath + File.separator+ nameFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        wordService.add(new Word(request.getParameter("text"),nameFile));
                    }
                });
                request.setAttribute("list",wordService.findAll());
                request.getRequestDispatcher("/WEB-INF/views/page/dictionary.jsp").forward(request,response);
                break;
        }
    }
}