package com.example.rtcm;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.Icon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome implements Initializable {
    @FXML
    private AnchorPane welcomePane,login;

    @FXML
    private Circle circle;

    ActionEvent actionEvent;
    @FXML
    private ImageView exit,minimize;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login.setVisible(false);

        try{
            Image image;
            image = new Image("G:\\RTCM\\src\\main\\resources\\com\\example\\rtcm\\image\\Logo.png");
            circle.setFill(new ImagePattern(image));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),welcomePane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);

        FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(2),welcomePane);
        fadeTransition1.setFromValue(1);
        fadeTransition1.setToValue(0);
        fadeTransition1.setCycleCount(1);

        FadeTransition fadeTransition11=new FadeTransition(Duration.seconds(2),login);
        fadeTransition11.setFromValue(0);
        fadeTransition11.setToValue(1);
        fadeTransition11.setCycleCount(1);

        fadeTransition.play();

        fadeTransition.setOnFinished(event->{
            fadeTransition1.play();
            fadeTransition11.play();
        });
        fadeTransition1.setOnFinished(event->{
            login.setVisible(true);
        });
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });
    }

    public void Admin(ActionEvent actionEvent) throws IOException {
        try {
            Admin admin=new Admin();
            admin.Adminpg(actionEvent);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void userLogin(ActionEvent actionEvent) throws IOException{
        try {
            LoginPage loginPage=new LoginPage();
            loginPage.loginPg(actionEvent);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
