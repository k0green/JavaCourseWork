package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Students;

import java.util.List;

public interface StudentsDao {
    List<Students> getAllStudentsByGroupId(int groupId);
    void addStudent(Students student);
    Students getStudentByName(String studentName);
    void Delete(Students student);
}
