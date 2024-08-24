package org.example.oop_project3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button signupB,loginB;
    @FXML
    public void signUpPage(){
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent map1Root = root.load();
            RegisterController registerController = root.getController();
            registerController.initialize();
            Stage stage = (Stage) signupB.getScene().getWindow();
            Scene scene = new Scene(map1Root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.getCause();
        }
    }
    @FXML
    public void loginPage(){
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent map1Root = root.load();
            Stage stage = (Stage) loginB.getScene().getWindow();
            Scene scene = new Scene(map1Root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.getCause();
        }
    }
}