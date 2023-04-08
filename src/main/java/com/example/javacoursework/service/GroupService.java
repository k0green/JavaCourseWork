package com.example.javacoursework.service;

import com.example.javacoursework.entity.Students;
import com.example.javacoursework.entity.StudyGroup;

import java.util.List;

public interface GroupService {
    List<StudyGroup> getAllGroup();

    int getIdForAddStudent(String bookNum);
}
