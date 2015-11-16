package ru.entel.smiu.visu.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class VisuManager {
    private static VisuManager instance;

    private Stage primaryStage;
    private AnchorPane rootContainer;
    private VBox mainContainer;

    private MainController mainController;
    private MainPageController mainPageController;

    private Parent header;

    public static synchronized VisuManager getInstance() {
        if (instance == null) {
            instance = new VisuManager();
        }
        return instance;
    }

    private VisuManager() {
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startApp() {

        initMainContainer();
        initHeader();
        initMainPage();

        mainContainer.getChildren().add(header);
        mainContainer.getChildren().add(mainPageController.getMainPageContainer());

        primaryStage.setTitle("ENTEL СМИУ");
        primaryStage.setScene(new Scene(rootContainer, 800, 480));
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(800);
        primaryStage.show();
    }

    private void initMainContainer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/main.fxml"));
            loader.load();
            mainController = loader.getController();

            rootContainer = mainController.getRootContainer();
            mainContainer = mainController.getMainContainer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initMainPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/main_page.fxml"));
            loader.load();
            mainPageController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initHeader() {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/header.fxml"));
        try {
            header = (Parent) loader.load();
            AnchorPane anchorPane = (AnchorPane) ((AnchorPane)loader.getRoot());
//            Button btn = (Button)anchorPane.getChildren().get(2);
//            btn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
////                    mainContainer.getChildren().clear();
////                    mainContainer.getChildren().add(mainMenu);
//                }
//            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScene() {
        
    }

//    public void createWindow(String fxml) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/" + fxml + ".fxml"));
//            Parent child = loader.load();
//
//            mainContainer.getChildren().clear();
//            mainContainer.getChildren().add(0, header);
//            mainContainer.getChildren().add(1, child);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


}
