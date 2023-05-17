package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.Impl.ProfessorDaoImpl;
import com.example.javacoursework.dao.ProfessorDao;
import com.example.javacoursework.entity.Professor;
import com.example.javacoursework.service.ProfessorService;

import java.util.List;

/**
 * Класс предоставляет реализацию методов из интерфейса ProfessorService,
 * используя объект DAO класса ProfessorDaoImpl.
 */
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorDao professorDao = new ProfessorDaoImpl();

    /**
     * Метод для получения списка всех преподавателей из БД
     * @return список всех преподавателей
     */
    @Override
    public List<Professor> getAllProfessors() {
        return professorDao.getAllProfessors();
    }
}
