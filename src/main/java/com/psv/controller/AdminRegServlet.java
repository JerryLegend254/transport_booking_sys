package com.psv.controller;

import com.psv.dao.AdminDao;
import com.psv.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminRegServlet", value = "/adminReg")
public class AdminRegServlet extends HttpServlet {
    AdminDao adminDao = new AdminDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AdminRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder errors = new StringBuilder();

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String confPass = request.getParameter("confPass");
        String fullName = fName + " " + lName;
        if(fName == null || lName == null || email == null || pass == null || confPass == null){
            errors.append("One or more important data was not added. Please add the information");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/AdminRegister.jsp").forward(request, response);
        }
        else if(!pass.equals("") && confPass.equals(pass)){
            Admin admin = new Admin();
            admin.setName(fullName);
            admin.setEmail(email);
            admin.setPassword(pass);

            try{
                adminDao.registerAdmin(admin);
            }catch (Exception e){
                e.printStackTrace();
            }

            getServletContext().getRequestDispatcher("/AdminSignIn.jsp").forward(request, response);
        }else {
            errors.append("Password did not much");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/AdminRegister.jsp").forward(request, response);
        }
    }
}