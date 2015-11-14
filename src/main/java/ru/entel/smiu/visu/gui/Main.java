package ru.entel.smiu.visu.gui;/**
 * Created by farades on 14.11.15.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
        primaryStage.setTitle("ENTEL СМИУ");
        primaryStage.setScene(new Scene(root, 800, 480));
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }
}
