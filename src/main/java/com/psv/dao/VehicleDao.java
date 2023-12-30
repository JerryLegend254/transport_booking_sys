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

public class VehicleDao {

    public boolean registerVehicle(Vehicle vehicle){
        String INSERT_VEHICLES_SQL = "INSERT INTO vehicles (reg_no, capacity) VALUES (?, ?)";
        String stopsSql = "INSERT INTO bs_stop_vehicles (bus_stop_name, vehicle_regno) VALUES (?, ?)";

        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(INSERT_VEHICLES_SQL);
            pst.setString(1, vehicle.getRegNo());
            pst.setInt(2, vehicle.getCapacity());


            String[] bss = vehicle.getBusStops();
            for (String bs: bss) System.out.println(bs);

            if (vehicle.getBusStops() != null && vehicle.getBusStops().length > 0) {
                Bus_StopDao busStopDao = new Bus_StopDao();
                for (String stop : vehicle.getBusStops()) {
                    PreparedStatement ps = GetConnection.getConnection().prepareStatement(stopsSql);
                    BusStop busStop = busStopDao.getBusStop(stop);
                    ps.setString(1, busStop.getBs_name());
                    ps.setString(2, vehicle.getRegNo());
                    ps.executeUpdate();
                }
            }else{
                System.out.println("Something went wrong");
            }


            return pst.executeUpdate() > 0;



        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Vehicle getVehicle(String reg_no){
        String sql = "SELECT * FROM vehicles WHERE reg_no = ?";

        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setString(1, reg_no);


            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setRegNo(rs.getString("reg_no"));
                vehicle.setCapacity(rs.getInt("capacity"));
                return vehicle;
            }
            else {
                System.out.println("Invalid credentials");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> getAvailableVehicles(){
        List<Vehicle> list = new ArrayList<Vehicle>();
        String sql = "SELECT * FROM vehicles WHERE availability = 1";
        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setRegNo(rs.getString("reg_no"));
                vehicle.setCapacity(rs.getInt("capacity"));

                list.add(vehicle);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
