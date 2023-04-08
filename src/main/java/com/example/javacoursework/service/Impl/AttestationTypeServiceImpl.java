package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.AttestationTypeDao;
import com.example.javacoursework.dao.Impl.AttestationTypeDaoImpl;
import com.example.javacoursework.dao.Impl.SubjectDaoImpl;
import com.example.javacoursework.dao.SubjectDao;
import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Subject;
import com.example.javacoursework.service.AttestationTypeService;
import com.example.javacoursework.service.SubjectService;

import java.util.List;

public class AttestationTypeServiceImpl implements AttestationTypeService {
    private final AttestationTypeDao attestationTypeDao = new AttestationTypeDaoImpl();

    @Override
    public List<AttestationType> getAllTypes() {
        return attestationTypeDao.getAllTypes();
    }
}
