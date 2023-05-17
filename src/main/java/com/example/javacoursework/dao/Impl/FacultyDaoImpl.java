package com.example.javacoursework.dao.Impl;

import com.example.javacoursework.dao.FacultyDao;
import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.entity.Faculty;
import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *  Реализация интерфейса FacultyDao.
 *
 * @author Egor
 * @version 1.0
 */
public class FacultyDaoImpl implements FacultyDao {

    /**
     * метож ждя получения факультета по его номеру
     * @param number - номер факультета
     * @return объект класса Faculty
     */
    public Faculty getFacultyByNumber(String number) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Faculty> criteriaQuery = criteriaBuilder.createQuery(Faculty.class);
        Root<Faculty> facultyRoot = criteriaQuery.from(Faculty.class);
        Predicate predicateName = criteriaBuilder.equal(facultyRoot.get("facultyNumber"), number);
        criteriaQuery.where(predicateName);
        Faculty faculty = session.createQuery(criteriaQuery).getResultList().get(0);
        session.close();
        return faculty;
    }

}
