package com.example.javacoursework.dao.Impl;
import com.example.javacoursework.dao.StudentsDao;
import com.example.javacoursework.entity.Students;
import com.example.javacoursework.entity.Subject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.example.javacoursework.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentsDaoImpl implements StudentsDao {

    public List<Students> getAllStudentsByGroupId(int groupId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Students> criteriaQuery = criteriaBuilder.createQuery(Students.class);
        Root<Students> studentRoot = criteriaQuery.from(Students.class);
        Predicate predicateLogin = criteriaBuilder.equal(studentRoot.get("groupId"), groupId);
        criteriaQuery.where(predicateLogin);
        List<Students> students = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return students;
    }

    @Override
    public void addStudent(Students student) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.save(student);
            }catch (HibernateException e){
                transaction.rollback();
            }
            session.close();
    }

    @Override
    public Students getStudentByName(String studentName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Students> criteriaQuery = criteriaBuilder.createQuery(Students.class);
        Root<Students> subjectRoot = criteriaQuery.from(Students.class);
        Predicate predicateName = criteriaBuilder.equal(subjectRoot.get("fullName"), studentName);
        criteriaQuery.where(predicateName);
        List<Students> students = session.createQuery(criteriaQuery).getResultList();
        session.close();
        if (!students.isEmpty()) {
            return students.get(0);
        } else {
            return null;
        }
    }

    public void Delete(Students student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(student);
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
