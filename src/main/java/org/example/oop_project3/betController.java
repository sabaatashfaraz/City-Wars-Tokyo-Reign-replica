package org.example.oop_project3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class betController {
    @FXML
    private TextField player1Coin,player2Coin;
    @FXML
    private Button okB;
    public static int betCoin;
    public static boolean bet = false;

    @FXML
    public void initialize(){
        String betCoin1 = player1Coin.getText();
        String betCoin2 = player2Coin.getText();
        if(betCoin2.isEmpty() || betCoin1.isEmpty()){
            showAlert("Error", "Please fill in all fields.");
            return;
        }
        if(!betCoin1.equals(betCoin2)){
            showAlert("Error", "BetCoins should be equal!.");
            return;
        }
        if(Integer.parseInt(betCoin1) > RegisterController.haslogged().getCoin() || Integer.parseInt(betCoin2) > RegisterController.hasloggedforgame().getCoin()){
            showAlert("Error", " players dont have enough coins");
            return;
        }
        betCoin = Integer.parseInt(betCoin1);
        bet = true;
        showAlert("Info", "The gift of this game is "+2*betCoin);
        goback();
    }
    private void showAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void goback(){
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("game2player.fxml"));
            Parent map1Root = root.load();
            Stage stage = (Stage) okB.getScene().getWindow();
            Scene scene = new Scene(map1Root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.getCause();
        }
    }
}
