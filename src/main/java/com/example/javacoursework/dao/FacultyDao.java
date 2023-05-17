package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Faculty;

/**
 * Интерфейс для доступа к данным факультетов.
 *
 * @author Egor
 * @version 1.0
 */
public interface FacultyDao {

    /**
     * Получает объект факультета по номеру группы.
     *
     * @param number номер группы
     * @return объект факультета
     */
    Faculty getFacultyByNumber(String number);
}

