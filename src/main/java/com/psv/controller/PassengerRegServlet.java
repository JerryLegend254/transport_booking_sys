package com.psv.controller;

import com.psv.dao.PassengerDao;
import com.psv.model.Passenger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PassengerRegServlet", value = "/passengerReg")
public class PassengerRegServlet extends HttpServlet {

    private PassengerDao passengerDao = new PassengerDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

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
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else if(!pass.equals("") && confPass.equals(pass)){
            Passenger passenger = new Passenger();
            passenger.setName(fullName);
            passenger.setEmail(email);
            passenger.setPassword(pass);

            try{
                passengerDao.registerPassenger(passenger);
            }catch (Exception e){
                e.printStackTrace();
            }

            response.sendRedirect("/signIn.jsp");
        }else {
            errors.append("Password did not much");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }


    }
}