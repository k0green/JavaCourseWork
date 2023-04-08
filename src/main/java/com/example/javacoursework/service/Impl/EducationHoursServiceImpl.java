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

public class EducationHoursServiceImpl implements EducationHoursService {
    private final EducationHoursDaoImpl educationHoursDao = new EducationHoursDaoImpl();

    @Override
    public EducationHours getHoursByGroupCodeAndSemester(int semester, String code) {
        return educationHoursDao.getHoursByGroupCodeAndSemester(semester, code);
    }

    @Override
    public void addHours(EducationHours educationHours) {
        if(educationHoursDao.getHoursByName(educationHours.getHours())==null)
            educationHoursDao.addHours(educationHours);
    }
}
