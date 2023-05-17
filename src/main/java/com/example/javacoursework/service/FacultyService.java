package com.example.javacoursework.service;

import com.example.javacoursework.entity.Faculty;

/**
 * Интерфейс для работы с факультетами.
 */
 public interface FacultyService {
 /**
  * Получает факультет по номеру группы.
  * @param groupNumber номер группы
  * @return факультет
 */
    public Faculty getFaculty(String groupNumber);
}
