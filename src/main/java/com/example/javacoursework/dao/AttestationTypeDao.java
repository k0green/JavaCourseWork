package com.example.javacoursework.dao;

import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Subject;

import java.util.List;

/**
 *  Интерфейс для работы с типами аттестации в базе данных.
 *
 * @author Egor
 * @version 1.0
 */
public interface AttestationTypeDao {
    /**
     * Получает список всех типов аттестации.
     * @return список типов аттестации
     */
    List<AttestationType> getAllTypes();
}
