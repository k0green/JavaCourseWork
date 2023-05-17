package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> Класс описывающий таблицу тип аттестации в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
@Table(name = "attestation_type", schema = "javacw")
public class AttestationType {

    /**
     * id записи
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    /**
     * название типа аттестации
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * метод, получающий id типа аттестации
     * @return id - id типа аттестации
     */
    public int getId() {
        return id;
    }

    /**
     * метод, принимающий id типа аттестации
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * метод, получающий название типа аттестации
     * @return name - name типа аттестации
     */
    public String getName() {
        return name;
    }

    /**
     * метод, принимающий название типа аттестации
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * метод, сравнивающий объекты класса AttestationType
     * @param o - объект класса AttestationType
     * @return true или false - результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttestationType that = (AttestationType) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    /**
     * метод, возвращающий объект приведенный к строке
     * @return name - название типа аттестации
     */
    @Override
    public String toString() {
        return name;
    }
}
