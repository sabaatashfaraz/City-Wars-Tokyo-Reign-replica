package org.example.oop_project3;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Specialcard extends Card {
    public static ArrayList<Specialcard> specialcards = new ArrayList<>();

    private int cost;

    public Specialcard(String name, int duration,int cost) {
        super(name, duration);
        this.cost = cost;
    }

    public Specialcard(String name, int cardAttack, int duration, int playerDamage, int upgradeLevel, double upgradeCost, String character) {
        super(name, cardAttack, duration, playerDamage, upgradeLevel, upgradeCost, character);
    }

    public static List<Specialcard> randomspecialcard(){
        Collections.shuffle(Specialcard.specialcards);
        return Specialcard.specialcards.subList(0,4);
    }

    public static void Shield(int i,int j, Card[][] board){
        if (i==1){
            if (board[1][j]!=null){
                board[1][j].setPlayerDamage(0);
            }
        }
        if (i==2){
            if (board[0][j]!=null){
                board[0][j].setPlayerDamage(0);
            }
        }

    }

    public static void HoleModifier(Card[][] board, ImageView[][] imageBoard,Image blockCard){
        int j=0;
        for (int i=0;i<21;i++){
            if(board[0][i]!=null){
                if (board[0][i].getName().equals("block")){
                    j=i;
                }
            }
        }
        Random random = new Random();
        int newj = random.nextInt(21);
        while(board[0][newj]!=null || newj==j){
            newj = random.nextInt(21);
        }

        board[0][newj] = GameBoard.block;
        board[0][j] = null;
        imageBoard[0][newj].setImage(blockCard);
        imageBoard[0][j].setImage(null);
        j=0;
        for (int i=0;i<21;i++){
            if(board[1][i]!=null){
                if (board[1][i].getName().equals("block")){
                    j=i;
                }
            }
        }
        newj = random.nextInt(21);
        while(board[1][newj]!=null || newj==j){
            newj = random.nextInt(21);
        }
        board[1][newj] = GameBoard.block;
        board[1][j] = null;
        imageBoard[1][newj].setImage(blockCard);
        imageBoard[1][j].setImage(null);
    }

    public static void Repair (int i, int j, Card[][] board,ImageView[][] imageBoard){
        if (i==1){
            if(board[0][j] != null){
                board[0][j] = null;
                imageBoard[0][j].setImage(null);
            }
        }
        if (i==2){
            if(board[1][j] != null){
                board[1][j] = null;
                imageBoard[1][j].setImage(null);
            }
        }
    }


    public static void Weakening(User opponent){
        Random random = new Random();
        int n = random.nextInt(5);
        while(Specialcard.checkspecialcard(opponent.cardgame.get(n))){
            n = random.nextInt(5);
        }
        int m = random.nextInt(5);
        while(Specialcard.checkspecialcard(opponent.cardgame.get(m)) || m==n){
            m = random.nextInt(5);
        }
        opponent.cardgame.get(n).setCardAttack(opponent.cardgame.get(n).getCardAttack() - 5);
        showAlert("Info", "card attack of " + opponent.cardgame.get(n).getName() + "has been reduced" + "\n" + "new card attack: " + opponent.cardgame.get(n).getCardAttack());

        opponent.cardgame.get(m).setPlayerDamage(opponent.cardgame.get(m).getPlayerDamage() - 10);
        showAlert("Info", "player damage of " + opponent.cardgame.get(m).getName() + "has been reduced" + "\n" + "new card player damage: " + opponent.cardgame.get(m).getPlayerDamage());

    }

    private static void showAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean checkspecialcard(Card c){
        for (Specialcard card : specialcards){
            if (c.getName().equals(card.getName())){
                return true;
            }
        }
        return false;
    }

    public int getCost() {
        return cost;
    }
}
