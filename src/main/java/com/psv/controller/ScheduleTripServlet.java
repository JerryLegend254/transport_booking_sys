package com.psv.controller;

import com.psv.dao.TripDao;
import com.psv.dao.VehicleDao;
import com.psv.model.Trip;
import com.psv.model.Vehicle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ScheduleTripServlet", value = "/scheduleTrip")
public class ScheduleTripServlet extends HttpServlet {
    TripDao tripDao = new TripDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder errors = new StringBuilder();
        String checkBoxValue = request.getParameter("isComplete");
        boolean dbCompleteValue;

        if (checkBoxValue != null && checkBoxValue.equals("complete")) {
            dbCompleteValue = true;
        } else {
            dbCompleteValue = false;
        }

        String reg_no = request.getParameter("vehicle");
        if(!reg_no.equals("")){
            VehicleDao vehicleDao = new VehicleDao();
            Vehicle vehicle = vehicleDao.getVehicle(reg_no);

            Trip trip = new Trip();
            trip.setAvailableSeats(vehicle.getCapacity());
            trip.setVehicleRegno(reg_no);
            trip.setCompleteStatus(dbCompleteValue);

            try{
                tripDao.registerTrip(trip);

                vehicle.setAvailability(false);
                getServletContext().getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            errors.append("Something went wrong");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
        }
    }

}