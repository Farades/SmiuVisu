package ru.entel.smiu.visu.gui;/**
 * Created by farades on 14.11.15.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import ru.entel.smiu.visu.controllers.VisuManager;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        VisuManager.getInstance().setPrimaryStage(primaryStage);
        VisuManager.getInstance().startApp();
//        primaryStage.setFullScreen(true);

    }
}
