package org.example.oop_project3;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class SoundController {
    @FXML
    private Slider slider1,slider2;
    @FXML
    private Button bButton;
    private MediaPlayer mediaPlayer1,mediaPlayer2;
    private Media media1,media2;
    String musicPath1 = getClass().getResource("MainTheme.mp3").toExternalForm();
    String musicPath2 = getClass().getResource("MainTheme2.mp3").toExternalForm();

    @FXML
    public void initialize(){
        media1 = new Media(musicPath1);
        mediaPlayer1 = new MediaPlayer(media1);
        media2 = new Media(musicPath2);
        mediaPlayer2 = new MediaPlayer(media2);
        changeVolume1();
        changeVolume2();
    }
    @FXML
    public void playSong1() {
        mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer1.play();
    }
    @FXML
    public void playSong2() {
        mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer2.play();
    }

    public void changeVolume1(){
        mediaPlayer1.volumeProperty().bind(slider1.valueProperty().divide(100));
    }
    public void changeVolume2(){
        mediaPlayer2.volumeProperty().bind(slider2.valueProperty().divide(100));
    }
    @FXML
    public void pauseSong1(){
        mediaPlayer1.pause();
    }
    @FXML
    public void pauseSong2(){
        mediaPlayer2.pause();
    }
    @FXML
    private void goBack(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) bButton.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
}
