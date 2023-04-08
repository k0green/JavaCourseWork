package com.example.javacoursework.dao;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Subject;

import java.util.List;

public interface AttestationTypeDao {
    List<AttestationType> getAllTypes();
}
