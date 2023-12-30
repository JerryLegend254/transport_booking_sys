package com.psv.dao;

import com.psv.connection.GetConnection;
import com.psv.model.BusStop;
import com.psv.model.Passenger;
import com.psv.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bus_StopDao {

    public List<String> getBusStops(){
        List<String> list = new ArrayList<String>();
        String sql = "SELECT * FROM bus_stops";
        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BusStop busStop = new BusStop();
                busStop.setBs_name(rs.getString("bs_name"));
                busStop.setPrice(rs.getInt("price"));

                list.add(busStop.getBs_name());
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }



    public BusStop getBusStop(String name){
        String sql = "SELECT * FROM bus_stops WHERE bs_name = ?";
        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                BusStop busStop = new BusStop();
                busStop.setBs_name(rs.getString("bs_name"));
                busStop.setPrice(rs.getInt("price"));
                return busStop;
            }
            else {
                System.out.println("Bus Stop was not found");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> getVehicles(String bs_name){
        List<Vehicle> list = new ArrayList<Vehicle>();
        String sql = "SELECT * FROM bs_stop_vehicles WHERE bus_stop_name = ?";

        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setString(1, bs_name);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                Vehicle vehicle = new Vehicle();
                vehicle.setRegNo(rs.getString("vehicle_regno"));
                list.add(vehicle);
            }
            else {
                System.out.println("No vehicles for the stops currently");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
}
