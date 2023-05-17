package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.FacultyDao;
import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.dao.Impl.FacultyDaoImpl;
import com.example.javacoursework.dao.Impl.GroupDaoImpl;
import com.example.javacoursework.entity.Faculty;
import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.service.FacultyService;
import com.example.javacoursework.service.GroupService;

import java.util.List;

/**
 * Класс реализует интерфейс FacultyService и предоставляет реализацию метода getFaculty()
 * для получения факультета по номеру группы.
 *
 * @author Egor
 * @version 1.0
 */
public class FacultyServiceImpl implements FacultyService {
    /**
     * Создаем объект DAO для доступа к факультетам
      */
    private final FacultyDao facultyDao = new FacultyDaoImpl();

    /**
     * Метод для получения факультета по номеру группы.
     * @param groupNumber номер группы
     * @return объект класса Faculty
     */
    @Override
    public Faculty getFaculty(String groupNumber) {
        var number = groupNumber.substring(0,3);
        return facultyDao.getFacultyByNumber(number);
    }
}
