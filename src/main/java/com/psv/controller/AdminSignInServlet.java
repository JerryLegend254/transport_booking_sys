package com.psv.controller;

import com.psv.dao.AdminDao;
import com.psv.model.Admin;
import com.psv.model.Passenger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminSignInServlet", value = "/adminSignIn")
public class AdminSignInServlet extends HttpServlet {
    AdminDao adminDao = new AdminDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AdminSignIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        Admin admin = adminDao.getAdmin(email, pass);
        if(admin != null){
            HttpSession session = request.getSession(true);

            // Store user information in session attributes
            session.setAttribute("currUser", admin.getName());


            // Set session timeout (optional, but recommended)
            int sessionTimeoutInSeconds = 1800; // 30 minutes (adjust as needed)
            session.setMaxInactiveInterval(sessionTimeoutInSeconds);

            // Redirect the user to the dashboard or another secure page
            response.sendRedirect("adminDashboard.jsp");
        }else {
            response.sendRedirect("/adminSignIn");
        }
    }
}