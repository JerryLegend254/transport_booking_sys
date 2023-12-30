package com.psv.controller;

import com.psv.dao.VehicleDao;
import com.psv.model.Passenger;
import com.psv.model.Vehicle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VehicleRegServlet", value = "/vehicleReg")
public class VehicleRegServlet extends HttpServlet {
    VehicleDao vehicleDao = new VehicleDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder errors = new StringBuilder();
        String reg_no = request.getParameter("regNo");
        String capacity = request.getParameter("capacity");
        int vCapacity = Integer.parseInt(capacity);
        String[] selectedItems = request.getParameterValues("bus_stops");

        // Process the selected values as needed


        if(!reg_no.equals("") && !capacity.equals("")){
            Vehicle vehicle = new Vehicle();
            vehicle.setRegNo(reg_no);
            vehicle.setCapacity(vCapacity);
            vehicle.setBusStops(selectedItems);

            try{
                vehicleDao.registerVehicle(vehicle);
            }catch (Exception e){
                e.printStackTrace();
            }

            response.sendRedirect("adminDashboard.jsp");
        }else {
            errors.append("Something went wrong");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        }

    }
}