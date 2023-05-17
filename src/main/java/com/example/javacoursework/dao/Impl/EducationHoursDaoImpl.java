package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.EducationHoursDao;
import com.example.javacoursework.entity.EducationHours;
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
 *  Реализация интерфейса EducationHoursDao.
 *
 * @author Egor
 * @version 1.0
 */
public class EducationHoursDaoImpl implements EducationHoursDao {
    /**
     * Реализация метода, который получает часы в семестре по коду группы
     * @param semester - семестр
     * @param code - код группы
     * @return объект класса EducationHours
     */
    public EducationHours getHoursByGroupCodeAndSemester(int semester, String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EducationHours> criteriaQuery = criteriaBuilder.createQuery(EducationHours.class);
        Root<EducationHours> hoursRoot = criteriaQuery.from(EducationHours.class);
        Predicate predicateSem = criteriaBuilder.equal(hoursRoot.get("semestr"), semester);
        Predicate predicateCode = criteriaBuilder.equal(hoursRoot.get("groupCode"), code);
        Predicate predicateAnd = criteriaBuilder.and(predicateCode, predicateSem);
        criteriaQuery.where(predicateAnd);
        try {
            EducationHours hours = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return hours;
        } catch (Exception ex){
            return null;
        }
    }

    /**
     * метод, добавляющий часы
     * @param educationHours - объект класса часов
     */
    @Override
    public void addHours(EducationHours educationHours) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(educationHours);
        }catch (HibernateException e){
            transaction.rollback();
        }
        session.close();
    }

    /**
     * получает объект класса EducationHours по названию
     * @param hoursName - часы
     * @return объект класса EducationHours
     */
    @Override
    public EducationHours getHoursByName(String hoursName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EducationHours> criteriaQuery = criteriaBuilder.createQuery(EducationHours.class);
        Root<EducationHours> hoursRoot = criteriaQuery.from(EducationHours.class);
        Predicate predicateName = criteriaBuilder.equal(hoursRoot.get("hours"), hoursName);
        criteriaQuery.where(predicateName);
        List<EducationHours> hours = session.createQuery(criteriaQuery).getResultList();
        session.close();
        if (!hours.isEmpty()) {
            return hours.get(0);
        } else {
            return null;
        }
    }
}
