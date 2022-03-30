package com.example.rtcm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TrainSchedule implements Initializable {
    public static int count=0;
    private int i=0;
    public static String string[][]=new String[50][7];
    @FXML
    private Label trainName,departureStation,DestinationStation,departureTime,DestinationTime,offDay;

    public static FXMLLoader fxmlLoader;
    public static Stage stage;
    public double x,y=0;

    public void trainSchedule(ActionEvent actionEvent) throws IOException{
        try{
            fxmlLoader=new FXMLLoader(getClass().getResource("TrainSchedule.fxml"));
            Parent root=fxmlLoader.load();

            root.setOnMousePressed(mouseEvent -> {
                x=mouseEvent.getSceneX();
                y=mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX()-x);
                stage.setY(mouseEvent.getScreenY()-y);
            });
            TrainScheduleDatabase trainScheduleDatabase=new TrainScheduleDatabase();
            string=trainScheduleDatabase.DisplayTrain();
            count=trainScheduleDatabase.getTotal_string();

//            for(int k=0;k<count;k++){
//                for(int j=0;j<6;j++){
//                    System.out.printf(string[i][j]);
//                    System.out.printf("-----------------");
//                }
//                System.out.println();
//            }

            System.out.println(count);
            TrainSchedule trainSchedule=fxmlLoader.getController();
            stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void display(String Tname,String DepartureStation,String destinationStation,String DepartureTime,String destinationTime,String Day){
        trainName.setText(Tname);
        departureStation.setText(DepartureStation);
        DestinationStation.setText(destinationStation);
        departureTime.setText(DepartureTime);
        DestinationTime.setText(destinationTime);
        offDay.setText(Day);

    }
    public void next(ActionEvent actionEvent) throws IOException, SQLException{
        display(string[i][0],string[i][1],string[i][2],string[i][3],string[i][4],string[i][5]);
        i++;
        if(i<count){
//            display(string[i][0],string[i][1],string[i][2],string[i][3],string[i][4],string[i][5]);
        }
        else {
            i=count-1;

        }

        System.out.println(string[i][5]);
    }

    public void prev(ActionEvent actionEvent) throws IOException,SQLException{
        display(string[i][0],string[i][1],string[i][2],string[i][3],string[i][4],string[i][5]);
        i--;
        if(i>=0){

        }
        else{
            i=0;
//            display(string[i][0],string[i][1],string[i][2],string[i][3],string[i][4],string[i][5]);
        }
        System.out.println(string[i][5]);
    }
}
