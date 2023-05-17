package com.example.javacoursework.service;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.EducationHours;

import java.util.List;

/**
 * Интерфейс, предоставляющий методы для работы с учебными часами.
 */
public interface EducationHoursService {

    /**
     * Метод для получения учебных часов по коду группы и номеру семестра.
     * @param semester номер семестра
     * @param code код группы
     * @return объект EducationHours, содержащий информацию об учебных часах
     */
    public EducationHours getHoursByGroupCodeAndSemester(int semester, String code);
    /**
     * Метод для добавления информации об учебных часах.
     * @param educationHours объект EducationHours, содержащий информацию об учебных часах
     */
    void addHours(EducationHours educationHours);
}
