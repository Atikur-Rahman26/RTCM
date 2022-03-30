package com.example.rtcm;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DasshBoard implements Initializable {

    @FXML
    private ImageView exit,minimize,DrawerImage;

    @FXML
    private AnchorPane DrawerPane,SideBarView;

    public static FXMLLoader fxmlLoader;
    public static Stage stage;

    public double x,y=0;


    public void dashboardStage(ActionEvent actionEvent) throws IOException{
        fxmlLoader=new FXMLLoader(getClass().getResource("DasshBoard.fxml"));

        Parent root=fxmlLoader.load();
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(event->{
            System.exit(0);
        });

        minimize.setOnMouseClicked(event->{
            Stage stage=(Stage) ((ImageView)event.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });

        SideBarView.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5), SideBarView);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),DrawerPane);
        translateTransition.setByX(-600);
        translateTransition.play();

        DrawerImage.setOnMouseClicked(event->{
            SideBarView.setVisible(true);

            System.out.println("1111");
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),SideBarView);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),DrawerPane);
            translateTransition1.setByX(+600);
            translateTransition1.play();

        });


        SideBarView.setOnMouseClicked(event->{
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),SideBarView);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(mouseEvent->{
                SideBarView.setVisible(false);
            });

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),DrawerPane);
            translateTransition1.setByX(-600);
            translateTransition1.play();
        });
    }

    public void profileButton(ActionEvent actionEvent) throws IOException{
        Profile profile=new Profile();
        profile.profileStage(actionEvent);
    }

    public void TrainSchedule(ActionEvent actionEvent) throws IOException{
        TrainSchedule trainSchedule=new TrainSchedule();
        trainSchedule.trainSchedule(actionEvent);
    }
}