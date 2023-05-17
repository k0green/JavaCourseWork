package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.AttestationTypeDao;
import com.example.javacoursework.dao.Impl.AttestationTypeDaoImpl;
import com.example.javacoursework.dao.Impl.ResultDaoImpl;
import com.example.javacoursework.dao.ResultDao;
import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Result;
import com.example.javacoursework.service.AttestationTypeService;
import com.example.javacoursework.service.ResultService;
import com.example.javacoursework.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Класс реализует интерфейс ResultService и предоставляет реализацию методов для
 * получения результатат для студента добавления результата, обновления результата
 *
 * @author Egor
 * @version 1.0
 */
public class ResultServiceImpl implements ResultService {
    // Создаем объект DAO для доступа к результатам
    private final ResultDao resultDao = new ResultDaoImpl();

    /**
     * Получить результат студента по ID студента, ID предмета и семестру
     * @param semester семестр
     * @param studentId ID студента
     * @param subjectId ID предмета
     * @return результат студента
     */
    @Override
    public Result getResultByStudentAndSubjectIdAndSemester(int semester, int studentId, int subjectId) {
        return resultDao.getResultByStudentAndSubjectIdAndSemester(semester, studentId, subjectId);
    }

    /**
     * Добавить результат
     * @param result результат
     */
    @Override
    public void Add(Result result) {
        resultDao.addResult(result);
    }

    /**
     * Обновить результат
     * @param result результат
     */
    @Override
    public void Update(Result result) {
        resultDao.Update(result);
    }
}
