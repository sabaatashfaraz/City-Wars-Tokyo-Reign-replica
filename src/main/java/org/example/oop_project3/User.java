package org.example.oop_project3;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String answer;
    private String question;
    boolean haslogged;
    boolean logforgame;

    private String character;
    public List<Card> card;
    public List<Specialcard> specialcard;

    public List<Card> cardgame;

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    private int level;

    private double coin;
    private int XP;

    private boolean admin;
    private int HP;
    private ArrayList<gameInfo> games = new ArrayList<>();

    public User(String username,String password,String nickname,String email) {
        this.username = username;
        this.password=password;
        this.nickname=nickname;
        this.email=email;
        this.card= Card.randomcard();
        this.specialcard=Specialcard.randomspecialcard();
        this.admin=false;
        this.level=1;
        this.coin=100;
        this.logforgame=false;
        this.XP=0;
        this.HP=200;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAnswer(String answer) {
        this.answer =answer;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCoin() {
        return coin;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public ArrayList<gameInfo> getGames() {
        return games;
    }

    public List<Specialcard> getSpecialcard() {
        return specialcard;
    }
}
