package org.example.oop_project3;

import java.time.LocalDateTime;

public class gameInfo {
    private User opponent;
    private boolean win;
    private LocalDateTime dateTime;
    private int gift;

    public User getOpponent() {
        return opponent;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public int getGift() {
        return gift;
    }
    public boolean winOrLoose(){
        return win;
    }
    public String showOpponentName(){
        return opponent.getUsername();
    }
    public int showOpponentLevel(){
        return opponent.getLevel();
    }

    public gameInfo(User opponent, boolean win, LocalDateTime dateTime, int gift) {
        this.opponent = opponent;
        this.win = win;
        this.dateTime = dateTime;
        this.gift = gift;
    }

    public String getwinlose(gameInfo g){
        if(g.win){
            return "Win";
        }
        else {
            return "Lose";
        }
    }
}
