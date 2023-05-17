package com.example.javacoursework.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Контроллер для окна "О проекте".
 *
 * @author Egor
 * @version 1.0
 */
public class AboutProjectController {

    /**
     * Кнопка "Close", закрывающая текущее окно.
     */
    @FXML
    private javafx.scene.control.Button closeButton;

    /**
     * Обработчик события нажатия кнопки "Close". Закрывает текущее окно.
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
