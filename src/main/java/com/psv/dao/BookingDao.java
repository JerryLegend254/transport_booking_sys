package com.psv.dao;

import com.psv.connection.GetConnection;
import com.psv.model.Booking;
import java.sql.Date;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {

    public boolean bookTrip(Booking booking){
        String INSERT_BOOKING_SQL = "INSERT INTO bookings (passenger_name, vehicle_regno) VALUES (?, ?)";

        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(INSERT_BOOKING_SQL);
            pst.setString(1, booking.getPassenger_name());
            pst.setString(2, booking.getVeh_regno());

            return pst.executeUpdate() > 0;



        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Booking> getBookings(){
        List<Booking> list = new ArrayList<Booking>();
        String sql = "SELECT * FROM bookings";
        try {
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBook_id(rs.getInt("booking_id"));
                booking.setPassenger_name(rs.getString("passenger_name"));
                booking.setVeh_regno(rs.getString("vehicle_regno"));
                booking.setBooking_date(rs.getDate("booking_date"));

                list.add(booking);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }
}
