package com.example.javacoursework.service;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Result;

import java.util.List;

/**
 * Интерфейс для работы с результатами.
 * @author Egor
 * @version 1.0
 */
public interface ResultService {
    /**
     * метод для получения результата для студента
     * @param semester - номер семестра
     * @param studentId - id студента
     * @param subjectId - id предмеа
     * @return результат
     */
    Result getResultByStudentAndSubjectIdAndSemester(int semester, int studentId, int subjectId);

    /**
     * Метод для добавления результата
     */
    void Add(Result result);

    /**
     * Метод для обновления результата
     */
    void Update(Result result);
}
