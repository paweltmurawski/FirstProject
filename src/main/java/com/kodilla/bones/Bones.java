package com.kodilla.bones;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import javax.swing.*;


public class Bones extends Application {

    private Image background = new Image("file:resources/file/tlo.png");
    private Image one = new Image("file:resources/1.png");
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

        Group root = new Group();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_RIGHT);
        gridPane.setPadding(new Insets(6, 15.5, 16.5, 12.5));
        gridPane.setHgap(8.5);

        Image setBackground = new Image("file:resources/file/tlo.png");
        BackgroundSize backgroundSize = new BackgroundSize(150, 150, false, false, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(setBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);


       // root.getChildren().add(gridPane);


        ImageView myBackgroundImage = new ImageView(setBackground);
        root.getChildren().addAll(myBackgroundImage);


        Scene scene = new Scene(gridPane, 1300, 700);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setTitle("Bones");
        primaryStage.setScene(scene);
        primaryStage.show();

//        Label label = new Label("Result table");
        //      label.setFont(new Font("Times New Roman" , 20));

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

        Button click = new Button("click");
        click.setText("Start");

        gridPane.getChildren().add(resultsTable);

        // example from documentation Pane class

        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: black;");
        canvas.setPrefSize(200,200);
        Circle circle = new Circle(50,Color.BLUE);
        circle.relocate(20, 20);
        Rectangle rectangle = new Rectangle(100,100,Color.RED);
        rectangle.relocate(70,70);
        canvas.getChildren().addAll(circle,rectangle);
        gridPane.getChildren().addAll(canvas);


        Button newbtn = new Button();
        newbtn.setText("Start");
        gridPane.getChildren().addAll(newbtn);

    }
}






/*
        Button drawbtn = new Button();
        drawbtn.setText("Start");
        drawbtn.setOnAction((e) -> {

        }

         Button drawbtn = new Button();
        drawbtn.setText("Next move");
        drawbtn.setOnAction((e) -> {
            if (playerMove) {
                drawBones(//elements);

                if (numberOfMoves.movesQuantity > 13) {
                    System.out.println("End of game");
                }
            }
        });


        int playerScore = player.scoreTotal();
        int computerScore = computer.scoreTotal();

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
        });


        Button newbtn = new Button();
        newbtn.setText("New game");
        newbtn.setOnAction((e) -> {
            newGame();
        });

        Button newbtn = new Button();
        newbtn.setText("New game");
        newbtn.setOnAction((e) -> {
            newGame();
        });


        public void counting( int countPoints){

    }

        public void () {
        }
*/


