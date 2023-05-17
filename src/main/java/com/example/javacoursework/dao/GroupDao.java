package com.example.javacoursework.dao;

import com.example.javacoursework.entity.StudyGroup;

import java.util.List;

/**
 * Интерфейс для доступа к данным групп обучения.
 *
 * @author Egor
 * @version 1.0
 */
public interface GroupDao {

    /**
     *  Получает список всех групп обучения.
     *  @return список групп обучения
     */
    List<StudyGroup> getAllGroup();
    /**
     *  Добавляет новую группу обучения.
     *  @param group добавляемая группа
     */
    void Add(StudyGroup group);
    /**
     *  Получает группу обучения по ее номеру.
     *  @param groupNum номер группы
     *  @return группа обучения с указанным номером
     */
    StudyGroup getGroupByName(String groupNum);
}
