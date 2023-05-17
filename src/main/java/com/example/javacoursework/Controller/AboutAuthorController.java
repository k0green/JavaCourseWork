package com.example.javacoursework.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Контроллер для окна "О авторе"
 *
 * @author Egor
 * @version 1.0
 */
public class AboutAuthorController {

    /**
     * Кнопка закрытия окна
     */
    @FXML
    private javafx.scene.control.Button closeButton;

    /**
     * Обработчик нажатия на кнопку закрытия окна
     * @param event Событие нажатия на кнопку
     * @throws IOException Если возникла ошибка при закрытии окна
     */
    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

