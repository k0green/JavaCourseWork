package com.example.javacoursework.service;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Subject;

import java.util.List;

/**
 * Интерфейс для работы с типами аттестации.
 * @author Egor
 * @version 1.0
 */
public interface AttestationTypeService {

    /**
     * Метод для получения всех типов аттестации.
     * @return список типов аттестации
     */
    List<AttestationType> getAllTypes();
}
