package ru.entel.smiu.visu.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AlarmsController implements Initializable {
    @FXML
    private AnchorPane alarmsContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getRootContainer() {
        return alarmsContainer;
    }
}
