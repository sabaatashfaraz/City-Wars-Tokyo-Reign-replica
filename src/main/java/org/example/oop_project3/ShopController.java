package org.example.oop_project3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopController {
    @FXML
    private Button backB,backB1,nextButton;
    public Card findcard(String s){
        for (Card card : Card.cards){
            if (card.getName().equals(s)){
                return card;
            }
        }
        return null;
    }
    public Specialcard findScard(String s){
        for (Specialcard card : Specialcard.specialcards){
            if (card.getName().equals(s)){
                return card;
            }
        }
        return null;
    }

    public void addBulletBlast(){
        Card c = findcard("bulletBlast");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("bulletBlast")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Info","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card!");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Info","you bought this card!");
            showAlert("Info","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void BulletBlast(){
        Card c = findcard("bulletBlast");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("bulletBlast")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addCondenserFire(){
        Card c = findcard("CondenserFire");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("CondenserFire")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Info","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void CondenserFire(){
        Card c = findcard("CondenserFire");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("CondenserFire")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addDivingFire(){
        Card c = findcard("DivingFire");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("DivingFire")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Info","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Info","you bought this card!");
            showAlert("Info","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void DivingFire(){
        Card c = findcard("DivingFire");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("DivingFire")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addShockAndAwe(){
        Card c = findcard("ShockAndAwe");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("ShockAndAwe")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Info","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Info","you bought this card!");
            showAlert("Info","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void ShockAndAwe(){
        Card c = findcard("ShockAndAwe");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("ShockAndAwe")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addChemicalChaos(){
        Card c = findcard("ChemichalChaos");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("ChemichalChaos")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void ChemicalChaos(){
        Card c = findcard("ChemichalChaos");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("ChemichalChaos")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addPiercerBullet(){
        Card c = findcard("piercerBullet");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("piercerBullet")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());

            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void PiercerBullet(){
        Card c = findcard("piercerBullet");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("piercerBullet")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addMultiFire(){
        Card c = findcard("multiFire");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("multiFire")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());

            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void MultiFire(){
        Card c = findcard("multiFire");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("multiFire")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addEarlyPrecision(){
        Card c = findcard("earlyPrecision");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("earlyPrecision")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void EarlyPrecision(){
        Card c = findcard("earlyPrecision");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("earlyPrecision")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addCryoMeltDown(){
        Card c = findcard("CryoMeltDown");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("CryoMeltDown")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void CryoMeltDown(){
        Card c = findcard("CryoMeltDown");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("CryoMeltDown")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addCryoDisintegration(){
        Card c = findcard("CryoDisintegration");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("CryoDisintegration")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void CryoDisintegration(){
        Card c = findcard("CryoDisintegration");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("CryoDisintegration")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addBulletFlurry(){
        Card c = findcard("BulletFlurry");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("BulletFlurry")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void BulletFlurry(){
        Card c = findcard("BulletFlurry");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("BulletFlurry")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addHazardShockWave(){
        Card c = findcard("HazardShockWave");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("HazardShockWave")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void HazardShockWave(){
        Card c = findcard("HazardShockWave");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("HazardShockWave")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addgadgetBackup(){
        Card c = findcard("GadgetBackUp");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("GadgetBackUp")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin() - c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void gadgetBackup(){
        Card c = findcard("GadgetBackUp");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("GadgetBackUp")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addStealthSupport(){
        Card c = findcard("StealthSupport");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("StealthSupport")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void StealthSupport(){
        Card c = findcard("StealthSupport");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("StealthSupport")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addIonBlast(){
        Card c = findcard("ionBlast");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("ionBlast")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void IonBlast(){
        Card c = findcard("ionBlast");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("ionBlast")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addShatteredAugmentation(){
        Card c = findcard("ShatteredAugmentation");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("ShatteredAugmentation")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void ShatteredAugmentation(){
        Card c = findcard("ShatteredAugmentation");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("ShatteredAugmentation")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addShatteredWrath(){
        Card c = findcard("ShatteredWrath");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("ShatteredWrath")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void ShatteredWrath(){
        Card c = findcard("ShatteredWrath");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("ShatteredWrath")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addAcidEvaporation(){
        Card c = findcard("Acidevaporation");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("Acidevaporation")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void AcidEvaporation(){
        Card c = findcard("Acidevaporation");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("Acidevaporation")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addbikerSupport(){
        Card c = findcard("bikerSupport");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("bikerSupport")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void bikerSupport(){
        Card c = findcard("bikerSupport");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("bikerSupport")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addShockImpairment(){
        Card c = findcard("shockImpairment");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("shockImpairment")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void ShockImpairment(){
        Card c = findcard("shockImpairment");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("shockImpairment")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addSideSwiper(){
        Card c = findcard("sideSwiper");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("sideSwiper")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void SideSwiper(){
        Card c = findcard("sideSwiper");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("sideSwiper")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addPoisonDispersal(){
        Card c = findcard("poisonDisperal");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("poisonDisperal")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void PoisonDispersal(){
        Card c = findcard("poisonDisperal");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("poisonDisperal")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addpersistentFreeze(){
        Card c = findcard("presistentFreeze");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("presistentFreeze")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void persistentFreeze(){
        Card c = findcard("presistentFreeze");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("presistentFreeze")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addplasmaStrike(){
        Card c = findcard("plasmaStrike");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("plasmaStrike")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void plasmaStrike(){
        Card c = findcard("plasmaStrike");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("plasmaStrike")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addfinalWarning(){
        Card c = findcard("FinalWarning");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("FinalWarning")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void finalWarning(){
        Card c = findcard("FinalWarning");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("FinalWarning")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addLowBlow(){
        Card c = findcard("lowBlow");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("lowBlow")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void LowBlow(){
        Card c = findcard("lowBlow");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("lowBlow")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addSulfuricSting(){
        Card c = findcard("SulfuricSting");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("SulfuricSting")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void SulfuricSting(){
        Card c = findcard("SulfuricSting");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("SulfuricSting")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addFromTheHip(){
        Card c = findcard("FromtheHip");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("FromtheHip")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void FromTheHip(){
        Card c = findcard("FromtheHip");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("FromtheHip")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addToxicRecoil(){
        Card c = findcard("toxicRecoil");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("toxicRecoil")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void ToxicRecoil(){
        Card c = findcard("toxicRecoil");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("toxicRecoil")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void addPoisonCounterFire(){
        Card c = findcard("poisonDisperal");
        for (Card card : RegisterController.haslogged().getCard()){
            if (card.getName().equals("poisonDisperal")){
                if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
                    Card.UpgradeCard(c);
                    RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
                    showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + card.getName()+"\n"+"Card Attack: " + card.getCardAttack()+"\n"+"Card Duration: " + card.getDuration()+"\n"+"Card Player Damage: " + card.getPlayerDamage()+"\n"+"Upgrade Level : " + card.getUpgradeLevel()+"\n"+"Upgrade Cost: " + card.getUpgradeCost());
                    return;
                }
                else{
                    showAlert("Error","you can`t buy this card");
                    return;
                }

            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getUpgradeCost() && RegisterController.haslogged().getLevel()>=c.getUpgradeLevel()){
            Card.UpgradeCard(c);
            RegisterController.haslogged().getCard().add(c);
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getUpgradeCost());
            showAlert("Error","you bought this card!");
            showAlert("Error","you upgrade this card to level "+c.getCardLevel()+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack()+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage()+"\n"+"Upgrade Level : " + c.getUpgradeLevel()+"\n"+"Upgrade Cost: " + c.getUpgradeCost());
            return;
        }
        else {
            showAlert("Error","you can`t buy this card");
            return;
        }
    }
    public void PoisonCounterFire(){
        Card c = findcard("poisonDisperal");
        showAlert("Info","Your card after being upgraded: "+"\n"+"Card level: "+c.getCardLevel2(c)+"\n"+"Card name : " + c.getName()+"\n"+"Card Attack: " + c.getCardAttack2(c)+"\n"+"Card Duration: " + c.getDuration()+"\n"+"Card Player Damage: " + c.getPlayerDamage2(c)+"\n"+"Upgrade Level : " + c.getUpgradeLevel2(c)+"\n"+"Upgrade Cost: " + c.getUpgradeCost2(c));
        for (Card card : RegisterController.haslogged().getCard()) {
            if (card.getName().equals("poisonDisperal")) {
                if (RegisterController.haslogged().getCoin() >= c.getUpgradeCost() && RegisterController.haslogged().getLevel() >= c.getUpgradeLevel()) {
                    showAlert("Info","You already have this card and you can updrade it");
                    return;
                }
                else{
                    showAlert("Info","You already have this card but you can`t updrade it");
                    return;
                }
            }
        }
        showAlert("Info","You don`t have this card!");
    }
    public void HoleModifierCard(){
        Specialcard c = findScard("HoleModifierCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("HoleModifierCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }
    public void ShieldCard(){
        Specialcard c = findScard("ShieldCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("ShieldCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }

    public void RemedyCard(){
        Specialcard c = findScard("RemedyCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("RemedyCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }

    public void PowerBoosterCard(){
        Specialcard c = findScard("PowerBoosterCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("PowerBoosterCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }

    public void RepairCard(){
        Specialcard c = findScard("RepairCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("RepairCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }

    public void roundReducerCard(){
        Specialcard c = findScard("roundReducerCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("roundReducerCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }

    public void WeakeningCard(){
        Specialcard c = findScard("WeakeningCard");
        for (Specialcard card : RegisterController.haslogged().getSpecialcard()){
            if (card.getName().equals("WeakeningCard")){
                showAlert("Info","You already have this card");
                return;
            }
        }
        if (RegisterController.haslogged().getCoin()>=c.getCost()){
            RegisterController.haslogged().setCoin(RegisterController.haslogged().getCoin()-c.getCost());
            RegisterController.haslogged().getSpecialcard().add(c);
            showAlert("Info","you bought this card");
            return;
        }
        else{
            showAlert("Info","you don`t have enough money");
            return;
        }
    }
    private void showAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void goNext(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShopNextPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) nextButton.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
    @FXML
    public void goBack(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) backB1.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
    @FXML
    public void goBack1(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Shop.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) backB.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
}
