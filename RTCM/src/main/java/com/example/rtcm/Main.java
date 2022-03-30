package com.example.rtcm;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private AnchorPane welcomePane;

    public static double x,y=0;


    public static int count=0;
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = fxmlLoader.load();

        if(count==0){
            stage.initStyle(StageStyle.UNDECORATED);
            count++;
        }

        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        Scene scene=new Scene(root);
        stage.setTitle("RTCM");
        stage.setScene(scene);
        stage.show();
    }
}
