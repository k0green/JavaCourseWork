package com.example.javacoursework.service;

import com.example.javacoursework.models.StudentModel;

import java.util.List;

/**
 * Интерфейс для работы со студентами.
 * @author Egor
 * @version 1.0
 */
public interface StudentsService {
    /**
     * метод для добавления студентов
     * @param student - объект студента
     * @param semester - семестр
     * @param subjectId - id предмета
     */
    public void addStudent(StudentModel student, int semester, int subjectId);

    /**
     * получение всех студентов
     * @param groupId - id группы
     * @param subjectId - id предмета
     * @param semester семестр
     * @return список студентов
     */
    List<StudentModel> getAllStudentsByGroupIdSemesterAndSubjectId(int groupId, int subjectId, int semester);

    /**
     * метод для удаления стдентов
     * @param student - объект студента
     */
    void Delete(StudentModel student);

    /**
     * метод для обновления студента
     * @param student - объект студента
     * @param semester - семестр
     * @param subjectId - id предмета
     */
    void Update(StudentModel student, int semester, int subjectId);
}
