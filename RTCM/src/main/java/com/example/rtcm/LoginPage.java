package com.example.rtcm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPage implements Initializable{
    @FXML
    private ImageView exit,minimize;

    @FXML
    private TextField username;

    @FXML
    private PasswordField userpassword;

    @FXML
    private Label errorMessage;
    public  int login_counter;

    public static Stage stage;
    public static FXMLLoader fxmlLoader;
    private double x,y =0;
    public void loginPg(ActionEvent actionEvent) throws IOException {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root = fxmlLoader.load();

            root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });

            Scene scene = new Scene(root);
            stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
//            welcomingPage.getStage(stage);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });


        minimize.setOnMouseClicked(event->{
            Stage stage=(Stage) ((ImageView)event.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });
    }

    public void login(ActionEvent actionEvent) throws IOException{
        try{
            String userId,Password;

            userId=username.getText();
            Password=userpassword.getText();

            System.out.println(userId+ " "+Password);
            LoginDatabase loginDatabase=new LoginDatabase();
            if(loginDatabase.isHe(userId,Password)){
                DasshBoard dasshBoard=new DasshBoard();
                dasshBoard.dashboardStage(actionEvent);
            }
            else{
                LoginPage loginPage=fxmlLoader.getController();
                errorMessage.setText("username or password is incorrect");
                userpassword.setText("");
                username.setText("");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
