package ru.entel.smiu.visu.controllers.additionally;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DebugController implements Initializable {
    @FXML
    private AnchorPane debugContainer;

    @FXML
    private TextArea txtDebug;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void debug(String msg) {
        txtDebug.appendText(msg + "\n");
    }

    public AnchorPane getDebugContainer() {
        return debugContainer;
    }

    public TextArea getTxtDebug() {
        return txtDebug;
    }
}
