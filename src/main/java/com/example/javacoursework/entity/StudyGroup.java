package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> класс описывающий таблицу StudyGroup в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
@Table(name = "study_group", schema = "javacw")
public class StudyGroup {
    /**
     * id студента
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    /**
     * номер группы
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * констуктор без параметров
     */
    public StudyGroup() {
    }

    /**
     * Конструктор класса, принимающий значения всех полей
     * @param id - идентификатор записи
     * @param name - группа
     */
    public StudyGroup(int id, String name) {
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
     * метод, получающий группу
     * @return name - номер группы
     */
    public String getName() {
        return name;
    }

    /**
     * метод, принимающий группу
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
