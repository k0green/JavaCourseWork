package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.dao.Impl.GroupDaoImpl;
import com.example.javacoursework.dao.Impl.SubjectDaoImpl;
import com.example.javacoursework.dao.SubjectDao;
import com.example.javacoursework.entity.Students;
import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.entity.Subject;
import com.example.javacoursework.service.GroupService;
import com.example.javacoursework.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private final SubjectDao subjectDao = new SubjectDaoImpl();

    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Override
    public void addSubject(Subject subject) {
        if(subjectDao.getSubjectByName(subject.getName())==null)
            subjectDao.addSubject(subject);
    }
}
