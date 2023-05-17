package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.Impl.SubjectDaoImpl;
import com.example.javacoursework.dao.SubjectDao;
import com.example.javacoursework.entity.Subject;
import com.example.javacoursework.service.SubjectService;

import java.util.List;

/**
 * Класс реализует интерфейс SubjectService и предоставляет
 * реализацию методов по работе с предметами
 *
 * @author Egor
 * @version 1.0
 */
public class SubjectServiceImpl implements SubjectService {
    /**
     * Создаем объект DAO для доступа к предметам
     */
    private final SubjectDao subjectDao = new SubjectDaoImpl();

    /**
     * метод для получения всех предметов
     * @return списко предметов
     */
    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    /**
     * получение id предмета по его имени
     * @param name - навание предмета
     * @return id предмета
     */
    @Override
    public Integer getSubjectIdByName(String name) {
        int id;
        var subject = subjectDao.getSubjectByName(name);
        if(subject == null){
            subjectDao.addSubject(new Subject(0, name));
            id = subjectDao.getSubjectByName(name).getId();
        } else {
            id = subject.getId();
        }
        return id;
    }

    /**
     * Добавление предмета
     * @param subject - объект класса Subject
     */
    @Override
    public void addSubject(Subject subject) {
        if(subjectDao.getSubjectByName(subject.getName())==null)
            subjectDao.addSubject(subject);
    }
}
