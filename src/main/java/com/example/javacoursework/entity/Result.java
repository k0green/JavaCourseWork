package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

/**
    <strong> Класс, описывающий таблицу Result в базе данных </strong>
    Этот класс содержит поля, соответствующие столбцам таблицы Result,
    а также методы доступа к этим полям.

    @author Egor
    @version 1.0
 */
@Entity
@Table(name = "result", schema = "javacw")
public class Result {
    /**
     * id результата
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    /**
     * результат
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * id студента кому принадлежит результат
     */
    @Basic
    @Column(name = "student_id")
    private Integer studentId;

    /**
     * семестр в котором студент получил этот результат
     */
    @Basic
    @Column(name = "semester")
    private Integer semester;

    /**
     * id предмета по которому студент получил этот результат
     */
    @Basic
    @Column(name = "subject_id")
    private Integer subjectId;

    /**
     * Конструктор класса Result, принимающий значения для всех полей.
     * @param id значение для поля "id".
     * @param name значение для поля "name".
     * @param studentId значение для поля "student_id".
     * @param semester значение для поля "semester".
     * @param subjectId значение для поля "subject_id".
     */
    public Result(int id, String name, Integer studentId, Integer semester, Integer subjectId) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.semester = semester;
        this.subjectId = subjectId;
    }

    /**
     * Конструктор класса Result, без параметров.
     */
    public Result() {
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
     * метод, получающий значение результата
     * @return name - значение результата
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, принимающий идентификатор записи
     * @param name - значение результата
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * метод, возвращающий id студента
     * @return studentId - id студента
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Метод, принимающий идентификатор студента
     * @param studentId - идентификатор студента
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Метод, возвращающий номер семестра
     * @return semester - номер семестра
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * Метод, принимающий номер семестра
     * @param semester - номер семестра
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * метод, возвращающий id предмета
     * @return subjectId - id предмета
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * Метод, принимающий идентификатор предмета
     * @param subjectId - идентификатор предмета
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
