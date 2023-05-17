package com.example.javacoursework.Controller;

import com.example.javacoursework.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Контроллер для окна приветствия
 * @author Egor
 * @version 1.0
 */
public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private javafx.scene.control.Button regButtonClick;

    @FXML
    private javafx.scene.control.Button exitButton;

    @FXML
    private javafx.scene.control.Button nextButton;

    /**
     * Обработчик нажатия на кнопку "Hello"
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    /**
     * Обработчик нажатия на кнопку "Выход"
     * @param event событие нажатия на кнопку
     * @throws IOException если возникает ошибка ввода-вывода
     */
    @FXML
    protected void exitButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Обработчик нажатия на кнопку "Дальше"
     * @param event событие нажатия на кнопку
     * @throws IOException если возникает ошибка ввода-вывода
     */
    @FXML
    protected void nextButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) nextButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
