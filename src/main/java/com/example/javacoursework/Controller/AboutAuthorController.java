package com.example.javacoursework.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutAuthorController {
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
