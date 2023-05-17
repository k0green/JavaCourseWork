package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> класс описывающий таблицу professor в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
@Table(name = "professor", schema = "javacw")
public class Professor {
    /**
     * id преподавателя
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    /**
     * имя преподавателя
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * конструктор без параметров
     */
    public Professor() {
    }

    /**
     * Конструктор класса, принимающий значения всех полей
     * @param id - идентификатор записи
     * @param name - имя преподавателя
     */
    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Метод, возвращающий идентификатор записи
     * @return id - идентификатор записи
     */
    public int getId() {
        return id;
    }

    /**
     * Метод, принимающий идентификатор записи
     * @param id - идентификатор записи
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * метод, получающий имя преподавателя
     * @return name - имя профессора
     */
    public String getName() {
        return name;
    }

    /**
     * метод, принимающий имя преподавателя
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
        Professor that = (Professor) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    /**
     * метод, возвращающий объект приведенный к строке
     * @return name - имя преподавателя
     */
    @Override
    public String toString() {
        return name;
    }
}
