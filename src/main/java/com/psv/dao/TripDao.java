package com.psv.dao;

import com.psv.connection.GetConnection;
import com.psv.model.Trip;
import com.psv.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripDao {

    public boolean registerTrip(Trip trip){
        String INSERT_TRIP_SQL = "INSERT INTO scheduled_trips (vehicle_regno, complete_status, available_seats) VALUES (?, ?, ?)";
        String changeAvailability = "UPDATE vehicles SET availability = ? WHERE reg_no = ?";

        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(INSERT_TRIP_SQL);
            pst.setString(1, trip.getVehicleRegno());
            pst.setBoolean(2, trip.isCompleteStatus());
            pst.setInt(3, trip.getAvailableSeats());

            PreparedStatement ps = GetConnection.getConnection().prepareStatement(changeAvailability);
            ps.setBoolean(1, false);
            ps.setString(2, trip.getVehicleRegno());
            ps.executeUpdate();




            return pst.executeUpdate() > 0;



        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public List<Vehicle> getAvailableTripVehicles(List<Vehicle> bs_vehicles){
        List<Vehicle> list = new ArrayList<Vehicle>();
        String sql = "SELECT * FROM scheduled_trips WHERE vehicle_regno = ? AND complete_status = ?";

        try{


        for(Vehicle v: bs_vehicles){
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setString(1,v.getRegNo());
            pst.setBoolean(2, false);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Vehicle vehicle = new Vehicle();
                vehicle.setRegNo(rs.getString("vehicle_regno"));
                vehicle.setBookingNo(rs.getInt("trip_id"));
                list.add(vehicle);
            }

        }
        } catch (SQLException e){
            e.printStackTrace();
        }


        return list;
    }


    public boolean updateAvailableSeats(int trip_id){
        String sql = "SELECT available_seats FROM scheduled_trips WHERE trip_id = ?";
        String changeAvailability = "UPDATE scheduled_trips SET available_seats = ? WHERE trip_id = ?";
        try{
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setInt(1, trip_id);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int oldValSeats = rs.getInt("available_seats");
                oldValSeats -= 1;

                PreparedStatement ps = GetConnection.getConnection().prepareStatement(changeAvailability);
                ps.setInt(1, oldValSeats);
                ps.setInt(2, trip_id);
                ps.executeUpdate();
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }



        return false;
    }

    public String getVehiclReg(int trip_id){
        String sql = "SELECT vehicle_regno FROM scheduled_trips WHERE trip_id = ?";

        try{
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setInt(1, trip_id);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String veh_regno = rs.getString("vehicle_regno");

                return veh_regno;

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
