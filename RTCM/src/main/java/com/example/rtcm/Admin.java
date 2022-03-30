package com.example.rtcm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Admin {
    public void Adminpg(ActionEvent actionEvent) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
