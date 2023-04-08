package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.AttestationTypeDao;
import com.example.javacoursework.dao.SubjectDao;
import com.example.javacoursework.entity.AttestationType;
import com.example.javacoursework.entity.Subject;
import com.example.javacoursework.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AttestationTypeDaoImpl implements AttestationTypeDao {

    public List<AttestationType> getAllTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<AttestationType> criteriaQuery = criteriaBuilder.createQuery(AttestationType.class);
        criteriaQuery.from(AttestationType.class);
        List<AttestationType> types = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return types;
    }

}
