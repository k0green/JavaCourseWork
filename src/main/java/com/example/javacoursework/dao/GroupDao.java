package com.example.javacoursework.dao;

import com.example.javacoursework.entity.Students;
import com.example.javacoursework.entity.StudyGroup;

import java.util.List;

public interface GroupDao {
    List<StudyGroup> getAllGroup();
    void Add(StudyGroup group);
    StudyGroup getGroupByName(String groupNum);
}
