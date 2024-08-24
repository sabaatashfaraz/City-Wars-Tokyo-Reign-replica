package org.example.oop_project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class mainMenuController {
    @FXML
    private ImageView imageView;
    @FXML
    private Label coin,xp,level,HP;
    Stage stage;
    Scene scene;
    @FXML
    public void initialize(){
        Image imagehulk = new Image(getClass().getResource("hulkPro.png").toExternalForm());
        Image imageShehulk = new Image(getClass().getResource("shehulkPro.png").toExternalForm());
        Image imageBlackCat = new Image(getClass().getResource("blackcatPro.png").toExternalForm());
        Image imageBlackPanter = new Image(getClass().getResource("blackpanterPro.png").toExternalForm());
        if(RegisterController.haslogged().getCharacter().equals("Hulk")){
            imageView.setImage(imagehulk);
        }
        else if(RegisterController.haslogged().getCharacter().equals("Shehulk")){
            imageView.setImage(imageShehulk);
        }
        else if(RegisterController.haslogged().getCharacter().equals("Blackcat")){
            imageView.setImage(imageBlackCat);
        }
        else if(RegisterController.haslogged().getCharacter().equals("BlackPanter")){
            imageView.setImage(imageBlackPanter);
        }
        coin.setText(String.valueOf(RegisterController.haslogged().getCoin()));
        xp.setText(String.valueOf(RegisterController.haslogged().getXP()));
        level.setText(String.valueOf(RegisterController.haslogged().getLevel()));
        HP.setText(String.valueOf(RegisterController.haslogged().getHP()));
    }

    public void Gamemode(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Gamehistory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("history.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profileMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Shop.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goSound(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sound.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goHome(ActionEvent event) throws IOException {
        showAlert("info",RegisterController.haslogged().getUsername()+" has logged out!");
        RegisterController.haslogged().haslogged= false;
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void showAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
