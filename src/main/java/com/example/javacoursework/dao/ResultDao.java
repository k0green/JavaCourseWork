package com.example.javacoursework.dao;
import com.example.javacoursework.entity.Result;

/**
 * Интерфейс для доступа к данным о результате обучения студентов.
 *
 * @author Egor
 * @version 1.0
 */
public interface ResultDao {

    /**
     * Добавляет новый результат в базу данных.
     *
     * @param result результат для добавления.
     */
    void addResult(Result result) ;

    /**
     * Получает результат студента по его идентификатору, идентификатору предмета и номеру семестра.
     *
     * @param semester номер семестра.
     * @param studentId идентификатор студента.
     * @param subjectId идентификатор предмета.
     * @return результат обучения студента.
     */
    Result getResultByStudentAndSubjectIdAndSemester(int semester, int studentId, int subjectId);

    /**
     * Обновляет данные о результате студента в базе данных.
     *
     * @param result результат для обновления.
     */
    void Update(Result result);
}

