package com.example.javacoursework.dao;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.EducationHours;
import com.example.javacoursework.entity.Subject;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Интерфейс для доступа к данным об общем количестве часов по группам
 *  @author Egor
 *  @version 1.0
 */
public interface EducationHoursDao {

    /**
     *  Получить данные о количестве часов для группы по указанному семестру и коду группы
     *  @param semester номер семестра
     *  @param code код группы
     *  @return объект EducationHours с информацией о количестве часов для группы
     */
    EducationHours getHoursByGroupCodeAndSemester(int semester, String code);
    /**
     *  Добавить данные о количестве часов для группы
     *  @param educationHours объект EducationHours с информацией о количестве часов для группы
     */
    void addHours(EducationHours educationHours);
    /**
     *  Получить данные о количестве часов по названию
     *  @param hoursName название часов
     *  @return объект EducationHours с информацией о количестве часов
     */
    EducationHours getHoursByName(String hoursName);
}
