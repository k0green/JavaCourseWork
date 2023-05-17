package com.example.javacoursework.service;

import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.entity.Subject;

import java.util.List;

/**
 * Интерфейс для работы с предметами.
 * @author Egor
 * @version 1.0
 */
public interface SubjectService {
    /**
     * метод для получения всех предметов
     * @return список предметов
     */
    List<Subject> getAllSubject();

    /**
     * добавление предмета
     * @param subject - объект предмета
     */
    void addSubject(Subject subject);

    /**
     * метод для получения id предмета по имени
     * @param name - название предмета
     * @return id предмета
     */
    Integer getSubjectIdByName(String name);
}
