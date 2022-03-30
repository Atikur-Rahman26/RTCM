package com.example.rtcm;


import java.io.IOException;

import java.sql.*;

public class TrainScheduleDatabase {
    public static int total_string=0;

    public void setTotal_string(int total_string) {
        TrainScheduleDatabase.total_string = total_string;
    }

    public  int getTotal_string() {
        return total_string;
    }
//    public static void main(String[] args) throws IOException,SQLException{
//        TrainScheduleDatabase trainScheduleDatabase=new TrainScheduleDatabase();
//        trainScheduleDatabase.CreateTable();
//        trainScheduleDatabase.InsertDataTrain("Sonar Bangla","Komolapur Railway Station","Chottogram","16:20","22:00","Tuesday");
//        trainScheduleDatabase.InsertDataTrain("Mohanagr Express","Komolapur Railway Station","Chottogram","22:20","05:00","Wednesday");
//        trainScheduleDatabase.DisplayTrain();
//    }

    public void CreateTable() throws IOException, SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:G:\\RTCM\\src\\main\\resources\\RTCM.db");
            String tablename = "RTCMTrainSchedule";
            String sqlStatement = "CREATE TABLE " + tablename + " (trainName TEXT,trainStartingStation TEXT,trainDestination TEXT,trainStartingTime TEXT,trainDestinationTime TEXT,trainOffDay TEXT);";
            PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void InsertDataTrain(String TName,String StartingStation,String EndingStation,String StartingTime,String DestinationTime,String OffDay) throws IOException,SQLException{
        try{
            Connection connection= DriverManager.getConnection("jdbc:sqlite:G:\\RTCM\\src\\main\\resources\\RTCM.db");
            String TableName="RTCMTrainSchedule";
            String StateMent="INSERT INTO "+ TableName+" (trainName,trainStartingStation,trainDestination,trainStartingTime,trainDestinationTime,trainOffDay) VALUES(?,?,?,?,?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(StateMent);
            preparedStatement.setString(1,TName);
            preparedStatement.setString(2,StartingStation);
            preparedStatement.setString(3,EndingStation);
            preparedStatement.setString(4,StartingTime);
            preparedStatement.setString(5,DestinationTime);
            preparedStatement.setString(6,OffDay);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String[][] DisplayTrain() throws SQLException,IOException{
        String[][] store=new String[50][7];
        int count=0,i=0,j=0;
        try{
            Connection connection=DriverManager.getConnection("jdbc:sqlite:G:\\RTCM\\src\\main\\resources\\RTCM.db");
            String stament="SELECT * FROM RTCMTrainSchedule";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(stament);

            System.out.println("--------------------------Train Schedule---------------------");
            while(resultSet.next()){
                String TrainName=resultSet.getString("trainName");
                String DepartureStation=resultSet.getString("trainStartingStation");
                String DestinationStation=resultSet.getString("trainDestination");
                String DepartureTime=resultSet.getString("trainStartingTime");
                String DestinationTime=resultSet.getString("trainDestinationTime");
                String OffDay=resultSet.getString("trainOffDay");

                store[i][0]=TrainName;
                store[i][1]=DepartureStation;
                store[i][2]=DestinationStation;
                store[i][3]=DepartureTime;
                store[i][4]=DestinationTime;
                store[i][5]=OffDay;
                System.out.println(OffDay);
                i++;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        setTotal_string(i);
        return store;
    }

}
