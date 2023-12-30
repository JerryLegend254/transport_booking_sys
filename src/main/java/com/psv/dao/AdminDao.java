package com.psv.dao;

import com.psv.connection.GetConnection;
import com.psv.model.Admin;

import java.sql.*;

public class AdminDao {
    public boolean registerAdmin(Admin admin){
        String INSERT_ADMIN_SQL = "INSERT INTO admins (admin_name, email, password) VALUES (?, ?, ?)";

        try{
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(INSERT_ADMIN_SQL);
            pst.setString(1, admin.getName());
            pst.setString(2, admin.getEmail());
            pst.setString(3, admin.getPassword());

            return pst.executeUpdate() > 0;



        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Admin getAdmin(String email, String pass){
        String sql = "SELECT * FROM admins WHERE email = ? AND password= ?";
        try{
            PreparedStatement pst = GetConnection.getConnection().prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setName(rs.getString("admin_name"));
                admin.setEmail(rs.getString("email"));
                return admin;
            }else {
                System.out.println("Invalid credentials");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
