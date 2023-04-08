package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Students;
import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.entity.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getAllSubject();
    void addSubject(Subject subject);
    Subject getSubjectByName(String subjectName);
}
