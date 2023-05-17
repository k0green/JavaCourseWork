package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.SubjectDao;
import com.example.javacoursework.entity.Subject;
import com.example.javacoursework.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *  Реализация интерфейса SubjectDao.
 *
 * @author Egor
 * @version 1.0
 */
public class SubjectDaoImpl implements SubjectDao {

    /**
     * реализация метода для получения всех предметов
     * @return список предметов
     */
    public List<Subject> getAllSubject() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
        criteriaQuery.from(Subject.class);
        List<Subject> subjects = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return subjects;
    }

    /**
     * реализация метода для получения предмета по его названию
     * @param subjectName - название предмета
     * @return объект класса Subject
     */
    @Override
    public Subject getSubjectByName(String subjectName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
        Root<Subject> subjectRoot = criteriaQuery.from(Subject.class);
        Predicate predicateName = criteriaBuilder.equal(subjectRoot.get("name"), subjectName);
        criteriaQuery.where(predicateName);
        List<Subject> subject = session.createQuery(criteriaQuery).getResultList();
        session.close();
        if (!subject.isEmpty()) {
            return subject.get(0);
        } else {
            return null;
        }
    }

    /**
     * реализация метода для добавления предмета
     * @param subject - объект класса Subject
     */
    @Override
    public void addSubject(Subject subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(subject);
        }catch (HibernateException e){
            transaction.rollback();
        }
        session.close();
    }

}
