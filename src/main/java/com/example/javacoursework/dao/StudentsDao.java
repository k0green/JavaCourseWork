package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Student;

import java.util.List;

/**
 *  Интерфейс для работы с базой данных студентов.
 *
 * @author Egor
 * @version 1.0
 */
public interface StudentsDao {

    /**
     *  Получить список всех студентов в группе.
     *  @param groupId идентификатор группы
     *  @return список студентов в группе
     */
    List<Student> getAllStudentsByGroupId(int groupId);
    /**
     *  Добавить студента в базу данных.
     *  @param student студент
     */
    void addStudent(Student student);
    /**
     *  Получить студента по его имени.
     *  @param studentName имя студента
     *  @return студент
     */
    Student getStudentByName(String studentName);
    /**
     *  Удалить студента из базы данных.
     *  @param student студент
     */
    void Delete(Student student);
    /**
     *  Обновить информацию о студенте в базе данных.
     *  @param student студент
     */
    void Update(Student student);
}
