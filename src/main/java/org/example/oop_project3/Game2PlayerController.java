package org.example.oop_project3;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game2PlayerController {
    @FXML
    private AnchorPane boardPane;
    @FXML
    private ProgressBar progressBar1,progressBar2;
    @FXML
    private Button ok1,ok2;
    @FXML
    private ImageView ch1;

    @FXML
    private ImageView ch2;

    @FXML
    private ImageView card1p1;

    @FXML
    private ImageView card2p1;

    @FXML
    private ImageView card3p1;

    @FXML
    private ImageView card4p1;

    @FXML
    private ImageView card5p1;

    @FXML
    private ImageView card1p2;

    @FXML
    private ImageView card2p2;

    @FXML
    private ImageView card3p2;

    @FXML
    private ImageView card4p2;

    @FXML
    private ImageView card5p2;
    @FXML
    private ImageView p1c1,p1c2,p1c3,p1c4,p1c5,p1c6,p1c7,p1c8,p1c9,p1c10,p1c11,p1c12,p1c13,p1c14,p1c15,p1c16,p1c17,p1c18,p1c19,p1c20,p1c21,p2c1,p2c2,p2c3,p2c4,p2c5,p2c6,p2c7,p2c8,p2c9,p2c10,p2c11,p2c12,p2c13,p2c14,p2c15,p2c16,p2c17,p2c18,p2c19,p2c20,p2c21;
    @FXML
    private Label roundL,hpPlayer1,hpPlayer2,roundInfo;
    @FXML
    private Rectangle timeLineL;
    User player1 = new User("","","","");
    User player2 = new User("","","","");
    Image imagehulk = new Image(getClass().getResource("hulk.png").toExternalForm());
    Image imageshehulk = new Image(getClass().getResource("shehulk.png").toExternalForm());

    Image imageblackcat = new Image(getClass().getResource("blackcat.jpg").toExternalForm());
    Image imageblackpanter = new Image(getClass().getResource("blackpanter.jpg").toExternalForm());
    Image imageionBlast = new Image(getClass().getResource("ionBlast.png").toExternalForm());
    Image imageAcidevaporation = new Image(getClass().getResource("Acidevaporation.png").toExternalForm());
    Image imagebikerSupport = new Image(getClass().getResource("bikerSupport.png").toExternalForm());
    Image imageBulletFlurry = new Image(getClass().getResource("BulletFlurry.png").toExternalForm());
    Image imageChemichalChaos = new Image(getClass().getResource("ChemichalChaos.png").toExternalForm());
    Image imageCondenserFire = new Image(getClass().getResource("CondenserFire.png").toExternalForm());
    Image imageCryoDisintegration = new Image(getClass().getResource("CryoDisintegration.png").toExternalForm());
    Image imageCryoMeltDown = new Image(getClass().getResource("CryoMeltDown.png").toExternalForm());
    Image imageDivingFire = new Image(getClass().getResource("DivingFire.png").toExternalForm());
    Image imageearlyPrecision = new Image(getClass().getResource("earlyPrecision.png").toExternalForm());
    Image imageFromtheHip = new Image(getClass().getResource("FromtheHip.png").toExternalForm());
    Image imageGadgetBackUp = new Image(getClass().getResource("GadgetBackUp.png").toExternalForm());

    Image imageHazardShockWave = new Image(getClass().getResource("HazardShockWave.png").toExternalForm());
    Image imagelowBlow = new Image(getClass().getResource("lowBlow.png").toExternalForm());
    Image imagemultiFire = new Image(getClass().getResource("multiFire.png").toExternalForm());
    Image imagepiercerBullet = new Image(getClass().getResource("piercerBullet.png").toExternalForm());
    Image imageplasmaStrike = new Image(getClass().getResource("plasmaStrike.png").toExternalForm());
    Image imagepoisonDisperal = new Image(getClass().getResource("poisonDisperal.png").toExternalForm());
    Image imagebulletBlast = new Image(getClass().getResource("bulletBlast.png").toExternalForm());
    Image imageStealthSupport = new Image(getClass().getResource("StealthSupport.png").toExternalForm());
    Image imageShatteredAugmentation = new Image(getClass().getResource("ShatteredAugmentation.png").toExternalForm());
    Image imageShatteredWrath = new Image(getClass().getResource("ShatteredWrath.png").toExternalForm());
    Image imageShockImpairment = new Image(getClass().getResource("shockImpairment.png").toExternalForm());
    Image imageSideSwiper = new Image(getClass().getResource("sideSwiper.png").toExternalForm());
    Image imagepersistentFreeze = new Image(getClass().getResource("presistentFreeze.png").toExternalForm());
    Image imagefinalWarning = new Image(getClass().getResource("FinalWarning.png").toExternalForm());
    Image imageSulfuricSting = new Image(getClass().getResource("SulfuricSting.png").toExternalForm());
    Image imageToxicRecoil = new Image(getClass().getResource("toxicRecoil.png").toExternalForm());
    Image imagePoisonCounterFire = new Image(getClass().getResource("poisonDisperal.png").toExternalForm());
    Image imageShockAndAwe = new Image(getClass().getResource("ShockAndAwe.png").toExternalForm());
    Image imageShieldCard = new Image(getClass().getResource("ShieldCard.png").toExternalForm());
    Image imageRemedyCard = new Image(getClass().getResource("RemedyCard.png").toExternalForm());
    Image imagePowerBoosterCard = new Image(getClass().getResource("PowerBoosterCard.png").toExternalForm());
    Image imageHoleModifierCard = new Image(getClass().getResource("HoleModifierCard.png").toExternalForm());
    Image imageRepairCard = new Image(getClass().getResource("RepairCard.png").toExternalForm());
    Image imageroundReducerCard= new Image(getClass().getResource("roundReducerCard.png").toExternalForm());
    Image imageWeakeningCard = new Image(getClass().getResource("WeakeningCard.png").toExternalForm());
    Image blockCard = new Image(getClass().getResource("block.png").toExternalForm());
    Image rock = new Image(getClass().getResource("rock.png").toExternalForm());
    Image coin = new Image(getClass().getResource("coin.png").toExternalForm());
    private ImageView coinImageView = new ImageView(coin);
    public static ImageView[][] board= new ImageView[2][21];
    public static Card[][] CardBoard= new Card[2][21];
    int round = 4;

    @FXML
    public void initialize() {
        randomuser(RegisterController.haslogged(), RegisterController.hasloggedforgame());
        setimagechar(player1, ch1);
        setimagechar(player2, ch2);
        RegisterController.haslogged().setHP(200);
        RegisterController.hasloggedforgame().setHP(200);
        roundL.setText(String.valueOf(round));
        hpPlayer1.setText(String.valueOf(player1.getHP()));
        hpPlayer2.setText(String.valueOf(player2.getHP()));
        shuffleAndPrepareCards(RegisterController.haslogged());
        shuffleAndPrepareCards(RegisterController.hasloggedforgame());
        setcardimage(RegisterController.haslogged().cardgame.get(0), card1p1);
        setcardimage(RegisterController.haslogged().cardgame.get(1), card2p1);
        setcardimage(RegisterController.haslogged().cardgame.get(2), card3p1);
        setcardimage(RegisterController.haslogged().cardgame.get(3), card4p1);
        setcardimage(RegisterController.haslogged().cardgame.get(4), card5p1);
        setcardimage(RegisterController.hasloggedforgame().cardgame.get(0), card1p2);
        setcardimage(RegisterController.hasloggedforgame().cardgame.get(1), card2p2);
        setcardimage(RegisterController.hasloggedforgame().cardgame.get(2), card3p2);
        setcardimage(RegisterController.hasloggedforgame().cardgame.get(3), card4p2);
        setcardimage(RegisterController.hasloggedforgame().cardgame.get(4), card5p2);
        board[0][0] = p1c1;
        board[0][1] = p1c2;
        board[0][2] = p1c3;
        board[0][3] = p1c4;
        board[0][4] = p1c5;
        board[0][5] = p1c6;
        board[0][6] = p1c7;
        board[0][7] = p1c8;
        board[0][8] = p1c9;
        board[0][9] = p1c10;
        board[0][10] = p1c11;
        board[0][11] = p1c12;
        board[0][12] = p1c13;
        board[0][13] = p1c14;
        board[0][14] = p1c15;
        board[0][15] = p1c16;
        board[0][16] = p1c17;
        board[0][17] = p1c18;
        board[0][18] = p1c19;
        board[0][19] = p1c20;
        board[0][20] = p1c21;
        board[1][0] = p2c1;
        board[1][1] = p2c2;
        board[1][2] = p2c3;
        board[1][3] = p2c4;
        board[1][4] = p2c5;
        board[1][5] = p2c6;
        board[1][6] = p2c7;
        board[1][7] = p2c8;
        board[1][8] = p2c9;
        board[1][9] = p2c10;
        board[1][10] = p2c11;
        board[1][11] = p2c12;
        board[1][12] = p2c13;
        board[1][13] = p2c14;
        board[1][14] = p2c15;
        board[1][15] = p2c16;
        board[1][16] = p2c17;
        board[1][17] = p2c18;
        board[1][18] = p2c19;
        board[1][19] = p2c20;
        board[1][20] = p2c21;
        randomnumber();
        setupDragAndDrop(card1p1,1);
        setupDragAndDrop(card2p1,1);
        setupDragAndDrop(card3p1,1);
        setupDragAndDrop(card4p1,1);
        setupDragAndDrop(card5p1,1);

        setupDragAndDrop(card1p2,2);
        setupDragAndDrop(card2p2,2);
        setupDragAndDrop(card3p2,2);
        setupDragAndDrop(card4p2,2);
        setupDragAndDrop(card5p2,2);

        setupDropTarget(p1c1,1);
        setupDropTarget(p1c2,1);
        setupDropTarget(p1c3,1);
        setupDropTarget(p1c4,1);
        setupDropTarget(p1c5,1);
        setupDropTarget(p1c6,1);
        setupDropTarget(p1c7,1);
        setupDropTarget(p1c8,1);
        setupDropTarget(p1c9,1);
        setupDropTarget(p1c10,1);
        setupDropTarget(p1c11,1);
        setupDropTarget(p1c12,1);
        setupDropTarget(p1c13,1);
        setupDropTarget(p1c14,1);
        setupDropTarget(p1c15,1);
        setupDropTarget(p1c16,1);
        setupDropTarget(p1c17,1);
        setupDropTarget(p1c18,1);
        setupDropTarget(p1c19,1);
        setupDropTarget(p1c20,1);
        setupDropTarget(p1c21,1);

        setupDropTarget(p2c1,2);
        setupDropTarget(p2c2,2);
        setupDropTarget(p2c3,2);
        setupDropTarget(p2c4,2);
        setupDropTarget(p2c5,2);
        setupDropTarget(p2c6,2);
        setupDropTarget(p2c7,2);
        setupDropTarget(p2c8,2);
        setupDropTarget(p2c9,2);
        setupDropTarget(p2c10,2);
        setupDropTarget(p2c11,2);
        setupDropTarget(p2c12,2);
        setupDropTarget(p2c13,2);
        setupDropTarget(p2c14,2);
        setupDropTarget(p2c15,2);
        setupDropTarget(p2c16,2);
        setupDropTarget(p2c17,2);
        setupDropTarget(p2c18,2);
        setupDropTarget(p2c19,2);
        setupDropTarget(p2c20,2);
        setupDropTarget(p2c21,2);
    }
    private void shuffleAndPrepareCards(User user) {
        synchronized (user.card) {
            Random random = new Random();
            Collections.shuffle(user.card);
            List<Card> tempCardGame = new ArrayList<>(user.card.subList(0, 4));
            tempCardGame.add(user.specialcard.get(random.nextInt(4)));
            user.cardgame = tempCardGame;
        }
    }
    public void randomuser(User user1, User user2){
        player1=user1;
        player2=user2;
        showAlert("Error", this.player1.getUsername() + " you are first!");
    }

    public void setimagechar(User u, ImageView i) {
        String c = u.getCharacter();
        if (c.equals("Hulk")) {
            i.setImage(imagehulk);
            System.out.println("Hulk");
        } else if (c.equals("Shehulk")) {
            i.setImage(imageshehulk);
            System.out.println("shehulk");
        } else if (c.equals("Blackcat")) {
            i.setImage(imageblackcat);
        } else if (c.equals("BlackPanter")) {
            i.setImage(imageblackpanter);
        }
    }

    public void setcardimage(Card c, ImageView i) {
        if (c.getName().equals("bulletBlast")) {
            i.setImage(imagebulletBlast);
        } else if (c.getName().equals("StealthSupport")) {
            i.setImage(imageStealthSupport);
        } else if (c.getName().equals("ionBlast")) {
            i.setImage(imageionBlast);
        } else if (c.getName().equals("ShatteredAugmentation")) {
            i.setImage(imageShatteredAugmentation);
        } else if (c.getName().equals("ShatteredWrath")) {
            i.setImage(imageShatteredWrath);
        } else if (c.getName().equals("Acidevaporation")) {
            i.setImage(imageAcidevaporation);
        } else if (c.getName().equals("bikerSupport")) {
            i.setImage(imagebikerSupport);
        } else if (c.getName().equals("shockImpairment")) {
            i.setImage(imageShockImpairment);
        } else if (c.getName().equals("sideSwiper")) {
            i.setImage(imageSideSwiper);
        } else if (c.getName().equals("poisonDisperal")) {
            i.setImage(imagepoisonDisperal);
        } else if (c.getName().equals("presistentFreeze")) {
            i.setImage(imagepersistentFreeze);
        } else if (c.getName().equals("plasmaStrike")) {
            i.setImage(imageplasmaStrike);
        } else if (c.getName().equals("FinalWarning")) {
            i.setImage(imagefinalWarning);
        } else if (c.getName().equals("lowBlow")) {
            i.setImage(imagelowBlow);
        } else if (c.getName().equals("SulfuricSting")) {
            i.setImage(imageSulfuricSting);
        } else if (c.getName().equals("FromtheHip")) {
            i.setImage(imageFromtheHip);
        } else if (c.getName().equals("toxicRecoil")) {
            i.setImage(imageToxicRecoil);
        } else if (c.getName().equals("PoisonCounterFire")) {
            i.setImage(imagePoisonCounterFire);
        } else if (c.getName().equals("GadgetBackUp")) {
            i.setImage(imageGadgetBackUp);
        } else if (c.getName().equals("HazardShockWave")) {
            i.setImage(imageHazardShockWave);
        } else if (c.getName().equals("BulletFlurry")) {
            i.setImage(imageBulletFlurry);
        } else if (c.getName().equals("CryoDisintegration")) {
            i.setImage(imageCryoDisintegration);
        } else if (c.getName().equals("CryoMeltDown")) {
            i.setImage(imageCryoMeltDown);
        } else if (c.getName().equals("earlyPrecision")) {
            i.setImage(imageearlyPrecision);
        } else if (c.getName().equals("multiFire")) {
            i.setImage(imagemultiFire);
        } else if (c.getName().equals("piercerBullet")) {
            i.setImage(imagepiercerBullet);
        } else if (c.getName().equals("ChemichalChaos")) {
            i.setImage(imageChemichalChaos);
        } else if (c.getName().equals("ShockAndAwe")) {
            i.setImage(imageShockAndAwe);
        } else if (c.getName().equals("DivingFire")) {
            i.setImage(imageDivingFire);
        } else if (c.getName().equals("CondenserFire")) {
            i.setImage(imageCondenserFire);
        }
        else if (c.getName().equals("ShieldCard")){
            i.setImage(imageShieldCard);
        }
        else if (c.getName().equals("RemedyCard")){
            i.setImage(imageRemedyCard);
        }
        else if (c.getName().equals("PowerBoosterCard")){
            i.setImage(imagePowerBoosterCard);
        }
        else if (c.getName().equals("HoleModifierCard")){
            i.setImage(imageHoleModifierCard);
        }
        else if (c.getName().equals("RepairCard")){
            i.setImage(imageRepairCard);
        }
        else if (c.getName().equals("HoleModifierCard")){
            i.setImage(imagePowerBoosterCard);
        }
        else if (c.getName().equals("roundReducerCard")){
            i.setImage(imageroundReducerCard);
        }
        else if (c.getName().equals("WeakeningCard")){
            i.setImage(imageWeakeningCard);
        }
    }

    private void showAlert(String type, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    Card card1;
    private void setupDragAndDrop(ImageView card,int player) {
        card.setOnDragDetected(event -> {
            Dragboard db = card.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            if(player == 1){
                card1 = findCard(card.getImage().getUrl(),player1);
            }
            else if(player == 2){
                card1 = findCard(card.getImage().getUrl(),player2);
            }
            content.putImage(card.getImage());
            content.putString(String.valueOf(player));
            db.setContent(content);
            event.consume();
        });
    }
    Card sang = new Card("sang",0,1,0,0,0,"");
    private void setupDropTarget(ImageView cell,int player) {
        cell.setOnDragOver(event -> {
            Dragboard db = event.getDragboard();
            if (event.getGestureSource() != cell && db.hasImage() && db.hasString() && db.getString().equals(String.valueOf(player))) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
        cell.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            int block = -1; //block
            for (int i = 0; i < 21; i++) {
                if (board[player - 1][i].equals(cell)) {
                    block = i+1;
                    break;
                }
            }

            if (player == 1 && round != 0) {
                if (db.hasImage() && card1 != null && db.getString().equals(String.valueOf(player))) {
                    if (block >= 1 && block <= 21 - card1.getDuration() + 1) {
                        if (check(card1, block, 1)) {
                            for (int i = block - 1; i < block - 1 + card1.getDuration(); i++) {
                                if (!Specialcard.checkspecialcard(card1) && CardBoard[1][i] == null) {
                                    CardBoard[0][i] = card1;
                                    board[0][i].setImage(db.getImage());

                                } else if (!Specialcard.checkspecialcard(card1) && CardBoard[1][i] != null) {
                                    int cardAttack1 = card1.getCardAttack();
                                    int cardAttack2 = CardBoard[1][i].getCardAttack();
                                    if(CardBoard[1][i].getName().equals("block")){
                                        CardBoard[0][i] = card1;
                                        board[0][i].setImage(db.getImage());
                                    }
                                    else if (cardAttack2 == cardAttack1) {
                                        CardBoard[1][i] = sang;
                                        CardBoard[0][i] = sang;
                                        board[1][i].setImage(rock);
                                        board[0][i].setImage(rock);

                                    }
                                    else if (cardAttack1 > cardAttack2) {
                                        CardBoard[1][i] = sang;
                                        CardBoard[0][i] = card1;
                                        board[1][i].setImage(rock);
                                        board[0][i].setImage(db.getImage());

                                    } else if (cardAttack2 > cardAttack1) {
                                        CardBoard[0][i] = sang;
                                        board[0][i].setImage(rock);
                                    }
                                }
                                else if (Specialcard.checkspecialcard(card1) && CardBoard[1][i] != null) {
                                    if (!CardBoard[1][i].getName().equals("block") && !CardBoard[1][i].getName().equals("sang")) {
                                        if (card1.getName().equals("ShieldCard")) {
                                            Specialcard.Shield(1, i, CardBoard);
                                            CardBoard[0][i] = card1;
                                            board[0][i].setImage(db.getImage());

                                        } else if (card1.getName().equals("RemedyCard")) {
                                            player1.setHP(player1.getHP() + 20);
                                            CardBoard[0][i] = card1;
                                            board[0][i].setImage(db.getImage());
                                            showAlert("Info", player1.getUsername() + " HP has been increased");

                                        } else if (card1.getName().equals("PowerBoosterCard")) {
                                            Random random = new Random();
                                            int n = random.nextInt(5);
                                            while (Specialcard.checkspecialcard(player1.cardgame.get(n))) {
                                                n = random.nextInt(5);
                                            }
                                            player1.cardgame.get(n).setCardAttack(player1.cardgame.get(n).getCardAttack() + 10);
                                            showAlert("Info", "card attack of " + player1.cardgame.get(n).getName() + "has been increased" + "\n" + "new card attack: " + player1.cardgame.get(n).getCardAttack());

                                        } else if (card1.getName().equals("HoleModifierCard")) {
                                            Specialcard.HoleModifier(CardBoard, board, blockCard);

                                        } else if (card1.getName().equals("RepairCard")) {
                                            Specialcard.Repair(1,holefinder(CardBoard,1), CardBoard, board);

                                        } else if (card1.getName().equals("roundReducerCard")) {
                                            round--;
                                            showAlert("Error", "round has been reduced");

                                        } else if (card1.getName().equals("WeakeningCard")) {
                                            Specialcard.Weakening(player2);

                                        }
                                    }
                                    else {
                                        showAlert("Error", "its in front of a block or sang");
                                    }
                                }
                            }
                            success = true;
                            removecard(card1, player1);
                            addrandom(player1, 1);
                            hpPlayer1.setText(String.valueOf(player1.getHP()));
                            hpPlayer2.setText(String.valueOf(player2.getHP()));
                            showerror("it`s "+player2.getUsername()+" turn");
                        }
                    }
                    else {
                        showAlert("Error", "you cant place your card here");
                        return;
                    }
                    event.setDropCompleted(success);
                    event.consume();
                }
            }
            if (player == 2 && round!=0) {
                if (db.hasImage() && card1 != null && db.getString().equals(String.valueOf(player))) {
                    if (block >= 1 && block <= 21 - card1.getDuration() + 1) {
                        if (check(card1, block, 2)) {
                            for (int i = block - 1; i < block - 1 + card1.getDuration(); i++) {
                                if (!Specialcard.checkspecialcard(card1) && CardBoard[0][i] == null) {
                                    CardBoard[1][i] = card1;
                                    board[1][i].setImage(db.getImage());

                                } else if (!Specialcard.checkspecialcard(card1) && CardBoard[0][i] != null) {
                                    int cardAttack2 = card1.getCardAttack();
                                    int cardAttack1 = CardBoard[0][i].getCardAttack();
                                    if(CardBoard[0][i].getName().equals("block")){
                                        CardBoard[1][i] = card1;
                                        board[1][i].setImage(db.getImage());
                                    }
                                    else if (cardAttack2 == cardAttack1) {
                                        CardBoard[1][i] = sang;
                                        CardBoard[0][i] = sang;
                                        board[1][i].setImage(rock);
                                        board[0][i].setImage(rock);

                                    }
                                    else if (cardAttack2 > cardAttack1) {
                                        CardBoard[0][i] = sang;
                                        CardBoard[1][i] = card1;
                                        board[0][i].setImage(rock);
                                        board[1][i].setImage(db.getImage());
                                    }
                                    else if (cardAttack1 > cardAttack2) {
                                        CardBoard[1][i] = sang;
                                        board[1][i].setImage(rock);
                                    }
                                }
                                else if (Specialcard.checkspecialcard(card1) && CardBoard[0][i] != null) {
                                    if (!CardBoard[0][i].getName().equals("block") && !CardBoard[0][i].getName().equals("sang")) {
                                        if (card1.getName().equals("ShieldCard")) {
                                            Specialcard.Shield(2, i, CardBoard);
                                            CardBoard[1][i] = card1;
                                            board[1][i].setImage(db.getImage());

                                        } else if (card1.getName().equals("RemedyCard")) {
                                            player2.setHP(player2.getHP() + 20);
                                            CardBoard[1][i] = card1;
                                            board[1][i].setImage(db.getImage());
                                            showAlert("Info", player2.getUsername() + " HP has been increased");

                                        } else if (card1.getName().equals("PowerBoosterCard")) {
                                            Random random = new Random();
                                            int n = random.nextInt(5);
                                            while (Specialcard.checkspecialcard(player2.cardgame.get(n))) {
                                                n = random.nextInt(5);
                                            }
                                            player2.cardgame.get(n).setCardAttack(player2.cardgame.get(n).getCardAttack() + 10);
                                            showAlert("Info", "card attack of " + player2.cardgame.get(n).getName() + "has been increased" + "\n" + "new card attack: " + player2.cardgame.get(n).getCardAttack());

                                        } else if (card1.getName().equals("HoleModifierCard")) {
                                            Specialcard.HoleModifier(CardBoard, board, blockCard);

                                        } else if (card1.getName().equals("RepairCard")) {
                                            Specialcard.Repair(2,holefinder(CardBoard,2), CardBoard, board);
                                        }
                                        else if (card1.getName().equals("roundReducerCard")) {
                                            round--;
                                            showAlert("Error", "round has been reduced");

                                        } else if (card1.getName().equals("WeakeningCard")) {
                                            Specialcard.Weakening(player1);
                                        }
                                    }
                                    else {
                                        showAlert("Error", "its in front of a block or sang");
                                    }
                                }
                            }
                            success = true;
                            removecard(card1, player2);
                            addrandom(player2, 2);
                            round--;
                            roundL.setText(String.valueOf(round));
                            hpPlayer1.setText(String.valueOf(player1.getHP()));
                            hpPlayer2.setText(String.valueOf(player2.getHP()));
                            showerror("it`s "+player1.getUsername()+" turn");
                        }
                    }
                    else {
                        showAlert("Error", "you cant place your card here");
                        return;
                    }
                    event.setDropCompleted(success);
                    event.consume();
                }
            }
            if(round == 0){
                Random random = new Random();
                int n = random.nextInt(2);
                if(n == 0){
                    progressBar1.setVisible(true);
                    ok1.setVisible(true);
                    double randomAmount = random.nextDouble() * 0.1;
                    double currentProgress = progressBar1.getProgress();
                    double newProgress = currentProgress + randomAmount;
                    if(newProgress > 1.0){
                        newProgress = 1.0;
                    }
                    progressBar1.setProgress(newProgress);
                }
                else if(n==1){
                    progressBar2.setVisible(true);
                    ok2.setVisible(true);
                    double randomAmount = random.nextDouble() * 0.1;
                    double currentProgress = progressBar2.getProgress();
                    double newProgress = currentProgress + randomAmount;
                    if(newProgress > 1.0){
                        newProgress = 1.0;
                    }
                    progressBar2.setProgress(newProgress);
                }
            }
        });
    }
    private void showerror(String s){
        roundInfo.setText(s);
        roundInfo.setVisible(true);

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(8));
        pauseTransition.setOnFinished(event -> roundInfo.setVisible(false));
        pauseTransition.play();

    }
    private Card findCard(String url,User user){
        for(Card card:user.cardgame){
            if(url.contains(card.getName())){
                return card;
            }
        }
        return null;
    }
    public static Card block = new Card("block",0,1,0,0,0,"");
    public void randomnumber(){
        Random random = new Random();
        int n = random.nextInt(21);
        int m = random.nextInt(21);
        CardBoard[0][n]=block;
        CardBoard[1][m]=block;
        board[0][n].setImage(blockCard);
        board[1][m].setImage(blockCard);
    }
    public boolean check(Card card , int block , int playern){
        for (int i=block-1 ; i<block-1+card.getDuration() ; i++){
            if (CardBoard[playern-1][i]!=null && !CardBoard[playern-1][i].getName().equals("RepairCard")){
                showAlert("Error","you cant place your card here");
                return false;
            }
        }
        return true;
    }
    public int holefinder(Card[][] board , int p){
        int j=0;
        if (p==1){
            for (int i=0;i<21;i++){
                if(board[0][i] != null){
                    if (board[0][i].getName().equals("block")){
                        j=i;
                    }
                }
            }
        }
        else if (p==2){
            for (int i=0;i<21;i++){
                if(board[1][i] != null){
                    if (board[1][i].getName().equals("block")){
                        j=i;
                    }
                }
            }
        }
        return j;
    }
    public void removecard(Card c , User user){
        for(int i=0; i< user.cardgame.size(); i++){
            if(user.cardgame.get(i).getName().equals(c.getName())){
                user.cardgame.remove(i);
            }
        }
    }

    public boolean hasspecial(User user){
        for (Card card : user.cardgame){
            if (Specialcard.checkspecialcard(card)){
                return true;

            }
        }
        return false;
    }

    public void addrandom(User user,int player){
        Random random = new Random();
        if (hasspecial(user)){
            int r = random.nextInt(16);
            user.cardgame.add(user.card.get(r));
            if(user.card.get(r).getCharacter().equals(user.getCharacter())){
                user.card.get(r).setPlayerDamage(user.card.get(r).getPlayerDamage() + 10);
                showAlert("Info",user.card.get(r).getName()+" is upgraded because its character match with "+user.getUsername()+" character");
            }
        }
        else{
            int r = random.nextInt(4);
            user.cardgame.add(user.specialcard.get(r));
        }
        if(player == 1){
            setcardimage(RegisterController.haslogged().cardgame.get(0), card1p1);
            setcardimage(RegisterController.haslogged().cardgame.get(1), card2p1);
            setcardimage(RegisterController.haslogged().cardgame.get(2), card3p1);
            setcardimage(RegisterController.haslogged().cardgame.get(3), card4p1);
            setcardimage(RegisterController.haslogged().cardgame.get(4), card5p1);
        }
        else if(player == 2){
            setcardimage(RegisterController.hasloggedforgame().cardgame.get(0), card1p2);
            setcardimage(RegisterController.hasloggedforgame().cardgame.get(1), card2p2);
            setcardimage(RegisterController.hasloggedforgame().cardgame.get(2), card3p2);
            setcardimage(RegisterController.hasloggedforgame().cardgame.get(3), card4p2);
            setcardimage(RegisterController.hasloggedforgame().cardgame.get(4), card5p2);
        }
    }
    private void moveTimeline() {
        Timeline timeline = new Timeline();
        for (int i = 0; i < 21; i++) {
            final int position = i;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), event -> {
                timeLineL.setTranslateX(position * (60 + 10));

                if (CardBoard[0][position] != null) {
                    player2.setHP(Math.max(0,player2.getHP() - CardBoard[0][position].getPlayerDamage()));
                    hpPlayer2.setText(String.valueOf(Math.max(player2.getHP(),0)));
                }
                if (CardBoard[1][position] != null) {
                    player1.setHP(Math.max(0,player1.getHP() - CardBoard[1][position].getPlayerDamage()));
                    hpPlayer1.setText(String.valueOf(Math.max(player1.getHP(),0)));
                }

                if (player1.getHP() <= 0 || player2.getHP() <= 0) {
                    timeline.stop();
                    Platform.runLater(() -> {
                        if (player1.getHP() <= 0 && player2.getHP() > 0) {
                            if (betController.bet) {
                                player2.setCoin(player2.getCoin() + 2 * betController.betCoin);
                                player1.setCoin(player1.getCoin() - betController.betCoin);
                                gameInfo game = new gameInfo(player2,false, LocalDateTime.now(),-betController.betCoin);
                                player1.getGames().add(game);
                                moveCoin(2);
                                showAlert2("Info",player2.getUsername()+" won the bet and received "+2*betController.betCoin,this::goMain);
                            }
                            else {
                                player1.setXP(player1.getXP() + 20);
                                player1.setCoin(player1.getCoin() - 10);
                                player2.setXP(player2.getXP() + 100);
                                player2.setCoin(player2.getCoin() + 100 * player2.getLevel());
                                checkXP(player2);
                                checkXP(player1);
                                gameInfo game = new gameInfo(player2,false, LocalDateTime.now(),-10);
                                player1.getGames().add(game);
                                showAlert("info","gift of the game for "+player2.getUsername()+" is "+player2.getLevel()*100+" coins and 100 XP"+"\n"+"punishment of this game for "+player1.getUsername()+" -10 coins");
                            }
                            showAlert("Info", player2.getUsername() + " won!");
                        }
                        else if (player2.getHP() <= 0 && player1.getHP() > 0) {
                            if (betController.bet) {
                                player1.setCoin(player1.getCoin() + 2 * betController.betCoin);
                                player2.setCoin(player2.getCoin() - betController.betCoin);
                                gameInfo game = new gameInfo(player2,true, LocalDateTime.now(),2*betController.betCoin);
                                player1.getGames().add(game);
                                moveCoin(1);
                                showAlert2("Info",player1.getUsername()+" won the bet and received "+2*betController.betCoin,this::goMain);
                            }
                            else {
                                player2.setXP(player2.getXP() + 20);
                                player1.setXP(player1.getXP() + 100);
                                player1.setCoin(player1.getCoin() + 100 * player1.getLevel());
                                checkXP(player2);
                                checkXP(player1);
                                gameInfo game = new gameInfo(player2,true, LocalDateTime.now(),100 * player1.getLevel());
                                player1.getGames().add(game);
                                showAlert("info","gift of the game for "+player1.getUsername()+" is "+player1.getLevel()*100+" coins and 100 XP"+"\n"+"punishment of this game for "+player2.getUsername()+" -10 coins");
                            }
                            showAlert("Info", player1.getUsername() + " won!");
                        }
                    });
                }
            });
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.setOnFinished(event -> {
            Platform.runLater(() -> {
                if (player1.getHP() != 0 && player2.getHP() != 0) {
                    round = 4;
                    if (player1.getHP() > player2.getHP()) {
                        if(betController.bet){
                            player1.setCoin(player1.getCoin() + 2 * betController.betCoin);
                            player2.setCoin(player2.getCoin() - betController.betCoin);
                            gameInfo game = new gameInfo(player2,true, LocalDateTime.now(),2*betController.betCoin);
                            player1.getGames().add(game);
                            moveCoin(1);
                            showAlert2("Info",player1.getUsername()+" won the bet and received "+2*betController.betCoin,this::goMain);
                        }
                        else{
                            player2.setXP(player2.getXP() + 20);
                            player1.setXP(player1.getXP() + 100);
                            player1.setCoin(player1.getCoin() + 100 * player1.getLevel());
                            checkXP(player2);
                            checkXP(player1);
                            gameInfo game = new gameInfo(player2,true, LocalDateTime.now(),100*player1.getLevel());
                            player1.getGames().add(game);
                            showAlert("info","gift of the game for "+player1.getUsername()+" is "+player1.getLevel()*100+" coins and 100 XP"+"\n"+"punishment of this game for "+player2.getUsername()+" -10 coins");
                            showAlert("Info", player1.getUsername() + " is the winner");
                        }
                    }
                    else if (player2.getHP() > player1.getHP()) {
                        if(betController.bet){
                            player2.setCoin(player2.getCoin() + 2 * betController.betCoin);
                            player1.setCoin(player1.getCoin() - betController.betCoin);
                            gameInfo game = new gameInfo(player2,false, LocalDateTime.now(),-betController.betCoin);
                            player1.getGames().add(game);
                            moveCoin(2);
                            showAlert2("Info",player2.getUsername()+" won the bet and received "+2*betController.betCoin,this::goMain);
                        }
                        else{
                            player1.setXP(player1.getXP() + 20);
                            player1.setCoin(player1.getCoin() - 10);
                            player2.setXP(player2.getXP() + 100);
                            player2.setCoin(player2.getCoin() + 100 * player2.getLevel());
                            checkXP(player2);
                            checkXP(player1);
                            gameInfo game = new gameInfo(player2,false, LocalDateTime.now(),-10);
                            player1.getGames().add(game);
                            showAlert("info","gift of the game for "+player2.getUsername()+" is "+player2.getLevel()*100+" coins and 100 XP"+"\n"+"punishment of this game for "+player1.getUsername()+" -10 coins");
                            showAlert("Info", player2.getUsername() + " is the winner");
                        }
                    }
                    else{
                        showAlert("info","Tie");
                    }
                }
            });
        });

        timeline.play();
    }
    public void checkXP(User user){
        int XPLevel = 100 * user.getLevel();
        if (user.getXP()>=XPLevel){
            user.setXP(0);
            user.setLevel(user.getLevel()+1);
            showAlert2("Info",user.getUsername() + " level upgraded!",this::goMain);
        }
        else{
            showAlert2("Info","The game is finished!",this::goMain);
        }
    }
    public void goMain(){
        try {
            showAlert("Info",RegisterController.hasloggedforgame().getUsername()+" has logged out!");
            RegisterController.hasloggedforgame().logforgame = false;
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage1 = (Stage) roundInfo.getScene().getWindow();
            stage1.setScene(scene);
            stage1.show();
        }catch (IOException e){
            e.getCause();
        }
    }
    private void showAlert2(String type, String message, Runnable onClose) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setOnHidden(event -> onClose.run());
        alert.show();
    }
    @FXML
    public void progressB1(){
        double current = progressBar1.getProgress();
        double current2 = 50 * current;
        showerror(player2.getUsername()+" has lost this much HP "+ Math.abs((int)current2));
        player2.setHP(player2.getHP() -  Math.abs((int)current2));
        hpPlayer2.setText(String.valueOf(player2.getHP()));
        progressBar1.setVisible(false);
        ok1.setVisible(false);
        moveTimeline();
    }
    @FXML
    public void progressB2(){
        double current = progressBar2.getProgress();
        double current2 = 50 * current;
        showerror(player1.getUsername()+" has lost this much HP "+ Math.abs((int)current2));
        player1.setHP(player1.getHP() -  Math.abs((int)current2));
        hpPlayer1.setText(String.valueOf(player1.getHP()));
        progressBar2.setVisible(false);
        ok2.setVisible(false);
        moveTimeline();
    }
    private MediaPlayer mediaPlayer1;
    private Media media1;
    public void moveCoin(int player) {
        String musicPath1 = getClass().getResource("coinSound.mp3").toExternalForm();
        media1 = new Media(musicPath1);
        mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.stop();
        mediaPlayer1.seek(mediaPlayer1.getStartTime());
        mediaPlayer1.play();

        coinImageView.setFitWidth(50);
        coinImageView.setFitHeight(50);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), coinImageView);
        if(player == 1){
            coinImageView.setX(-400);
            coinImageView.setY(600);
            boardPane.getChildren().add(coinImageView);
            translateTransition.setFromX(-400);
            translateTransition.setFromY(600);
            translateTransition.setToX(1200);
            translateTransition.setToY(-300);
            translateTransition.setCycleCount(5);
            translateTransition.setAutoReverse(false);
        }
        else if(player == 2){
            coinImageView.setX(1200);
            coinImageView.setY(-300);
            boardPane.getChildren().add(coinImageView);
            translateTransition.setFromX(1200);
            translateTransition.setFromY(-300);
            translateTransition.setToX(-400);
            translateTransition.setToY(600);
            translateTransition.setCycleCount(5);
            translateTransition.setAutoReverse(false);
        }

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), coinImageView);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(5);
        rotateTransition.setAutoReverse(false);

        ParallelTransition parallelTransition = new ParallelTransition(translateTransition, rotateTransition);
        parallelTransition.play();
    }
}
