package com.example.javacoursework.dao.Impl;
import com.example.javacoursework.dao.StudentsDao;
import com.example.javacoursework.entity.Student;
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

/**
 *  Реализация интерфейса StudentsDao.
 *
 * @author Egor
 * @version 1.0
 */
public class StudentsDaoImpl implements StudentsDao {

    /**
     * реализация метода, возвращающего всех студентов для группы
     * @param groupId - id группы
     * @return список студентов
     */
    public List<Student> getAllStudentsByGroupId(int groupId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        Predicate predicateLogin = criteriaBuilder.equal(studentRoot.get("groupId"), groupId);
        criteriaQuery.where(predicateLogin);
        List<Student> students = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return students;
    }

    /**
     * реализация метода для добавления студента
     * @param student - объект класса Students
     */
    @Override
    public void addStudent(Student student) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.save(student);
            }catch (HibernateException e){
                transaction.rollback();
            }
            session.close();
    }

    /**
     * реализация метода для получения студента по имени
     * @param studentName - имя студента
     * @return объект класса Students
     */
    @Override
    public Student getStudentByName(String studentName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> subjectRoot = criteriaQuery.from(Student.class);
        Predicate predicateName = criteriaBuilder.equal(subjectRoot.get("fullName"), studentName);
        criteriaQuery.where(predicateName);
        List<Student> students = session.createQuery(criteriaQuery).getResultList();
        session.close();
        if (!students.isEmpty()) {
            return students.get(0);
        } else {
            return null;
        }
    }

    /**
     * реализация метода для удаления студента
     * @param student - объект класса Students
     */
    public void Delete(Student student) {
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

    /**
     * реализация метода для обновления студента
     * @param student - объект класса Students
     */
    @Override
    public void Update(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(student);
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
