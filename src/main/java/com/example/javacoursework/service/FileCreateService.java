package com.example.javacoursework.service;

import com.example.javacoursework.entity.Faculty;
import com.example.javacoursework.models.DocModel;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 Интерфейс для создания документов.
 *
 * @author Egor
 * @version 1.0
 */
 public interface FileCreateService {
    /**
     * Создает документ на основе переданной модели.
     * @param doc модель документа
     * @return true, если документ успешно создан, иначе - false
     * @throws IOException если произошла ошибка ввода-вывода при создании документа
    */
    public boolean CreateDocument(DocModel doc) throws IOException;
}
