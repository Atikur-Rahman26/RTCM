package com.example.rtcm;

import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Tab;

import java.io.IOException;
import java.io.PipedReader;
import java.net.ConnectException;
import java.sql.*;
public class LoginDatabase {
    public void StartedTable() throws SQLException{


    }

    public void InsertUserData(String username,String Password,String emailId) throws SQLException{

        try {
            Connection connection=DriverManager.getConnection("jdbc:sqlite:G:\\RTCM\\src\\main\\resources\\RTCM.db");
            String tablename="RTCMLogin";

            String sqlStatement="INSERT INTO "+tablename+" (username,password,email) VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,Password);
            preparedStatement.setString(3,emailId);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void CreateTable(String Tablename)throws SQLException{
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:G:\\RTCM\\src\\main\\resources\\RTCM.db");
            String sqlStatemnet = "CREATE TABLE " + Tablename + " (username,password,email);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatemnet);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isHe(String username,String password) throws SQLException{
        int count=0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:G:\\RTCM\\src\\main\\resources\\RTCM.db");
            String sqlStament = "SELECT * FROM RTCMLogin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStament);

            while (resultSet.next()) {
                String store_username = resultSet.getString("username");
                String store_password = resultSet.getString("password");

                if (username.equals(store_username) && password.equals(store_password)) {
                    System.out.println("username: "+store_username+ " password: "+store_password);
                    count=1;
                    break;
                }
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
//        if(count==1){
//            return true;
//        }
//        else {
//            return false;
//        }
//      in the finishing time this should be added
        return true;

    }
}
