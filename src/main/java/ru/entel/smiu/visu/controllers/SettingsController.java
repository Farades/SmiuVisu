package ru.entel.smiu.visu.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by farades on 15.11.15.
 */
public class SettingsController implements Initializable {
    @FXML
    private AnchorPane mainSettingsContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getMainSettingsContainer() {
        return mainSettingsContainer;
    }
}