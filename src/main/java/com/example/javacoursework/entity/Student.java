package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <strong> класс описывающий таблицу Students в базе данных </strong>
 *
 * @author Egor
 * @version 1.0
 */
@Entity
@Table(name = "Students", schema = "javacw")
public class Student {
    /**
     * id студента
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    /**
     * имя студента
     */
    @Basic
    @Column(name = "full_name")
    private String fullName;

    /**
     * номер зачетной книжки
     */
    @Basic
    @Column(name="bookNumber")
    private String bookNumber;
    /**
     * id группы
     */
    @Basic
    @Column(name = "groupId")
    private Integer groupId;

    /**
     * Конструктор класса, принимающий значения всех полей
     * @param id - идентификатор записи
     * @param fullName - имя студента
     * @param bookNumber - номер зачетной книжки
     * @param groupId - id группы
     */
    public Student(int id, String fullName, String bookNumber, Integer groupId) {
        this.id = id;
        this.fullName = fullName;
        this.bookNumber = bookNumber;
        this.groupId = groupId;
    }

    /**
     * Конструктор класса, без параметров
     */
    public Student() {
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
     * метод, получающий имя студента
     * @return name - имя студента
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * метод, принимающий имя студента
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * метод, получающий id группы
     * @return groupId - id группы
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * метод, принимающий id группы
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * метод, получающий номер зачетной книжки
     * @return bookNumber - номер зачетной книжки
     */
    public String getBookNumber() {
        return bookNumber;
    }

    /**
     * медод, принимающий номер зачетной книжки
     * @param bookNumber - номер зачетной книжки
     */
    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student students = (Student) o;
        return id == students.id && Objects.equals(fullName, students.fullName) && Objects.equals(bookNumber, students.bookNumber) && Objects.equals(groupId, students.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, bookNumber, groupId);
    }

    /**
     * метод, возвращающий объект приведенный к строке
     * @return string - строка состоящая из названия класса, id записи,
     * имя студента, номера зачетной книжки, id группы
     */
    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", bookNumber='" + bookNumber + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
