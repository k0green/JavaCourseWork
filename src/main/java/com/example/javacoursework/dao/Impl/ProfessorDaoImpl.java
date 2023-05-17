package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.dao.ProfessorDao;
import com.example.javacoursework.entity.Professor;
import com.example.javacoursework.entity.StudyGroup;
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
 * Реализация интерфейса ProfessorDao
 *
 * @author Egor
 * @version 1.0
 */
public class ProfessorDaoImpl implements ProfessorDao {

    /**
     * реализация метода для получения всех преподавателей
     * @return список всех студентов
     */
    public List<Professor> getAllProfessors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Professor> criteriaQuery = criteriaBuilder.createQuery(Professor.class);
        criteriaQuery.from(Professor.class);
        List<Professor> professors = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return professors;
    }

    /**
     * реализация метода для добавления студента
     * @param professor
     */
    @Override
    public void Add(Professor professor) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.save(professor);
            }catch (HibernateException e){
                transaction.rollback();
            }
            session.close();
    }

    /**
     * реализация метода для получения профессора по его имени
     * @param professorName - имя профессора
     * @return объект класса Professor
     */
    @Override
    public Professor getProfessorByName(String professorName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Professor> criteriaQuery = criteriaBuilder.createQuery(Professor.class);
        Root<StudyGroup> groupRoot = criteriaQuery.from(StudyGroup.class);
        Predicate predicateName = criteriaBuilder.equal(groupRoot.get("name"), professorName);
        criteriaQuery.where(predicateName);
        List<Professor> professors = session.createQuery(criteriaQuery).getResultList();
        session.close();
        if (!professors.isEmpty()) {
            return professors.get(0);
        } else {
            return null;
        }
    }

}
