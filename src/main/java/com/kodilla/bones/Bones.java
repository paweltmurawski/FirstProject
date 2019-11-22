package com.kodilla.bones;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Bones extends Application {

    private Player computer = new Player();
    private Player player = new Player();
    boolean playerThrow;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);

        try {
            Scene scene = new Scene(gridPane, 1300, 700);
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
            primaryStage.setTitle("Bones");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image setBackground = new Image("/file/tlo.png");
        BackgroundSize backgroundSize = new BackgroundSize(150, 150, false, false, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(setBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        Button startGame = new Button();
        startGame.setText("Start");
        startGame.setTextFill(Color.BLUE);
        startGame.setFont(new Font("Verdana", 25));
        startGame.setOnAction(event -> System.out.println("I clicked start button"));
        gridPane.add(startGame, 1, 1, 1, 1);

        Button quitButton = new Button();
        quitButton.setText("Quit");
        quitButton.setTextFill(Color.RED);
        quitButton.setFont(new Font("Verdana", 25));
        quitButton.setOnAction(e -> {
            System.out.println("Exit");
            Platform.exit();
        });
        gridPane.add(quitButton, 2, 1, 1, 1);

        Label nameLabel = new Label("Player name:");
        nameLabel.setFont(new Font("Verdana", 15));
        nameLabel.setTextFill(Color.BLACK);
        gridPane.add(nameLabel, 1, 2, 1, 1);

        TextField playerNameField = new TextField();
        playerNameField.setPromptText("player name");
        gridPane.add(playerNameField, 2, 2, 1, 1);

        Label playerScoreText = new Label("Player score:");
        playerScoreText.setFont(new Font("Verdana", 15));
        playerScoreText.setTextFill(Color.BLACK);
        gridPane.add(playerScoreText, 1, 3, 1, 1);

        Label playerScore = new Label("");
        playerScore.setFont(new Font("Verdana", 15));
        playerScore.setTextFill(Color.BLACK);
        gridPane.add(playerScore, 2, 3, 1, 1);
        playerScore.setOnMouseClicked(e -> {
            int totalScoreResult = player.scorePoints();
            String total = Integer.toString(totalScoreResult);
            playerScore.setText(total);
        });

        Label computerScoreText = new Label("Computer score:");
        computerScoreText.setFont(new Font("Verdana", 15));
        computerScoreText.setTextFill(Color.BLACK);
        gridPane.add(computerScoreText, 1, 4, 1, 1);

        Label computerScore = new Label();
        computerScore.setFont(new Font("Verdana", 15));
        computerScore.setTextFill(Color.BLACK);
        gridPane.add(computerScore, 2, 4, 1, 1);
        computerScore.setOnMouseClicked(e -> {
            int totalComputerScoreResult = computer.scorePoints();
            String totalComputer = Integer.toString(totalComputerScoreResult);
            computerScore.setText(totalComputer);
        });

        Label status = new Label();
        status.setFont(new Font("Verdana", 15));
        status.setTextFill(Color.BLACK);
        gridPane.add(status, 1, 6, 1, 1);

        Button playerTurn = new Button();
        playerTurn.setText("Random number");
        playerTurn.setTextFill(Color.BLUE);
        playerTurn.setFont(new Font("Verdana", 15));
        playerTurn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (playerThrow = true) {
                        int randomNumberResult = player.generateMove(10 - player.countingNumberOfMoves());
                        playerScore.setText(player.scorePoints() + "");
                        System.out.println("Player random Number: " + randomNumberResult);
                        playerImageChooser(randomNumberResult,gridPane);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You have reached maximum number of moves");
                }
                try {
                    int randomNumberComputerResult = computer.generateMove(10 - computer.countingNumberOfMoves());
                    computerScore.setText(computer.scorePoints() + "");
                    System.out.println("Computer random number: " + randomNumberComputerResult);
                    computerImageChooser(randomNumberComputerResult, gridPane);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("End of computer turns");
                }

                int numberOfMovesLeft = player.countingNumberOfMoves();
                int playerScoreTotal = player.scorePoints();
                int computerScoreTotal = computer.scorePoints();

                System.out.println("Number of moves left: " + numberOfMovesLeft);
                System.out.println("Player score: " + playerScoreTotal);
                System.out.println("Computer score: " + computerScoreTotal);

                if (numberOfMovesLeft == 0 && playerScoreTotal > computerScoreTotal) {
                    System.out.println("Player wins");
                    status.setText("You won");
                } else if (numberOfMovesLeft == 0 && playerScoreTotal < computerScoreTotal) {
                    System.out.println("Computer wins");
                    status.setText("You lose");
                } else if (numberOfMovesLeft > 0) {
                    System.out.println("Next move");
                    status.setText("Next move");
                } else {
                    System.out.println("Draw");
                    status.setText("Draw");
                }
            }
        });

        gridPane.add(playerTurn, 1, 5, 1, 1);

        ColumnConstraints column1 = new ColumnConstraints(150);
        ColumnConstraints column2 = new ColumnConstraints(150);
        ColumnConstraints column3 = new ColumnConstraints(150);

        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        RowConstraints row1 = new RowConstraints(50);
        row1.setValignment(VPos.TOP);

        RowConstraints row2 = new RowConstraints(50);
        row2.setValignment(VPos.TOP);

        RowConstraints row3 = new RowConstraints(50);
        row3.setValignment(VPos.TOP);

        RowConstraints row4 = new RowConstraints(50);
        row4.setValignment(VPos.CENTER);

        RowConstraints row5 = new RowConstraints(50);
        row5.setValignment(VPos.BOTTOM);

        RowConstraints row6 = new  RowConstraints(50);

        gridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);
    }

        public void playerImageChooser(int number, GridPane gridPane) {

            ImageView numberOneBoneView = new ImageView();
            Image numberOneBone = new Image("/file/1.png");
            gridPane.add(numberOneBoneView, 3, 3, 1, 1);

            ImageView numberTwoBoneView = new ImageView();
            Image numberTwoBone = new Image("/file/2.png");
            gridPane.add(numberTwoBoneView, 3, 3, 1, 1);

            ImageView numberThreeBoneView = new ImageView();
            Image numberThreeBone = new Image("/file/3.png");
            gridPane.add(numberThreeBoneView, 3, 3, 1, 1);

            ImageView numberFourBoneView = new ImageView();
            Image numberFourBone = new Image("/file/4.png");
            gridPane.add(numberFourBoneView, 3, 3, 1, 1);

            ImageView numberFiveBoneView = new ImageView();
            Image numberFiveBone = new Image("/file/5.png");
            gridPane.add(numberFiveBoneView, 3, 3, 1, 1);

            ImageView numberSixBoneView = new ImageView();
            Image numberSixBone = new Image("/file/6.png");
            gridPane.add(numberSixBoneView, 3, 3, 1, 1);

            switch (number) {
                case 1:
                    numberOneBoneView.setImage(numberOneBone);
                    numberOneBoneView.setFitHeight(50);
                    numberOneBoneView.setFitWidth(50);
                    break;
                case 2:
                    numberTwoBoneView.setImage(numberTwoBone);
                    numberTwoBoneView.setFitHeight(50);
                    numberTwoBoneView.setFitWidth(50);
                    break;
                case 3:
                    numberThreeBoneView.setImage(numberThreeBone);
                    numberThreeBoneView.setFitHeight(50);
                    numberThreeBoneView.setFitWidth(50);
                    break;
                case 4:
                    numberFourBoneView.setImage(numberFourBone);
                    numberFourBoneView.setFitHeight(50);
                    numberFourBoneView.setFitWidth(50);
                    break;
                case 5:
                    numberFiveBoneView.setImage(numberFiveBone);
                    numberFiveBoneView.setFitHeight(50);
                    numberFiveBoneView.setFitWidth(50);
                    break;
                case 6:
                    numberSixBoneView.setImage(numberSixBone);
                    numberSixBoneView.setFitHeight(50);
                    numberSixBoneView.setFitWidth(50);
                    break;
                default:
                    System.out.println("No move made");
            }
        }

    public void computerImageChooser(int number, GridPane gridPane) {

        ImageView numberOneBoneView = new ImageView();
        Image numberOneBone = new Image("/file/1.png");
        gridPane.add(numberOneBoneView, 3, 4, 1, 1);

        ImageView numberTwoBoneView = new ImageView();
        Image numberTwoBone = new Image("/file/2.png");
        gridPane.add(numberTwoBoneView, 3, 4, 1, 1);

        ImageView numberThreeBoneView = new ImageView();
        Image numberThreeBone = new Image("/file/3.png");
        gridPane.add(numberThreeBoneView, 3, 4, 1, 1);

        ImageView numberFourBoneView = new ImageView();
        Image numberFourBone = new Image("/file/4.png");
        gridPane.add(numberFourBoneView, 3, 4, 1, 1);

        ImageView numberFiveBoneView = new ImageView();
        Image numberFiveBone = new Image("/file/5.png");
        gridPane.add(numberFiveBoneView, 3, 4, 1, 1);

        ImageView numberSixBoneView = new ImageView();
        Image numberSixBone = new Image("/file/6.png");
        gridPane.add(numberSixBoneView, 3, 4, 1, 1);

        switch (number) {
            case 1:
                numberOneBoneView.setImage(numberOneBone);
                numberOneBoneView.setFitHeight(50);
                numberOneBoneView.setFitWidth(50);
                break;
            case 2:
                numberTwoBoneView.setImage(numberTwoBone);
                numberTwoBoneView.setFitHeight(50);
                numberTwoBoneView.setFitWidth(50);
                break;
            case 3:
                numberThreeBoneView.setImage(numberThreeBone);
                numberThreeBoneView.setFitHeight(50);
                numberThreeBoneView.setFitWidth(50);
                break;
            case 4:
                numberFourBoneView.setImage(numberFourBone);
                numberFourBoneView.setFitHeight(50);
                numberFourBoneView.setFitWidth(50);
                break;
            case 5:
                numberFiveBoneView.setImage(numberFiveBone);
                numberFiveBoneView.setFitHeight(50);
                numberFiveBoneView.setFitWidth(50);
                break;
            case 6:
                numberSixBoneView.setImage(numberSixBone);
                numberSixBoneView.setFitHeight(50);
                numberSixBoneView.setFitWidth(50);
                break;
            default:
                System.out.println("No move made");
        }
    }
}


