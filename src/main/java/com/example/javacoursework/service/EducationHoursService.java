package com.example.javacoursework.service;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.EducationHours;

import java.util.List;

public interface EducationHoursService {
    public EducationHours getHoursByGroupCodeAndSemester(int semester, String code);
    void addHours(EducationHours educationHours);
}
