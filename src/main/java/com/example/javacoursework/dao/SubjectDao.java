package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Subject;

import java.util.List;

/**
 *  Интерфейс для доступа к данным предметов.
 */
public interface SubjectDao {

    /**
     *  Возвращает список всех предметов.
     *  @return список предметов
     */
    List<Subject> getAllSubject();
    /**
     *  Добавляет новый предмет в базу данных.
     *  @param subject объект предмета для добавления
     */
    void addSubject(Subject subject);
    /**
     *  Возвращает объект предмета по его названию.
     *  @param subjectName название предмета
     *  @return объект предмета
     */
    Subject getSubjectByName(String subjectName);
}
