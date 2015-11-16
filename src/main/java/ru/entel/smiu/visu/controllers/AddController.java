package ru.entel.smiu.visu.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController extends MainController{

    @FXML
    private TextArea txtDebug;

    @FXML
    private Button btnLevel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        super.initialize(location, resources);


    }

    public void openSub(ActionEvent actionEvent) {
//        createWindow("settings");
    }
}
