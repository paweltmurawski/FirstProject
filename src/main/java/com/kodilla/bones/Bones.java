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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import javax.swing.*;


public class Bones extends Application {

    private Image background = new Image("file:resources/lake-2063957_340.png");
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
        BackgroundSize backgroundSize = new BackgroundSize(150, 150, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Group root = new Group();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(6, 15.5, 16.5, 12.5));
        grid.setHgap(8.5);
        grid.setVgap(8.5);
        grid.setBackground(background);

        ImageView image = new ImageView();
        image.getImage();

        grid.add(grid, 0, 0, 3, 1);

        Scene scene = new Scene(root, 1300, 700, Color.WHITE);


        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Bones");
        primaryStage.setScene(scene);
        primaryStage.show();


        Label label = new Label("Result table");
        label.setFont(new Font("Times New Roman" , 20));

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



        root.getChildren().add(resultsTable);

    }
}