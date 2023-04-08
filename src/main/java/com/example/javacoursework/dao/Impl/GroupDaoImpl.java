package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.dao.StudentsDao;
import com.example.javacoursework.entity.Students;
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

public class GroupDaoImpl implements GroupDao {

    public List<StudyGroup> getAllGroup() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<StudyGroup> criteriaQuery = criteriaBuilder.createQuery(StudyGroup.class);
        criteriaQuery.from(StudyGroup.class);
        List<StudyGroup> groups = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return groups;
    }

    @Override
    public void Add(StudyGroup group) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.save(group);
            }catch (HibernateException e){
                transaction.rollback();
            }
            session.close();
    }


/*    public void Delete(Film film) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(film);
        }catch (HibernateException e){
            transaction.rollback();
        }
        session.close();
    }*/

    @Override
    public StudyGroup getGroupByName(String groupNum) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<StudyGroup> criteriaQuery = criteriaBuilder.createQuery(StudyGroup.class);
        Root<StudyGroup> groupRoot = criteriaQuery.from(StudyGroup.class);
        Predicate predicateName = criteriaBuilder.equal(groupRoot.get("name"), groupNum);
        criteriaQuery.where(predicateName);
        List<StudyGroup> groups = session.createQuery(criteriaQuery).getResultList();
        session.close();
        if (!groups.isEmpty()) {
            return groups.get(0);
        } else {
            return null;
        }
    }

}
