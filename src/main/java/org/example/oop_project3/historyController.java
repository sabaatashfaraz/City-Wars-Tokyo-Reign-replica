package org.example.oop_project3;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class historyController {

    Scene scene;
    Stage stage;

    @FXML
    private ComboBox<String> sort1;
    @FXML
    private ComboBox<String> sort2;
    @FXML
    private AnchorPane pane;
    @FXML
    private Pagination pagination;

    private static final int ITEMS_PER_PAGE = 3;
    @FXML
    public void initialize() {
        User user = new User("darya","1234Ss","sab","saba@gmail.com");
        LocalDateTime dateTime1 = LocalDateTime.of(2024,7,7,12,30,45);
        LocalDateTime dateTime2 = LocalDateTime.of(2023,6,25,13,36,49);
        LocalDateTime dateTime3 = LocalDateTime.of(2022,7,27,12,3,40);
        LocalDateTime dateTime4 = LocalDateTime.of(2021,5,17,14,39,5);
        RegisterController.haslogged().getGames().add(new gameInfo(RegisterController.haslogged(),true,dateTime3 ,300));
        RegisterController.haslogged().getGames().add(new gameInfo(user,false,dateTime1 ,200));
        RegisterController.haslogged().getGames().add(new gameInfo(RegisterController.haslogged(),true,dateTime2 ,100));
        RegisterController.haslogged().getGames().add(new gameInfo(user,false, dateTime4,400));
        sort1.setItems(FXCollections.observableArrayList("Sort by Date", "Sort by Oponnent", "Sort by win/lose","Sort by Level","Sort by gift"));
        sort2.setItems(FXCollections.observableArrayList("Ascending", "Descending"));
        int totalPages = (int) Math.ceil((double) RegisterController.haslogged().getGames().size() / ITEMS_PER_PAGE);
        pagination.setPageCount(totalPages);
        pagination.setCurrentPageIndex(0);
        pagination.setPageFactory(this::createPage);
        String sortby = sort1.getValue();
        String sorthow = sort2.getValue();
        if (sortby==null || sorthow==null){
            ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
            Comparator<gameInfo> comparator = null;
            comparator = Comparator.comparing(gameInfo::getDateTime);
            games.sort(comparator);
        }
        updatePage(0);
    }
    private AnchorPane createPage(int pageIndex) {
        updatePage(pageIndex);
        return new AnchorPane(); // Dummy node, required by setPageFactory
    }

    private void updatePage(int pageIndex) {
        List<Node> nodesToRemove = pane.getChildren().stream()
                .filter(node -> node instanceof Label)
                .collect(Collectors.toList());
        pane.getChildren().removeAll(nodesToRemove);

        int fromIndex = pageIndex * ITEMS_PER_PAGE;
        int toIndex = Math.min(fromIndex + ITEMS_PER_PAGE, RegisterController.haslogged().getGames().size());
        int count=0;
        for (int i=fromIndex; i<toIndex ; i++){
            count++;
            Label label = new Label();
            label.setPrefWidth(144);
            label.setPrefHeight(50);
            label.setLayoutX(0);
            label.setLayoutY(50+(50*(count-1)));
            label.setText(RegisterController.haslogged().getGames().get(i).getDateTime().toString());
            pane.getChildren().add(label);
        }

        count=0;
        for (int i=fromIndex; i<toIndex ; i++){
            count++;
            Label label = new Label();
            label.setPrefWidth(144);
            label.setPrefHeight(50);
            label.setLayoutX(144);
            label.setLayoutY(50+(50*(count-1)));
            label.setText(RegisterController.haslogged().getGames().get(i).getwinlose(RegisterController.haslogged().getGames().get(i)));
            pane.getChildren().add(label);
        }

        count=0;
        for (int i=fromIndex; i<toIndex ; i++){
            count++;
            Label label = new Label();
            label.setPrefWidth(144);
            label.setPrefHeight(50);
            label.setLayoutX(288);
            label.setLayoutY(50+(50*(count-1)));
            label.setText(RegisterController.haslogged().getGames().get(i).getOpponent().getUsername());
            pane.getChildren().add(label);
        }
        count=0;
        for (int i=fromIndex; i<toIndex ; i++){
            count++;
            Label label = new Label();
            label.setPrefWidth(144);
            label.setPrefHeight(50);
            label.setLayoutX(432);
            label.setLayoutY(50+(50*(count-1)));
            label.setText(Integer.toString(RegisterController.haslogged().getGames().get(i).getOpponent().getLevel()));
            pane.getChildren().add(label);
        }

        count=0;
        for (int i=fromIndex; i<toIndex ; i++){
            count++;
            Label label = new Label();
            label.setPrefWidth(144);
            label.setPrefHeight(50);
            label.setLayoutX(576);
            label.setLayoutY(50+(50*(count-1)));
            label.setText(Integer.toString(RegisterController.haslogged().getGames().get(i).getGift()));
            pane.getChildren().add(label);
        }
    }

    public void backtomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void sort(){
        String sortby = sort1.getValue();
        String sorthow = sort2.getValue();

        if (sortby==null || sorthow==null){
            ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
            Comparator<gameInfo> comparator = null;
            comparator = Comparator.comparing(gameInfo::getDateTime);
            games.sort(comparator);
        }
        else{
            if (sortby.equals("Sort by Date")){
                if (sorthow.equals("Ascending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::getDateTime);
                    games.sort(comparator);
                }
                else if (sorthow.equals("Descending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::getDateTime).reversed();
                    games.sort(comparator);
                }
            }
            else if (sortby.equals("Sort by Oponnent")){
                if (sorthow.equals("Ascending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::showOpponentName);
                    games.sort(comparator);
                }
                else if (sorthow.equals("Descending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::showOpponentName).reversed();
                    games.sort(comparator);
                }
            }
            else if (sortby.equals("Sort by win/lose")){
                if (sorthow.equals("Ascending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::winOrLoose);
                    games.sort(comparator);
                }
                else if (sorthow.equals("Descending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::winOrLoose).reversed();
                    games.sort(comparator);
                }
            }
            else if (sortby.equals("Sort by Level")){
                if (sorthow.equals("Ascending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::showOpponentLevel);
                    games.sort(comparator);
                }
                else if (sorthow.equals("Descending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::showOpponentLevel).reversed();
                    games.sort(comparator);
                }
            }
            else if (sortby.equals("Sort by gift")){
                if (sorthow.equals("Ascending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::getGift);
                    games.sort(comparator);
                }
                else if (sorthow.equals("Descending")){
                    ArrayList<gameInfo> games = RegisterController.haslogged().getGames();
                    Comparator<gameInfo> comparator = null;
                    comparator = Comparator.comparing(gameInfo::getGift).reversed();
                    games.sort(comparator);
                }
            }

        }
        updatePage(0);
    }

}
