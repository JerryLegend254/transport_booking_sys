package com.psv.controller;

import com.psv.dao.PassengerDao;
import com.psv.model.Admin;
import com.psv.model.Passenger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PassengerSignIn", value = "/passengerSignIn")
public class PassengerSignIn extends HttpServlet {
    StringBuilder messages = new StringBuilder();
    PassengerDao passengerDao = new PassengerDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signIn.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        Passenger passenger = passengerDao.getPassenger(email, pass);
        if(passenger != null){
                HttpSession session = request.getSession(true);

                // Store user information in session attributes
                session.setAttribute("currUser", passenger.getName());


                // Set session timeout (optional, but recommended)
                int sessionTimeoutInSeconds = 1800; // 30 minutes (adjust as needed)
                session.setMaxInactiveInterval(sessionTimeoutInSeconds);

                // Redirect the user to the dashboard or another secure page
            response.sendRedirect("passengerDashboard.jsp");
            }else {
            response.sendRedirect("/passengerSignIn");
            }
        }

}