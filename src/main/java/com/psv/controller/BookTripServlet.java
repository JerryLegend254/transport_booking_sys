package com.psv.controller;

import com.psv.dao.BookingDao;
import com.psv.dao.TripDao;
import com.psv.model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookTripServlet", value = "/bookTrip")
public class BookTripServlet extends HttpServlet {
    BookingDao bookingDao = new BookingDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trip_id = request.getParameter("vehicles");
        int dbValTripId = Integer.parseInt(trip_id);

        TripDao tripDao = new TripDao();
        tripDao.updateAvailableSeats(dbValTripId);
        String regNo = tripDao.getVehiclReg(dbValTripId);
        HttpSession session = request.getSession();

        // Retrieve the session variable (username) set in the first servlet
        String username = (String) session.getAttribute("currUser");

        // Use the session variable in your processing
        if (username != null) {
            // The session variable (username) is available, do something with it
            Booking booking = new Booking();
            booking.setVeh_regno(regNo);
            booking.setPassenger_name(username);

            bookingDao.bookTrip(booking);
        } else {
            // The session variable is not available, handle it accordingly
            System.out.println("No username in session.");
            return;
        }

        getServletContext().getRequestDispatcher("/passengerDashboard.jsp").forward(request, response);
    }
}