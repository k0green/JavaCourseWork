package com.example.javacoursework.service;

import com.example.javacoursework.entity.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getAllStudentsByGroupId(int groupId);
    void addStudent(Students student);
    void Delete(Students student);
}
