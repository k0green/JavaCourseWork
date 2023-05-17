package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> класс описывающий таблицу EducationHours в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
public class EducationHours {
    /**
     * id записи
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    /**
     * количество часов
     */
    @Basic
    @Column(name = "Hours")
    private String hours;
    /**
     * код группы
     */
    @Basic
    @Column(name = "GroupCode")
    private String groupCode;
    /**
     * номер семестра
     */
    @Basic
    @Column(name = "Semestr")
    private String semestr;

    /**
     Конструктор класса, принимающий значения всех полей
     @param id - идентификатор записи
     @param hours - количество часов
     @param groupCode - код группы
     @param semestr - семестр
     */
    public EducationHours(int id, String hours, String groupCode, String semestr) {
        this.id = id;
        this.hours = hours;
        this.groupCode = groupCode;
        this.semestr = semestr;
    }

     /**
     Конструктор класса без параметров
     */
    public EducationHours() {
    }

     /**
     Метод, возвращающий идентификатор записи
     @return id - идентификатор записи
     */
    public int getId() {
        return id;
    }
     /**
     Метод, принимающий идентификатор записи
     @param id - идентификатор записи
     */
    public void setId(int id) {
        this.id = id;
    }

     /**
     Метод, возвращающий количество часов
     @return hours - количество часов
     */
    public String getHours() {
        return hours;
    }

    /**
     Метод, принимающий идентификатор записи
     @param hours - идентификатор записи
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     Метод, возвращающий код группы
     @return groupCode - код группы
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     Метод, принимающий код группы
     @param groupCode - код группы
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * метод, возвращающий номер семестра
     * @return semestr - номер семестра
     */
    public String getSemestr() {
        return semestr;
    }

    /**
     * метод, принимающий номер семестра
     * @param semestr - номер семестра
     */
    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    /**
     * метод, сравнивающий объекты класса EducationHours
     * @param o - объект класса EducationHours
     * @return true или false - результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationHours that = (EducationHours) o;
        return id == that.id && Objects.equals(hours, that.hours)
                && Objects.equals(groupCode, that.groupCode)
                && Objects.equals(semestr, that.semestr);
    }

    /**
     * метод, возвращающий объект приведенный к строке
     * @return string - строка состоящая из названия класса, id записи,
     * количества часов, кода группы, номера семестра
     */
    @Override
    public String toString() {
        return "EducationHours{" +
                "id=" + id +
                ", hours='" + hours + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", semestr='" + semestr + '\'' +
                '}';
    }
}
