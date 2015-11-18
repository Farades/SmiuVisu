package ru.entel.smiu.visu.controllers;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {
    @FXML
    public Label lblClock;

    @FXML
    private Label lblState;

    @FXML
    private Button btnHome;

    public void returnHome(ActionEvent actionEvent) {
        VisuManager.getInstance().changeScene("mainPage");
    }

    public void setState(String state) {
        lblState.setText("Статус: " + state);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initClock();
    }

    private void initClock() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            Date date = new Date();
            String dateStr = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
            HeaderController.this.lblClock.setText(dateStr);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}