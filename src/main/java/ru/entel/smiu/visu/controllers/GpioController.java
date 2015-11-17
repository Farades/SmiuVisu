package ru.entel.smiu.visu.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GpioController implements Initializable {
    @FXML
    private AnchorPane gpioContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getGpioContainer() {
        return gpioContainer;
    }
}
