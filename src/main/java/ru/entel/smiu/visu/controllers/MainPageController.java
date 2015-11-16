package ru.entel.smiu.visu.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by farades on 16.11.15.
 */
public class MainPageController implements Initializable {
    @FXML
    AnchorPane mainPageContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getMainPageContainer() {
        return mainPageContainer;
    }
}
