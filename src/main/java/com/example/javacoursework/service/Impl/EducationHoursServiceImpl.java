package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.AttestationTypeDao;
import com.example.javacoursework.dao.Impl.AttestationTypeDaoImpl;
import com.example.javacoursework.dao.Impl.EducationHoursDaoImpl;
import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.EducationHours;
import com.example.javacoursework.service.AttestationTypeService;
import com.example.javacoursework.service.EducationHoursService;
import org.hibernate.query.Query;

import java.util.List;

/**
 * класс реализует интерфейс EducationHoursService
 * и предоставляет реализацию метода addHours()
 * getHoursByGroupCodeAndSemester
 *
 * @author Egor
 * @version 1.0
 */
public class EducationHoursServiceImpl implements EducationHoursService {

    /**
     * Объект доступа к данным таблицы "education_hours".
     */
    private final EducationHoursDaoImpl educationHoursDao = new EducationHoursDaoImpl();
    /**
     * Получение информации о часах для определенной группы и семестра.
     * @param semester номер семестра
     * @param code код группы
     * @return объект EducationHours
     */
    @Override
    public EducationHours getHoursByGroupCodeAndSemester(int semester, String code) {
        return educationHoursDao.getHoursByGroupCodeAndSemester(semester, code);
    }
    /**
     * Добавление информации о часах.
     * @param educationHours объект EducationHours
     */
    @Override
    public void addHours(EducationHours educationHours) {
        if(educationHoursDao.getHoursByName(educationHours.getHours())==null)
            educationHoursDao.addHours(educationHours);
    }
}
