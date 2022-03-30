package com.example.rtcm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditProfile implements Initializable {

    @FXML
    private ImageView exit,minimize,DrawerImage;

    @FXML
    private TextField name,email,dateofBirth,district,upzilla,station;

    public static FXMLLoader fxmlLoader;
    public static Stage stage;

    public double x,y=0;

    public void SetText(String naMe,String Email,String DateOfBirtth,String District,String Upzilla,String Station){
        Profile profile=fxmlLoader.getController();
        name.setText(naMe);
        email.setText(Email);
        dateofBirth.setText(DateOfBirtth);
        district.setText(District);
        upzilla.setText(Upzilla);
        station.setText(Station);
    }
    public void editPorfileStage(ActionEvent actionEvent) throws IOException{

        fxmlLoader=new FXMLLoader(getClass().getResource("EditProfile.fxml"));
        Parent root=fxmlLoader.load();

        root.setOnMousePressed(mouseEvent -> {
            x= mouseEvent.getSceneX();
            y= mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        EditProfile editProfile=fxmlLoader.getController();
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

//        String nam,eml,dob,dstrct,upzl,st;
//        nam=
//        SetText();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void initialize(URL url, ResourceBundle resourceBundle){
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            stage=(Stage)((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });


    }

    public void save(ActionEvent actionEvent) throws IOException{


    }


    public void canCel(ActionEvent actionEvent) throws IOException{

    }

    public void Back(ActionEvent actionEvent) throws IOException{
        Profile profile=new Profile();
        profile.profileStage(actionEvent);
    }

}
