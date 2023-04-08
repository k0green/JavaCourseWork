package com.example.javacoursework.service;

import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject();
    void addSubject(Subject subject);
}
