package com.psv.dao;

import com.psv.connection.GetConnection;
import com.psv.model.Passenger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDao {
    public boolean registerPassenger(Passenger passenger){
        String INSERT_PASSENGER_SQL = "INSERT INTO passengers (passenger_name, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(INSERT_PASSENGER_SQL);
            pst.setString(1, passenger.getName());
            pst.setString(2, passenger.getEmail());
            pst.setString(3, passenger.getPassword());

            return pst.executeUpdate() > 0;



        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Passenger getPassenger(String email, String pass){
        String sql = "SELECT * FROM passengers WHERE email = ? AND password = ?";
        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setName(rs.getString("passenger_name"));
                passenger.setEmail(rs.getString("email"));
                return passenger;
            }
            else {
                System.out.println("Invalid credentials");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
