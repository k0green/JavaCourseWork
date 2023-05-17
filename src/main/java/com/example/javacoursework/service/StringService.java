package com.example.javacoursework.service;

/**
 * Интерфейс для работы со строками.
 * @author Egor
 * @version 1.0
 */
public interface StringService {
    /**
     * метод для получения года
     * @param semester - семестр
     * @param entryYear - год поступления
     * @return год
     */
    public String getYearByEntryYearAndSemester(int semester, int entryYear);
}
