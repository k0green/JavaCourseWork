package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Professor;
import com.example.javacoursework.entity.StudyGroup;

import java.util.List;

/**
 * Интерфейс для доступа к данным о профессорах.
 *
 * @author Egor
 * @version 1.0
 */
public interface ProfessorDao {

    /**
     * Получение списка всех профессоров.
     * @return список всех профессоров
     */
    List<Professor> getAllProfessors();

    /**
     * Добавление нового профессора.
     * @param professor объект нового профессора
     */
    void Add(Professor professor);

    /**
     * Получение профессора по его имени.
     * @param professorName имя профессора
     * @return объект профессора
     */
    Professor getProfessorByName(String professorName);
}

