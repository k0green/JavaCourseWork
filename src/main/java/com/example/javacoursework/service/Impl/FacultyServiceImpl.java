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

public class FacultyServiceImpl implements FacultyService {
    private final FacultyDao facultyDao = new FacultyDaoImpl();

    @Override
    public Faculty getFaculty(String groupNumber) {
        var number = groupNumber.substring(0,3);
        return facultyDao.getFacultyByNumber(number);
    }
}
