package org.example.oop_project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    public static ArrayList<Card> cards=new ArrayList<>();
    private String name;
    private int CardAttack;
    private int Duration;
    private int PlayerDamage;
    private int UpgradeLevel;
    private double UpgradeCost;
    private int cardLevel;
    private String character;

    public String getCharacter() {
        return character;
    }

    public Card(String name, int duration) {
        this.name = name;
        Duration = duration;
    }

    public Card(String name, int playerDamage, int duration, int cardAttack, int upgradeLevel, double upgradeCost, String character) {
        this.name = name;
        CardAttack = cardAttack;
        Duration = duration;
        PlayerDamage = playerDamage;
        UpgradeLevel = upgradeLevel;
        UpgradeCost = upgradeCost;
        this.cardLevel = 1;
        this.character=character;
    }

    public static List<Card> randomcard(){
        Collections.shuffle(Card.cards);
        return cards.subList(0,16);
    }

    public String getName() {
        return name;
    }

    public int getCardAttack() {
        return CardAttack;
    }
    public int getCardAttack2(Card card) {

        return card.getCardAttack()+10;
    }

    public int getDuration() {
        return Duration;
    }

    public int getPlayerDamage() {
        return PlayerDamage;
    }
    public int getPlayerDamage2(Card card) {

        return card.getPlayerDamage()+3;
    }

    public int getUpgradeLevel() {
        return UpgradeLevel;
    }
    public int getUpgradeLevel2(Card card) {

        return card.getUpgradeLevel()+1;
    }

    public double getUpgradeCost() {
        return UpgradeCost;
    }
    public double getUpgradeCost2(Card card) {
        return Math.pow(1.25,card.getCardLevel()) * card.getUpgradeCost();
    }
    public int getCardLevel() {
        return cardLevel;
    }
    public int getCardLevel2(Card card) {
        return card.getCardLevel()+1;
    }
    public void setPlayerDamage(int playerDamage) {
        PlayerDamage = playerDamage;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setCardLevel(int cardLevel) {
        this.cardLevel = cardLevel;
    }

    public void setCardAttack(int cardAttack) {
        CardAttack = cardAttack;
    }

    public static void UpgradeCard(Card card){
        card.cardLevel++;
        card.CardAttack+=10;
        card.PlayerDamage+=3;
        card.setUpgradeLevel(card.getUpgradeLevel()+1);
        card.setUpgradeCost(Math.pow(1.25,card.getCardLevel()-1) * card.getUpgradeCost());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpgradeLevel(int upgradeLevel) {
        UpgradeLevel = upgradeLevel;
    }

    public void setUpgradeCost(double upgradeCost) {
        UpgradeCost = upgradeCost;
    }
}
