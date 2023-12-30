package com.psv.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection connection;
    public static Connection getConnection(){
        String dbUrl = "jdbc:mysql://localhost:3306/psv_sys";
        String dbUsername = "root";
        String dbPassword = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            return connection;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
