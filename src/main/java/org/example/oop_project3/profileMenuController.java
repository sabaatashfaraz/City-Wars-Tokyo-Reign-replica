package org.example.oop_project3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class profileMenuController {
    @FXML
    private ListView<String> information;
    @FXML
    private Button saveB,backB;
    @FXML
    private Label newUsernameLabel,newEmailLabel,changeNicknameLabel,changePassLabel,captchaLabel,newPassAgainLabel;
    @FXML
    private TextField newUsernameField, newEmailField,changeNicknameField,oldPassField,newPassField,captchaField,newPassAgainField;
    String captchaa;
    public void initialize(){
        String captcha = generateCaptcha(5);
        captchaa = captcha;
        String asciiArt = getAsciiArt(captcha);
        captchaLabel.setText(asciiArt);
    }
    @FXML
    public void showInformation() {
        information.getItems().clear();
        User u = RegisterController.haslogged();
        if (u != null) {
            information.getItems().add("Username: " + u.getUsername() + "\n" + "Password: " + u.getPassword() + "\n" + "Email: " + u.getEmail() + "\n" + "Nickname: " + u.getNickname());
        }
        else{
            showAlert("Error","You have to login first!");
        }
    }
    @FXML
    public void editProfile() {
        String email = newEmailField.getText();
        String username = newUsernameField.getText();
        String nickname = changeNicknameField.getText();
        String oldPassword = oldPassField.getText();
        String newPassword = newPassField.getText();
        String captchaAnswer = captchaField.getText();
        if(!username.matches("[a-zA-Z0-9]+") && !username.isEmpty()){
            showAlert("Error", "Incorrect format for Username!");
            return;
        }
        if (duplicateUsername(username) && !username.isEmpty()) {
            showAlert("Error", "This user already exists");
            return;
        }
        if (!email.matches("[a-zA-Z0-9]+@gmail.com") && !email.isEmpty()) {
            showAlert("Error", "Incorrect format for Email!");
            return;
        }
        if(!oldPassword.isEmpty() && !newPassword.isEmpty()){
            if(!oldPassword.equals(RegisterController.haslogged().getPassword())){
                showAlert("Error", "your old password is incorrect!");
                return;
            }
            if(!newPassword.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z]).{8,}$")){
                showAlert("Error", "Incorrect format for Password!");
                return;
            }
            //captcha ro neshoon bedim
            newPassAgainLabel.setVisible(true);
            newPassAgainField.setVisible(true);
            String passAgain = newPassAgainField.getText();

            if(!passAgain.equals(newPassword) && !passAgain.isEmpty()){
                showAlert("Error", "Enter your new password correctly");
                return;
            }
        }
        if(captchaAnswer.isEmpty()){
            showAlert("Error", "Enter the numbers you see");
            return;
        }
        if(!captchaAnswer.equals(captchaa)){
            showAlert("Error", "Incorrect, please try again.");
            String captcha = generateCaptcha(5);
            captchaa = captcha;
            String asciiArt = getAsciiArt(captcha);
            captchaLabel.setText(asciiArt);
            return;
        }
        editPro(email,username,nickname,newPassword);
        showAlert("Success", "Profile updated successfully!");
    }
    private void editPro(String email,String username, String nickname, String password){
        if(!email.isEmpty()){
            RegisterController.haslogged().setEmail(email);
        }
        if(!username.isEmpty()){
            RegisterController.haslogged().setUsername(username);
        }
        if(!nickname.isEmpty()){
            RegisterController.haslogged().setNickname(nickname);
        }
        if(!password.isEmpty()){
            RegisterController.haslogged().setPassword(password);
        }
    }
    private boolean duplicateUsername(String username) {
        for (User user : RegisterController.users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    private void showAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void back(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) backB.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
    private static final String[] DIGITS = {
            " 000 \n0   0\n0   0\n0   0\n 000 ",  // 0
            "  1  \n 11  \n  1  \n  1  \n11111",  // 1
            " 222 \n2   2\n   2 \n  2  \n22222",  // 2
            " 333 \n3   3\n  33 \n3   3\n 333 ",  // 3
            "4  4 \n4  4 \n44444\n   4 \n   4 ",  // 4
            "55555\n5    \n5555 \n    5\n5555 ",  // 5
            " 666 \n6    \n6666 \n6   6\n 666 ",  // 6
            "77777\n    7\n   7 \n  7  \n 7   ",  // 7
            " 888 \n8   8\n 888 \n8   8\n 888 ",  // 8
            " 999 \n9   9\n 9999\n    9\n 999 "   // 9
    };
    private static String generateCaptcha(int length) {
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = (int) (Math.random() * 10);
            captcha.append(digit);
        }
        return captcha.toString();
    }

    private String getAsciiArt(String captcha) {
        StringBuilder asciiArt = new StringBuilder();
        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            lines[i] = "";
        }

        for (char c : captcha.toCharArray()) {
            String[] digitLines = DIGITS[c - '0'].split("\n");
            for (int i = 0; i < 5; i++) {
                lines[i] += digitLines[i] + "  ";
            }
        }

        for (String line : lines) {
            asciiArt.append(line).append("\n");
        }
        return asciiArt.toString();
    }
}
