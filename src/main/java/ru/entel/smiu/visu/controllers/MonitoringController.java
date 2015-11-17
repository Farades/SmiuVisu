package ru.entel.smiu.visu.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MonitoringController implements Initializable {
    @FXML
    private AnchorPane monitoringContainer;

    public AnchorPane getMonitoringContainer() {
        return monitoringContainer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
