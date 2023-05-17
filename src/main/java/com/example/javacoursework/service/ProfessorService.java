package com.example.javacoursework.service;

import com.example.javacoursework.entity.Professor;

import java.util.List;

/**
 * Интерфейс для работы с преподавателями.
 * @author Egor
 * @version 1.0
 */
public interface ProfessorService {
    /**
     * метод для получения всех преподавателей
     * @return список преподавателей
     */
    List<Professor> getAllProfessors();
}
