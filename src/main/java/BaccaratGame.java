import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class BaccaratGame extends Application /*implements EventHandler<ActionEvent> */ {

    ArrayList<Card> playerHand;
    ArrayList<Card> bankerHand;
    BaccaratDealer theDealer = new BaccaratDealer();
    BaccaratGameLogic gameLogic = new BaccaratGameLogic();
    double currentBet;
    double totalWinnings;
    String userChoseOdd;

    public double evaluateWinnings() {
        String whoWon = gameLogic.whoWon(playerHand, bankerHand);
        double winning = 0;
        if (whoWon.equals(userChoseOdd)) {
            if (userChoseOdd == "Player") {
                winning = currentBet;
                totalWinnings = totalWinnings + winning;
            } else if (userChoseOdd == "Banker") {
                winning = currentBet * 95 / 100;
                totalWinnings = totalWinnings + winning;
            } else {
                winning = currentBet * 8;
                totalWinnings = totalWinnings + winning;
            }
        } else { // user lost
            winning = currentBet * (-1);
            totalWinnings = totalWinnings + winning;
        }
        return winning;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    public MenuBar createOptionMenu(Stage primaryStage) {
        // Option menu
        Menu optionMenu = new Menu("Option");

        // Menu items
        MenuItem exit = new MenuItem("Exit");
        MenuItem restart = new MenuItem("Fresh Start");

        optionMenu.getItems().addAll(exit, restart); // add Exit and Fresh Start into the Option menu
        exit.setOnAction(e -> System.exit(0)); // exit the game

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(optionMenu);

        return menuBar;
    }

    //feel free to remove the starter code from this method
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("Let's Play Baccarat!!!");

        // creating border pane
        BorderPane layout = new BorderPane();
        BorderPane canvas = new BorderPane();

        VBox vBox1 = new VBox(10);
        VBox vBox2 = new VBox(10);
        VBox vBox3 = new VBox(10); // create vBox to contain hBox
        VBox vBox4 = new VBox(10); //
        VBox vBox5 = new VBox(10); //
        VBox vBox6 = new VBox(10);
        VBox forUsrIn = new VBox(10);

        HBox hBox1 = new HBox(); // create HBox for stack pane
        HBox hBox2 = new HBox(); //
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();

        StackPane sp1 = new StackPane(); // create 6 stack pane for 6 image views
        StackPane sp2 = new StackPane(); //
        StackPane sp3 = new StackPane(); //
        StackPane sp4 = new StackPane(); //
        StackPane sp5 = new StackPane(); //
        StackPane sp6 = new StackPane(); //

        FadeTransition fade1 = new FadeTransition();
        FadeTransition fade2 = new FadeTransition();
        FadeTransition fade3 = new FadeTransition();
        FadeTransition fade4 = new FadeTransition();
        FadeTransition fade5 = new FadeTransition();
        FadeTransition fade6 = new FadeTransition();
        FadeTransition fade7 = new FadeTransition();
        FadeTransition fade8 = new FadeTransition();
        FadeTransition fade9 = new FadeTransition();
        FadeTransition fade10 = new FadeTransition();
        FadeTransition fade11 = new FadeTransition();
        FadeTransition fade12 = new FadeTransition();
        FadeTransition fade13 = new FadeTransition();
        FadeTransition fade14 = new FadeTransition();
        FadeTransition fade15 = new FadeTransition();
        FadeTransition fade16 = new FadeTransition();
        FadeTransition fade17 = new FadeTransition();
        FadeTransition fade18 = new FadeTransition();
        FadeTransition fade19 = new FadeTransition();
        FadeTransition fade20 = new FadeTransition();
        FadeTransition fade21 = new FadeTransition();
        FadeTransition fade22 = new FadeTransition();
        FadeTransition fade23 = new FadeTransition();
        FadeTransition fade24 = new FadeTransition();

        SequentialTransition seq1 = new SequentialTransition(fade1, fade2);
        SequentialTransition seq2 = new SequentialTransition(fade6, fade4);

        ParallelTransition parTransCardBack = new ParallelTransition(fade3, fade5);
        ParallelTransition parTransCardFace = new ParallelTransition(fade9, fade11);
        ParallelTransition parTransPlayAgain = new ParallelTransition(fade13, fade18, fade19, fade20, fade22);
        ParallelTransition parTransShowWinner = new ParallelTransition(fade15, fade24);
        ParallelTransition parTransShowWinner2 = new ParallelTransition(fade16, fade24);
        ParallelTransition parTransHide3rdCard = new ParallelTransition(fade10, fade12);

        PauseTransition pauseCardFlip = new PauseTransition(new Duration(500));

        Label betAmount = new Label("Bet amount: $");
        Label oddSelection = new Label("Which odd: ");
        Label pHand = new Label("Player's Hand"); // labels for pointing out whose cards
        Label bHand = new Label("Banker's Hand"); //
        Label playerTotal = new Label();
        Label bankerTotal = new Label();
        Label winner = new Label();
        Label currWin = new Label();
        Label winOrLose = new Label();

        ImageView iv1 = new ImageView(); // create 6 image view for 6 cards
        ImageView iv2 = new ImageView(); //
        ImageView iv3 = new ImageView(); //
        ImageView iv4 = new ImageView(); //
        ImageView iv5 = new ImageView(); //
        ImageView iv6 = new ImageView(); //

        Button play = new Button("Play");
        Button playAgain = new Button("Play Again");
        Button ok = new Button("OK");

        TextField txt = new TextField();

        ChoiceBox<String> odds = new ChoiceBox<>();

        MenuBar option = createOptionMenu(primaryStage);

        Image imageBack = new Image("/cards/background.jpg", 1500, 1500, true, true);
        Image cardBack = new Image("/cards/AB.png", 100, 0, true, true);

        UIMisc.createFadeTrans(fade1, forUsrIn, new Duration(1000), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade2, canvas, new Duration(1000), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade3, hBox4, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade4, play, new Duration(1000), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade5, hBox5, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade6, canvas, new Duration(250), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade7, play, new Duration(1000), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade8, forUsrIn, new Duration(1000), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade9, hBox4, new Duration(500), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade10, sp3, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade11, hBox5, new Duration(500), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade12, sp6, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade13, canvas, new Duration(1000), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade14, play, new Duration(1000), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade15, sp3, new Duration(500), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade16, sp6, new Duration(500), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade17, playAgain, new Duration(500), 0.0, 1.0, 1, true);
        UIMisc.createFadeTrans(fade18, playAgain, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade19, sp3, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade20, sp6, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade21, vBox6, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade22, vBox6, new Duration(500), 1.0, 0.0, 1, true);
        UIMisc.createFadeTrans(fade24, vBox6, new Duration(500), 0.0, 1.0, 1, true);

        option.getMenus().get(0).getItems().get(1).setOnAction(event -> {
            layout.setCenter(vBox1);
            seq2.play();
            currentBet = 0.0;
            totalWinnings = 0.0;
            ArrayList<Card> playerHand = new ArrayList<>();
            ArrayList<Card> bankerHand = new ArrayList<>();
            BaccaratDealer theDealer = new BaccaratDealer();
            BaccaratGameLogic gameLogic = new BaccaratGameLogic();
            parTransHide3rdCard.play();
        });

        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox1.getChildren().add(play);
        vBox1.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(backgroundImage));
        layout.setTop(option);
        layout.setCenter(vBox1);

        Scene scene1 = new Scene(layout, 800, 800);

        txt.setMaxWidth(200);
        odds.setMaxWidth(300);

        odds.getItems().add("Player win - all player bets 1:1 evens");
        odds.getItems().add("Banker win - all banker bets 1:1 evens, bank stores 5% of players win");
        odds.getItems().add("Tie - all tie bets 8:1");
        odds.setValue("Player win - all player bets 1:1 evens");

        odds.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            int opt = newValue.intValue();
            if (opt == 0) {
                userChoseOdd = "Player";
            } else if (opt == 1) {
                userChoseOdd = "Banker";
            } else {
                userChoseOdd = "Draw";
            }
        });

        forUsrIn.getChildren().addAll(betAmount, txt, oddSelection, odds, ok);
        vBox2.getChildren().add(forUsrIn);
        forUsrIn.setAlignment(Pos.CENTER);

        pHand.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        pHand.setTextFill(Paint.valueOf("black"));
        bHand.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        bHand.setTextFill(Paint.valueOf("black"));
        currWin.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        currWin.setTextFill(Paint.valueOf("white"));
        playerTotal.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        playerTotal.setTextFill(Paint.valueOf("black"));
        bankerTotal.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        bankerTotal.setTextFill(Paint.valueOf("black"));
        winner.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        winner.setTextFill(Paint.valueOf("black"));
        winOrLose.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        winOrLose.setTextFill(Paint.valueOf("black"));
        betAmount.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        betAmount.setTextFill(Paint.valueOf("black"));
        oddSelection.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        oddSelection.setTextFill(Paint.valueOf("black"));

        UIMisc.setIV(iv1, cardBack); // set image views as cards showing their backs
        UIMisc.setIV(iv2, cardBack); //
        UIMisc.setIV(iv4, cardBack); //
        UIMisc.setIV(iv5, cardBack); //

        sp1.getChildren().add(iv1); // add each image view into each stack pane
        sp2.getChildren().add(iv2); //
        sp3.getChildren().add(iv3); //
        sp4.getChildren().add(iv4); //
        sp5.getChildren().add(iv5); //
        sp6.getChildren().add(iv6); //

        hBox4.getChildren().addAll(sp1, sp2);
        hBox5.getChildren().addAll(sp4, sp5);
        hBox1.getChildren().addAll(hBox4, sp3); // get stack panes into 2 different hBox
        hBox2.getChildren().addAll(hBox5, sp6); //

        vBox6.getChildren().addAll(winner, winOrLose);
        vBox3.getChildren().addAll(pHand, hBox1, playerTotal, vBox6);// add hBox and label into each vBox
        vBox4.getChildren().addAll(bHand, hBox2, bankerTotal);

        hBox3.getChildren().addAll(vBox3, vBox4);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setSpacing(32);
        vBox5.getChildren().add(currWin);
        vBox5.setAlignment(Pos.CENTER);

        canvas.setCenter(hBox3);
        canvas.setBottom(vBox5);

        // switch to prompt for user input
        play.setOnAction(e -> {
            fade7.play();
            layout.setCenter(forUsrIn);
            fade8.play();
        });

        ok.setOnMouseClicked(event -> {
            boolean isInteger = Pattern.matches("-?\\d+(\\.\\d+)?", txt.getCharacters().toString());
            if (!isInteger) {
                UIMisc.displayAlert("Error", "Invalid bet amount");
            } else {
                currentBet = Double.parseDouble(txt.getCharacters().toString());
                currWin.setText("Current Winnings: " + totalWinnings + "$");
                layout.setCenter(canvas);
                seq1.play();
                UIMisc.setIV(iv1, cardBack); // set image views as cards showing their backs
                UIMisc.setIV(iv2, cardBack); //
                UIMisc.setIV(iv4, cardBack); //
                UIMisc.setIV(iv5, cardBack);
            }
        });
        seq1.setOnFinished(event -> {
            playerTotal.setText("Player Total: " + 0);
            bankerTotal.setText("Banker Total: " + 0);
            pauseCardFlip.play();
            parTransCardBack.play();

        });
        parTransCardBack.setOnFinished(event -> {
            playerHand = theDealer.dealHand();
            bankerHand = theDealer.dealHand();
            Image img1 = new Image(playerHand.get(0).getName(), 100, 0, true, true);
            Image img2 = new Image(playerHand.get(1).getName(), 100, 0, true, true);
            Image img3 = new Image(bankerHand.get(0).getName(), 100, 0, true, true);
            Image img4 = new Image(bankerHand.get(1).getName(), 100, 0, true, true);
            UIMisc.setIV(iv1, img1);
            UIMisc.setIV(iv2, img2);
            UIMisc.setIV(iv4, img3);
            UIMisc.setIV(iv5, img4);
            parTransCardFace.play();
        });

        parTransCardFace.setOnFinished(event -> {
            if (gameLogic.evaluatePlayerDraw(playerHand)) {
                playerHand.add(2, theDealer.drawOne());
                Image img5 = new Image(playerHand.get(2).getName(), 100, 0, true, true);
                UIMisc.setIV(iv3, img5);
                parTransShowWinner.play();
            } else {
                if (gameLogic.evaluateBankerDraw(bankerHand, null)) {
                    bankerHand.add(2, theDealer.drawOne());
                    Image img6 = new Image(bankerHand.get(2).getName(), 100, 0, true, true);
                    UIMisc.setIV(iv6, img6);
                    playerTotal.setText("Player Total: " + gameLogic.handTotal(playerHand));
                    bankerTotal.setText("Banker Total: " + gameLogic.handTotal(bankerHand));
                    parTransShowWinner2.play();
                }
            }
        });

        // putting play again button in hBox to show later
        hBox3.getChildren().add(playAgain);
        playAgain.setOpacity(0);
        playAgain.setStyle("-fx-alignment: CENTER");

        fade24.setOnFinished(event -> {
            if (gameLogic.whoWon(playerHand, bankerHand).equals("Player")) {
                winner.setText("Player won!!!");
                if (odds.getSelectionModel().getSelectedIndex() == 0) {
                    winOrLose.setText("Congrats, you bet Player! You win");
                    totalWinnings = totalWinnings + currentBet;
                    currWin.setText("Current Winnings: " + totalWinnings + "$");
                } else {
                    winOrLose.setText("Sorry, you lost your bet!");
                    totalWinnings = totalWinnings - currentBet;
                    currWin.setText("Current Winnings: " + totalWinnings + "$");
                }
            } else if (gameLogic.whoWon(playerHand, bankerHand).equals("Banker")) {
                winner.setText("Banker won!!!");
                if (odds.getSelectionModel().getSelectedIndex() == 1) {
                    winOrLose.setText("Congrats, you bet Banker! You win");
                    totalWinnings = totalWinnings + (currentBet * 95 / 100);
                    currWin.setText("Current Winnings: " + totalWinnings + "$");
                } else {
                    winOrLose.setText("Sorry, you lost your bet!");
                    totalWinnings = totalWinnings - currentBet;
                    currWin.setText("Current Winnings: " + totalWinnings + "$");
                }
            } else {
                winner.setText("It is a Draw!!!");
                if (odds.getSelectionModel().getSelectedIndex() == 2) {
                    winOrLose.setText("Congrats, you bet Draw! You win");
                    totalWinnings = totalWinnings + (8 * currentBet);
                    currWin.setText("Current Winnings: " + totalWinnings + "$");
                } else {
                    winOrLose.setText("Sorry, you lost your bet!");
                    totalWinnings = totalWinnings - currentBet;
                    currWin.setText("Current Winnings: " + totalWinnings + "$");
                }
            }
            fade17.play();
        });

        playAgain.setOnMouseClicked(event -> {
            parTransPlayAgain.play();
            UIMisc.setIV(iv1, cardBack); // set image views as cards showing their backs
            UIMisc.setIV(iv2, cardBack); //
            UIMisc.setIV(iv4, cardBack); //
            UIMisc.setIV(iv5, cardBack);
            layout.setCenter(forUsrIn);
            fade8.play();
        });

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
