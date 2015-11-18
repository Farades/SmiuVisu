package ru.entel.smiu.visu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    AnchorPane mainPageContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getMainPageContainer() {
        return mainPageContainer;
    }

    public void buttonHandler(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (source instanceof Button) {
            Button clickedButton = (Button) source;

            switch (clickedButton.getId()) {
                case "btnSettings" :
                    VisuManager.getInstance().changeScene("settings");
                    break;
                case "btnGPIO" :
                    VisuManager.getInstance().changeScene("GPIO");
                    break;
                case "btnMonitoring" :
                    VisuManager.getInstance().changeScene("monitoring");
                    break;
                case "btnAdditionally" :
                    VisuManager.getInstance().changeScene("additionally");
                    break;
                case "btnAlarms" :
                    VisuManager.getInstance().changeScene("alarms");
                    break;
            }
        }
    }
}
