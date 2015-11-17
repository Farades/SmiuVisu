package ru.entel.smiu.visu.controllers.additionally;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class DebugController implements Initializable {
    @FXML
    private AnchorPane debugContainer;

    @FXML
    private TextArea txtDebug;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        txtDebug.appendText(new Date().toString() + "\n");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public AnchorPane getDebugContainer() {
        return debugContainer;
    }

    public TextArea getTxtDebug() {
        return txtDebug;
    }
}
