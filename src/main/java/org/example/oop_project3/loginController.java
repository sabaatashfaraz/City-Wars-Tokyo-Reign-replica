package org.example.oop_project3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class loginController {
    @FXML
    private Button loginB,forgetPassB;
    @FXML
    private TextField answerPassField,usernameLField,passLField,newPassField;
    @FXML
    private Label answerLabel,newPassLabel,countdownLabel;
    private int incorrectAttempts = 0;
    @FXML
    public void login(){
        String passL = passLField.getText();
        String usernameL = usernameLField.getText();
        if (passL.isEmpty() || usernameL.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }
        if(findUser(usernameL,passL) == null){
            showAlert("Error", "Wrong password!");
            incorrectAttempts++;
            startCountdown(5 * incorrectAttempts);
        }
        findUser(usernameL,passL).haslogged = true;
        showAlert("Success","Welcome!");
        goback();
    }
    @FXML
    public void forgetPassword(){
        String usernameL = usernameLField.getText();
        if(usernameL.isEmpty()){
            showAlert("Error", "Please enter your username!");
            return;
        }
        if (findUserByUsername(usernameL) == null) {
            showAlert("Error", "No user found with this username!");
            return;
        }
        answerLabel.setText(findUserByUsername(usernameL).getQuestion());
        answerLabel.setVisible(true);
        answerPassField.setVisible(true);
        String answerPass = answerPassField.getText();
        if(answerPass.isEmpty()){
            showAlert("Error", "Please enter your answer!");
            return;
        }
        if(!answerPass.equals(findUserByUsername(usernameL).getAnswer())){
            showAlert("Error", "Your answer is incorrect!");
            return;
        }
        newPassLabel.setVisible(true);
        newPassField.setVisible(true);
        String newPassword = newPassField.getText();
        if(newPassword.isEmpty()){
            showAlert("Error", "Enter your new password");
            return;
        }
        if(!newPassword.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z]).{8,}$")){
            showAlert("Error", "Incorrect format for Password!");
            return;
        }
        findUserByUsername(usernameL).setPassword(newPassword);
        findUserByUsername(usernameL).haslogged = true;
        showAlert("Success","Welcome!");
        goback();
    }
    private User findUserByUsername(String username){
        for(User user : RegisterController.users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    private User findUser(String username,String password){
        for(User user : RegisterController.users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
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
            FXMLLoader root = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
            Parent map1Root = root.load();
            Stage stage = (Stage) loginB.getScene().getWindow();
            Scene scene = new Scene(map1Root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.getCause();
        }
    }
    private void startCountdown(int seconds) {
        countdownLabel.setText("Try again in " + seconds + " seconds.");
        disableInputs();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int countdown = seconds;

            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (countdown > 0) {
                        countdownLabel.setText("Try again in " + countdown + " seconds.");
                        countdown--;
                    } else {
                        timer.cancel();
                        countdownLabel.setText("");
                        enableInputs();
                    }
                });
            }
        };
        timer.schedule(task, 0, 1000);
    }

    private void disableInputs() {
        usernameLField.setDisable(true);
        passLField.setDisable(true);
        loginB.setDisable(true);
    }

    private void enableInputs() {
        usernameLField.setDisable(false);
        passLField.setDisable(false);
        loginB.setDisable(false);
    }

    private void resetState() {
        incorrectAttempts = 0;
        countdownLabel.setText("");
    }
}
