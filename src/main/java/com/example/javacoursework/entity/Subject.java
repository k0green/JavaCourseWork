package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> класс описывающий таблицу Subject в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
public class Subject {
    /**
     * id предмета
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    /**
     * название предмета
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * Конструктор класса, принимающий значения всех полей
     * @param id - идентификатор записи
     * @param name - название предмета
     */
    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Конструктор класса без параметров
     */
    public Subject() {
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
     * метод, получающий название предмета
     * @return name - название предмета
     */
    public String getName() {
        return name;
    }

    /**
     * метод, принимающий название предмета
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * метод, возвращающий объект приведенный к строке
     * @return name - строка состоящая из названия предмета
     */
    @Override
    public String toString() {
        return name;
    }
}
