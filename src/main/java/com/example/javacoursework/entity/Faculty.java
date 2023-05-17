package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> класс описывающий таблицу Faculty в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
public class Faculty {
    /**
     * id факультета
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    /**
     * название факультета
     */
    @Basic
    @Column(name = "Name")
    private String name;

    /**
     * номер факултета
     */
    @Basic
    @Column(name = "Faculty_number")
    private String facultyNumber;

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
     * метод, получающий номер факультета
     * @return facultyNumber - номер факультета
     */
    public String getFacultyNumber() {
        return facultyNumber;
    }

    /**
     * метод, принимающий номер факультета
     * @param facultyNumber
     */
    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    /**
     * метод, сравнивающий объекты класса Faculty
     * @param o - объект класса Faculty
     * @return true или false - результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(name, faculty.name) && Objects.equals(facultyNumber, faculty.facultyNumber);
    }

    /**
     * метод, возвращающий объект приведенный к строке
     * @return string - строка состоящая из названия класса, id записи,
     * названию факультета, номера факультета
     */
    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facultyNumber='" + facultyNumber + '\'' +
                '}';
    }
}
