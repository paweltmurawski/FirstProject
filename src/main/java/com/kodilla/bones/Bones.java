package com.kodilla.bones;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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

import java.util.Random;

public class Bones extends Application {

    //private Image background = new Image("file:resources/file/tlo.png");
    private Image one = new Image("/file/1.png");

    private Image two = new Image("file:resources/2.png");
    private Image three = new Image("file:resources/3.png");
    private Image four = new Image("file:resources/4.png");
    private Image five = new Image("file:resources/5.png");
    private Image six = new Image("file:resources/6.png");

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
        }  catch(Exception e) {
            e.printStackTrace();
        }

        Image setBackground = new Image("/file/tlo.png");
        BackgroundSize backgroundSize = new BackgroundSize(150, 150, false, false, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(setBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        ImageView numberOneBoneView = new ImageView();
        Image numberOneBone = new Image("/file/1.png");
        numberOneBoneView.setImage(numberOneBone);
        numberOneBoneView.setFitHeight(50);
        numberOneBoneView.setFitWidth(50);

        gridPane.add(numberOneBoneView, 3, 3, 1, 1);

/*
        ImageView numberTwoBoneView = new ImageView();
        Image numberTwoBone = new Image("/file/2.png");
        numberTwoBoneView.setImage(numberTwoBone);
        numberTwoBoneView.setFitHeight(50);
        numberTwoBoneView.setFitWidth(50);
        gridPane.getChildren().add(numberTwoBoneView);

        ImageView numberThreeBoneView = new ImageView();
        Image numberThreeBone = new Image("/file/3.png");
        numberThreeBoneView.setImage(numberThreeBone);
        numberThreeBoneView.setFitHeight(50);
        numberThreeBoneView.setFitWidth(50);
        gridPane.getChildren().add(numberThreeBoneView);

        ImageView numberFourBoneView = new ImageView();
        Image numberFourBone = new Image("/file/4.png");
        numberFourBoneView.setImage(numberFourBone);
        numberFourBoneView.setFitHeight(50);
        numberFourBoneView.setFitWidth(50);
        gridPane.getChildren().add(numberFourBoneView);

        ImageView numberFiveBoneView = new ImageView();
        Image numberFiveBone = new Image("/file/5.png");
        numberFiveBoneView.setImage(numberFiveBone);
        numberFiveBoneView.setFitHeight(50);
        numberFiveBoneView.setFitWidth(50);
        gridPane.getChildren().add(numberFiveBoneView);

        ImageView numberSixBoneView = new ImageView();
        Image numberSixBone = new Image("/file/6.png");
        numberSixBoneView.setImage(numberSixBone);
        numberSixBoneView.setFitHeight(50);
        numberSixBoneView.setFitWidth(50);
        gridPane.getChildren().add(numberSixBoneView);
*/
        // button's in game

        Button startGame = new Button();
        startGame.setText("Start Game");
        startGame.setTextFill(Color.BLUE);
        startGame.setFont(new Font("Verdana", 25));
        startGame.setOnAction(event -> System.out.println("I clicked start button"));
        gridPane.add(startGame, 1, 0, 1, 1);

        Button quitButton = new Button();
        quitButton.setText("Quit");
        quitButton.setTextFill(Color.RED);
        quitButton.setFont(new Font("Verdana", 25));
        quitButton.setOnAction(e -> {
            System.out.println("Exit");
            Platform.exit();
        });
        gridPane.add(quitButton, 2, 0, 1, 1);

        Label nameLabel = new Label("Player name:");
        nameLabel.setFont(new Font("Verdana", 25));
        nameLabel.setTextFill(Color.BLACK);
        gridPane.add(nameLabel, 1, 1, 1, 1);

        Label playerScoreLabel = new Label("Player score:");
        nameLabel.setFont(new Font("Verdana", 25));
        nameLabel.setTextFill(Color.BLACK);
        gridPane.add(playerScoreLabel, 1, 2, 1, 1);

        Label computerScoreLabel = new Label("Computer score:");
        nameLabel.setFont(new Font("Verdana", 25));
        nameLabel.setTextFill(Color.BLACK);
        gridPane.add(computerScoreLabel, 1, 3, 1, 1);

        TextField playerNameField = new TextField();
        playerNameField.setPromptText("player name");
        gridPane.add(playerNameField, 2, 1, 1, 1);

        ColumnConstraints column1 = new ColumnConstraints(200);
        gridPane.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints(200);
        gridPane.getColumnConstraints().add(column2);

        ColumnConstraints column3 = new ColumnConstraints(200);
        gridPane.getColumnConstraints().add(column3);

        RowConstraints row1 = new RowConstraints(80);
        row1.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(80);
        row2.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(row2);

        RowConstraints row3 = new RowConstraints(170);
        row3.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(row3);
    }

    public void generateRandomNumber(ActionEvent event) {
        Random randomNumber = new Random();
        int rolledNumber = randomNumber.nextInt(6) + 1;
        playerScoreLabel.setText(Integer.toString(rolledNumber));
        //System.out.println(Integer.toString(rolledNumber));
    }
/*
    public int countingNumberOfMoves() {
        int numberOfMoves;
        int sum = 0;
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        int five = 5;
        int six = 6;
        if (numberOfMoves < 10) {
            sum += sum;
       else{

            }
        }
    }

    public void scoreTotal(int drawnNumber) {
        if (!drawnNumber = 1) {
            pointsSum += pointsSum;
        }
    }

    int playerScore = player.scoreTotal();
    int computerScore = computer.scoreTotal();

    public void results() {
        System.out.println("Player score: " + playerScore);
        System.out.println("Computer score: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Player wins");
            status.setText("You won");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins");
            status.setText("You lose");
        } else (playerScore == computerScore) {
            System.out.println("Draw");
            status.setText("Draw");
        }

    }


        public void counting( int countPoints){

    }

        public void () {
        }
*/

//        Label label = new Label("Result table");
//      label.setFont(new Font("Times New Roman" , 20));
/*
        TableView resultsTable = new TableView();
        resultsTable.setEditable(true);
        TableColumn categoriesColumn = new TableColumn("");
        categoriesColumn.setMinWidth(250);
        categoriesColumn.setMaxWidth(250);
        TableColumn playerOneColumn = new TableColumn("Player 1");
        playerOneColumn.setMinWidth(150);
        playerOneColumn.setMaxWidth(150);
        TableColumn playerTwoColumn = new TableColumn("Player 2");
        playerTwoColumn.setMinWidth(150);
        playerTwoColumn.setMaxWidth(150);
        resultsTable.getColumns().addAll(categoriesColumn, playerOneColumn, playerTwoColumn);

        gridPane.getChildren().add(resultsTable);
        */

/*
        //example of File Input Stream from internet
        //Creating an image
        Image one = new Image(new FileInputStream("/file/1.png"));

        //Setting the image view
        ImageView imageView = new ImageView(one);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
*/

}