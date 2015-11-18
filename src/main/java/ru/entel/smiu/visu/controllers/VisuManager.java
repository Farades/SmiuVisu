package ru.entel.smiu.visu.controllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.entel.smiu.visu.controllers.additionally.DebugController;
import ru.entel.smiu.visu.model.ModelEngine;

import java.io.IOException;

public class VisuManager {
    private static VisuManager instance;
    private ModelEngine engine;

    private Stage primaryStage;
    private AnchorPane rootContainer;
    private VBox mainContainer;

    private MainController mainController;
    private HeaderController headerController;
    private MainPageController mainPageController;
    private SettingsController settingsController;
    private MonitoringController monitoringController;
    private GpioController gpioController;
    private AddController addController;
    private DebugController debugController;
    private AlarmsController alarmsController;

    private Parent header;

    public static synchronized VisuManager getInstance() {
        if (instance == null) {
            instance = new VisuManager();
        }
        return instance;
    }

    private VisuManager() {
        engine = new ModelEngine();
    }



    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startApp() {
        initMainContainer();
        initHeader();
        initMainPage();
        initSettingsController();
        initMonitoringController();
        initGpioController();
        initAddController();
        initDebugController();
        initAlarmsController();

        mainContainer.getChildren().add(header);
        mainContainer.getChildren().add(mainPageController.getMainPageContainer());

        primaryStage.setTitle("ENTEL СМИУ");
        primaryStage.setScene(new Scene(rootContainer, 800, 480));
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(800);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public void addDebugMsg(String msg) {
        debugController.debug(msg);
    }

    private void initAlarmsController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/alarms.fxml"));
            loader.load();
            alarmsController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDebugController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/additionally/debug.fxml"));
            loader.load();
            debugController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initAddController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/additionally.fxml"));
            loader.load();
            addController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initGpioController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/gpio.fxml"));
            loader.load();
            gpioController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initMonitoringController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/monitoring.fxml"));
            loader.load();
            monitoringController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSettingsController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/settings.fxml"));
            loader.load();
            settingsController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/header.fxml"));
            header = (Parent) loader.load();
            headerController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HeaderController getHeaderController() {
        return headerController;
    }

    public void changeScene(String sceneName) {
        switch (sceneName) {
            case "settings" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(settingsController.getMainSettingsContainer());
                break;
            case "mainPage" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(mainPageController.getMainPageContainer());
                break;
            case "monitoring" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(monitoringController.getMonitoringContainer());
                break;
            case "GPIO" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(gpioController.getGpioContainer());
                break;
            case "additionally" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(addController.getAddContainer());
                break;
            case "debug" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(debugController.getDebugContainer());
                break;
            case "alarms" :
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(header);
                mainContainer.getChildren().add(alarmsController.getRootContainer());
                break;
            default:
                break;
        }
        
    }
}
