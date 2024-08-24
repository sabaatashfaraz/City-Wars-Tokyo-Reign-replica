package org.example.oop_project3;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class RegisterController {
    @FXML
    private Button signinB,randomB,backB;
    @FXML
    private Label error,captchaLabel;
    @FXML
    private TextField usernameField,passField,nicknameField,emailField,answerField,captchaField;
    @FXML
    private ComboBox<String> security,setCharacter;
    public static ArrayList<User> users = new ArrayList<>();
    boolean randomPass = false;
    boolean add = false;
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
    String captchaa;
    public void initialize(){
        addCards();
        security.setItems(FXCollections.observableArrayList("•1-What is your father’s name ?", "•2-What is your favourite color ?", "•3-What was the name of your first pet?"));
        setCharacter.setItems(FXCollections.observableArrayList("Hulk","Shehulk","Blackcat","BlackPanter"));
        String captcha = generateCaptcha(5);
        captchaa = captcha;
        String asciiArt = getAsciiArt(captcha);
        captchaLabel.setText(asciiArt);
    }

    @FXML
    public void signin(){
        String email = emailField.getText();
        String password = passField.getText();
        String username = usernameField.getText();
        String nickname = nicknameField.getText();
        String answer = answerField.getText();
        String securityQ = security.getValue();
        String charcater = setCharacter.getValue();
        String captchaAnswer = captchaField.getText();
        if (email.isEmpty() || password.isEmpty() || username.isEmpty() || nickname.isEmpty() || answer.isEmpty() || securityQ == null || charcater == null) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }
        if(!username.matches("[a-zA-Z0-9]+")){
            showAlert("Error", "Incorrect format for Username!");
            return;
        }
        if(duplicateUsername(username)){
            showAlert("Error", "This user already exists");
            return;
        }
        if (!email.matches("[a-zA-Z0-9]+@gmail.com")) {
            showAlert("Error", "Incorrect format for Email!");
            return;
        }
        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z]).{8,}$") && !randomPass) {
            showAlert("Error", "Incorrect format for Password!");
            return;
        }
        if(randomPass){
            if(!error.getText().equals(password)){
                showAlert("Error", "Your password doesnt match with random password!");
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
        User user = new User(username,password,nickname,email);
        user.setQuestion(securityQ);
        user.setAnswer(answer);
        user.setCharacter(charcater);
        users.add(user);
        showAlert("Success", "Account created successfully!");
        showAlert("Success"," you received 20 cards as a starter pack!");
    }
    private void showAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private boolean duplicateUsername(String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    @FXML
    private void goBack(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) backB.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
    @FXML
    public void randomPassword(){
        randomPass = true;
        Random random = new Random();
        StringBuilder password = new StringBuilder(8);
        String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Characters2="abcdefghijklmnopqrstuvwxyz";
        String Digits="0123456789";
        String Scharecters="!@#$%&*_?";
        for(int i=0;i<2;i++){
            password.append(Characters.charAt(random.nextInt(Characters.length())));
        }
        for(int i=0;i<1;i++){
            password.append(Characters2.charAt(random.nextInt(Characters2.length())));
        }
        for(int i=0;i<3;i++){
            password.append(Digits.charAt(random.nextInt(Digits.length())));
        }
        for(int i=0;i<2;i++){
            password.append(Scharecters.charAt(random.nextInt(Scharecters.length())));
        }
        error.setText(password.toString());
        error.setVisible(true);
    }
    public static User haslogged(){
        for (int i=0;i<users.size();i++){
            if (users.get(i).haslogged){
                return users.get(i);
            }
        }
        return null;
    }
    public static User hasloggedforgame(){
        for (int i=0;i<users.size();i++){
            if (users.get(i).logforgame){
                return users.get(i);
            }
        }
        return null;
    }
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
    private void addCards(){
        if(!add){
            Card c1 = new Card("bulletBlast",30,2,28,1,30,"BlackPanter");
            Card c2 = new Card("StealthSupport",20,2,29,2,200, "Hulk");
            Card c3 = new Card("ionBlast",10,2,27,1,100,"Shehulk");
            Card c4 = new Card("ShatteredAugmentation",40,5,25,3,400,"Blackcat");
            Card c5 = new Card("ShatteredWrath",40,4,20,1,100,"BlackPanter");
            Card c6 = new Card("Acidevaporation",25,1,36,4,500,"Hulk");
            Card c7 = new Card("bikerSupport",21,3,32,4,500,"Shehulk");
            Card c8 = new Card("shockImpairment",25,1,37,2,100,"Blackcat");
            Card c9 = new Card("sideSwiper",50,1,30,4,500,"BlackPanter");
            Card c10 = new Card("poisonDisperal",37,1,31,2,100,"Hulk");
            Card c11 = new Card("presistentFreeze",50,2,36,2,150,"Shehulk");
            Card c12 = new Card("plasmaStrike",16,1,32,2,200,"Blackcat");
            Card c13 = new Card("FinalWarning",25,5,28,3,250,"BlackPanter");
            Card c14 = new Card("lowBlow",20,4,33,3,300,"Hulk");
            Card c15 = new Card("SulfuricSting",33,3,31,3,300,"Shehulk");
            Card c16 = new Card("FromtheHip",28,1,28,2,300,"Blackcat");
            Card c17 = new Card("toxicRecoil",44,2,34,3,400,"BlackPanter");
            Card c18 = new Card("PoisonCounterFire",25,1,35,4,500,"Hulk");
            Card c19 = new Card("GadgetBackUp",36,2,32,2,300,"Shehulk");
            Card c20 = new Card("HazardShockWave",40,4,34,2,350,"Blackcat");
            Card c21 = new Card("BulletFlurry",36,4,26,2,150,"BlackPanter");
            Card c22 = new Card("CryoDisintegration",30,1,27,2,150,"Hulk");
            Card c23 = new Card("CryoMeltDown",25,1,33,3,200,"Shehulk");
            Card c24 = new Card("earlyPrecision",25,5,29,3,200,"Blackcat");
            Card c25 = new Card("multiFire",26,2,30,1,100,"BlackPanter");
            Card c26 = new Card("piercerBullet",27,3,29,3,500,"Hulk");
            Card c27 = new Card("ChemichalChaos",30,2,32,3,300,"Shehulk");
            Card c28 = new Card("ShockAndAwe",40,4,28,4,600,"Blackcat");
            Card c29 = new Card("DivingFire",45,3,33,3,250,"BlackPanter");
            Card c30 = new Card("CondenserFire",48,3,31,2,200,"Blackcat");
            Specialcard sc1 = new Specialcard("ShieldCard",1,200);
            Specialcard sc2 = new Specialcard("RemedyCard",1,200);
            Specialcard sc3 = new Specialcard("PowerBoosterCard",1,100);
            Specialcard sc4 = new Specialcard("HoleModifierCard",1,150);
            Specialcard sc5 = new Specialcard("RepairCard",1,100);
            Specialcard sc6 = new Specialcard("roundReducerCard",1,250);
            Specialcard sc7 = new Specialcard("WeakeningCard",1,150);

            Card.cards.add(c1);
            Card.cards.add(c2);
            Card.cards.add(c3);
            Card.cards.add(c4);
            Card.cards.add(c5);
            Card.cards.add(c6);
            Card.cards.add(c7);
            Card.cards.add(c8);
            Card.cards.add(c9);
            Card.cards.add(c10);
            Card.cards.add(c11);
            Card.cards.add(c12);
            Card.cards.add(c13);
            Card.cards.add(c14);
            Card.cards.add(c15);
            Card.cards.add(c16);
            Card.cards.add(c17);
            Card.cards.add(c18);
            Card.cards.add(c19);
            Card.cards.add(c20);
            Card.cards.add(c21);
            Card.cards.add(c22);
            Card.cards.add(c23);
            Card.cards.add(c24);
            Card.cards.add(c25);
            Card.cards.add(c26);
            Card.cards.add(c27);
            Card.cards.add(c28);
            Card.cards.add(c29);
            Card.cards.add(c30);

            Specialcard.specialcards.add(sc1);
            Specialcard.specialcards.add(sc2);
            Specialcard.specialcards.add(sc3);
            Specialcard.specialcards.add(sc4);
            Specialcard.specialcards.add(sc5);
            Specialcard.specialcards.add(sc6);
            Specialcard.specialcards.add(sc7);
            add = true;
        }
    }
}
