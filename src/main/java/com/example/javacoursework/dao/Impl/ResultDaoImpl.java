package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.ResultDao;
import com.example.javacoursework.entity.Result;
import com.example.javacoursework.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *  Реализация интерфейса ResultDao.
 *
 * @author Egor
 * @version 1.0
 */
public class ResultDaoImpl implements ResultDao {
    /**
     * реализация метода для получения результата
     * @param semester - семестр
     * @param studentId - id студента
     * @param subjectId - id предмета
     * @return объект класса Result
     */
    @Override
    public Result getResultByStudentAndSubjectIdAndSemester(int semester, int studentId, int subjectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Result> criteriaQuery = criteriaBuilder.createQuery(Result.class);
        Root<Result> resultRoot = criteriaQuery.from(Result.class);
        Predicate predicateSem = criteriaBuilder.equal(resultRoot.get("semester"), semester);
        Predicate predicateSubject = criteriaBuilder.equal(resultRoot.get("subjectId"), subjectId);
        Predicate predicateStudent = criteriaBuilder.equal(resultRoot.get("studentId"), studentId);
        Predicate predicateAnd = criteriaBuilder.and(predicateSubject, predicateSem, predicateStudent);
        criteriaQuery.where(predicateAnd);
        try {
            Result result = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return result;
        } catch (Exception ex){
            return null;
        }
    }

    /**
     * реализация метода добавления результата
     * @param result
     */
    @Override
    public void addResult(Result result) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(result);
        }catch (HibernateException e){
            transaction.rollback();
        }
        session.close();
    }

    /**
     * реализация метода обновления результата
     * @param result - объект класса Result
     */
    public void Update(Result result){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(result);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
