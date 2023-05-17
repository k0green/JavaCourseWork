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

/**
 * класс реализует интерфейс AttestationTypeService и предоставляет реализацию метода getAllTypes()
 *
 * @author Egor
 * @version 1.0
 */
public class AttestationTypeServiceImpl implements AttestationTypeService {

    // Создаем объект DAO для доступа к типам аттестации
    private final AttestationTypeDao attestationTypeDao = new AttestationTypeDaoImpl();

    /**
     * Метод для получения всех типов аттестации
     * @return список типов аттестации
     */
    @Override
    public List<AttestationType> getAllTypes() {
        return attestationTypeDao.getAllTypes();
    }
}
