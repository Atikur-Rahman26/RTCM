package com.example.rtcm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    @FXML
    private Label station,name,email,dateofBirth,district,upzilla;

    @FXML
    private ImageView exit,minimize;
    public static FXMLLoader fxmlLoader;
    public static Stage stage;

    public double x,y=0;

    public void SetText(String nam,String eml,String dateofbirth,String dstrct,String upzla,String stationNAme){
        station.setText(stationNAme);
        name.setText(nam);
        email.setText(eml);
        dateofBirth.setText(dateofbirth);
        district.setText(dstrct);
        upzilla.setText(upzla);
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });
    }
    public void profileStage(ActionEvent actionEvent) throws IOException{
        fxmlLoader=new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root=fxmlLoader.load();

        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y= mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Profile profile=fxmlLoader.getController();
        profile.SetText("Atikur Rahman","atikh152@gmail.com","06-09-2002","Narsingdi","Raipura","Amirganj Railway Station");
        stage.setScene(new Scene(root));
        stage.show();
    }

//    public String name(String );

    public void EditProfile(ActionEvent actionEvent) throws IOException{

        EditProfile editProfile=new EditProfile();
        editProfile.editPorfileStage(actionEvent);
        editProfile.SetText("Atikur Rahman","atikh152@gmail.com","06-09-2002","Narsingdi","Raipura","Amirganj");
    }


}
