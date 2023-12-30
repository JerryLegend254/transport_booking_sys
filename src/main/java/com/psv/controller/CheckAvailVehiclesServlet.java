package com.psv.controller;

import com.psv.dao.Bus_StopDao;
import com.psv.dao.TripDao;
import com.psv.model.BusStop;
import com.psv.model.Vehicle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckAvailVehiclesServlet", value = "/checkAvailVehicles")
public class CheckAvailVehiclesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reg_no = request.getParameter("bus_stops");

        Bus_StopDao busStopDao = new Bus_StopDao();
        List<Vehicle> vehicles = busStopDao.getVehicles(reg_no);
        if(!vehicles.isEmpty()){
            TripDao tripDao = new TripDao();
            List<Vehicle> availVehicles = tripDao.getAvailableTripVehicles(vehicles);
            if(!availVehicles.isEmpty()){
                request.setAttribute("availableVehicles", availVehicles);
                getServletContext().getRequestDispatcher("/book_trip.jsp").forward(request, response);

            }else {
                System.out.println("No corresponding trip");
                getServletContext().getRequestDispatcher("/passengerDashboard.jsp").forward(request, response);
            }


        }else {
            System.out.println("No vehicles for this stop currently");
            getServletContext().getRequestDispatcher("/passengerDashboard.jsp").forward(request, response);
        }
    }
}