package com.example.javacoursework.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Objects;

public class StudentModel {
    /**
     * ID студента
    */
    private int id;
    /**
     * Полное имя студента
     */
    private String fullName;
    /**
     * Номер зачетной книжки студента
     */
    private String bookNumber;
    /**
     * ID группы студента
     */
    private Integer groupId;
    /**
     * Результат студента
     */
    private String result;

    /**
     * Конструктор класса, принимающий значения всех полей
     * @param id - идентификатор записи
     * @param fullName - имя студента
     * @param bookNumber - номер зачетной книжки
     * @param groupId - id группы
     * @param result - результат
     */
    public StudentModel(int id, String fullName, String bookNumber, Integer groupId, String result) {
        this.id = id;
        this.fullName = fullName;
        this.bookNumber = bookNumber;
        this.groupId = groupId;
        this.result = result;
    }

    /**
     * Конструктор класса без параметров
     */
    public StudentModel() {
    }

    /**
     * Возвращает идентификатор студента.
     * @return идентификатор студента
     */
    public int getId() {
        return id;
    }
    /**
     * Устанавливает идентификатор студента.
     * @param id идентификатор студента
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Возвращает полное имя студента.
     * @return полное имя студента
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Устанавливает полное имя студента.
     * @param fullName полное имя студента
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * Возвращает номер зачетной книжки студента.
     * @return номер зачетной книжки студента
     */
    public String getBookNumber() {
        return bookNumber;
    }
    /**
     * Устанавливает номер зачетной книжки студента.
     * @param bookNumber номер зачетной книжки студента
     */
    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
    /**
     * Возвращает идентификатор группы, в которой учится студент.
     * @return идентификатор группы
     */
    public Integer getGroupId() {
        return groupId;
    }
    /**
     * Устанавливает идентификатор группы, в которой учится студент.
     * @param groupId идентификатор группы
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    /**
     * Возвращает результаты студента.
     * @return результаты студента
     */
    public String getResult() {
        return result;
    }
    /**
     * Устанавливает результаты студента.
     * @param result результаты студента
     */
    public void setResult(String result) {
        this.result = result;
    }
}
