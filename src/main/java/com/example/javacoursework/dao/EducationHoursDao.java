package com.example.javacoursework.dao;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.EducationHours;
import com.example.javacoursework.entity.Subject;
import org.hibernate.query.Query;

import java.util.List;

public interface EducationHoursDao {
    EducationHours getHoursByGroupCodeAndSemester(int semester, String code);
    void addHours(EducationHours educationHours);
    EducationHours getHoursByName(String hoursName);
}
