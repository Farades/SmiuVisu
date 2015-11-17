package ru.entel.smiu.visu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private AnchorPane rootContainer;

    @FXML
    private VBox mainContainer;

    public AnchorPane getRootContainer() {
        return rootContainer;
    }

    public VBox getMainContainer() {
        return mainContainer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}