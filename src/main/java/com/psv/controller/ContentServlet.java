package com.psv.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContentServlet", value = "/ContentServlet")
public class ContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addVehicle".equals(action)) {
            // Forward to the add_vehicle.jsp page
            request.getRequestDispatcher("add_vehicle.jsp").forward(request, response);
        } else if ("viewBookings".equals(action)) {
            // Forward to the view_bookings.jsp page
            request.getRequestDispatcher("view_bookings.jsp").forward(request, response);
        }
        else if ("scheduleTrip".equals(action)) {
            // Forward to the view_bookings.jsp page
            request.getRequestDispatcher("schedule_trip.jsp").forward(request, response);
        }
        else if ("bookTrip".equals(action)) {
            // Forward to the view_bookings.jsp page
            request.getRequestDispatcher("book_trip.jsp").forward(request, response);
        }
        else {
            // Handle any other cases or show an error message
            response.getWriter().write("Invalid action!");
        }
    }
}