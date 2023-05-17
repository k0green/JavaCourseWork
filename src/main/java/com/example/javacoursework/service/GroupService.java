package com.example.javacoursework.service;

import com.example.javacoursework.entity.StudyGroup;

import java.util.List;

/**
 * Интерфейс для работы с группами.
 * @author Egor
 * @version 1.0
 */
public interface GroupService {
    /**
     * метод, для получения всех групп
     * @return
     */
    List<StudyGroup> getAllGroup();

    /**
     * получение id группы по номеру зачетной книжки
     * @param bookNum
     * @return
     */
    int getIdForAddStudent(String bookNum);
}
