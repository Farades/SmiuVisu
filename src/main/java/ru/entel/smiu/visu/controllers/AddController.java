package ru.entel.smiu.visu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController extends MainController{
    @FXML
    private AnchorPane addContainer;

    @FXML
    private TextArea txtDebug;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getAddContainer() {
        return addContainer;
    }

    public void buttonHandler(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source instanceof Button) {
            Button clickedButton = (Button) source;

            switch (clickedButton.getId()) {
                case "btnDebug" :
                    VisuManager.getInstance().changeScene("debug");
                    break;
            }
        }
    }
}
