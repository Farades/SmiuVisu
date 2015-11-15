package ru.entel.smiu.visu.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.entel.smiu.msg.StatePackage;
import ru.entel.smiu.visu.engine.DeviceListener;
import ru.entel.smiu.visu.engine.MqttEngine;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, DeviceListener {
    private ResourceBundle resourceBundle;

    private Gson gson;

    public void changeScene(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (source instanceof Button) {
            Button clickedButton = (Button) source;

            switch (clickedButton.getId()) {
                case "btnAdditionally" :
                    stage.setScene(createScene("additionally"));
                    break;
                case "btnSettings" :
                    System.out.println("test");
                    stage.setScene(createScene("settings"));

                    break;
            }
        }
    }

    private Scene createScene(String fxml) {
        Scene res = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/" + fxml + ".fxml"));
            Parent root = (Parent) loader.load();
            res = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gson = new GsonBuilder().create();
        this.resourceBundle = resources;
        MqttEngine.getInstance().addDeviceListener(this);
    }

    @Override
    public void deviceUpdate(String devicesJson) {
        StatePackage statePackage = gson.fromJson(devicesJson, StatePackage.class);
        System.out.println();
    }
}
