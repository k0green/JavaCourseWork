package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.Impl.StudentsDaoImpl;
import com.example.javacoursework.dao.StudentsDao;
import com.example.javacoursework.entity.Students;
import com.example.javacoursework.service.StudentsService;

import java.util.*;

public class StudentServiceImpl implements StudentsService {
    private final StudentsDao studentsDao = new StudentsDaoImpl();

    public List<Students> getAllStudentsByGroupId(int groupId)
    {
        Comparator<Students> countryModelsComparator
                = Comparator.comparing(Students::getFullName);

        List<Students> students = studentsDao.getAllStudentsByGroupId(groupId);
        Collections.sort(students, countryModelsComparator);

        return students;
    }

    @Override
    public void addStudent(Students student) {
        if(studentsDao.getStudentByName(student.getFullName())==null)
            studentsDao.addStudent(student);
    }

    public void Delete(Students student){
        studentsDao.Delete(student);
    }
}
