package com.example.javacoursework.models;

import java.util.List;

/**
 * <strong> класс описывающий модель ведомости </strong>
 *
 * @author Egor
 * @version 1.0
 */
public class DocModel {
    /**
     * Список студентов
     */
    private List<StudentModel> students;
    /**
     * Ступень получения образования
     */
    private String step;
    /**
     * Форма обучения, например, "очная" или "заочная".
     */
    private String form;
    /**
     * Текущий семестр
     */
    private String Semester;
    /**
     * Номер группы студентов.
     */
    private String groupName;
    /**
     * Тип аттестации, например, "экзамен" или "зачет".
     */
    private String attestationType;
    /**
     * Название предмета, по которому проходит аттестация
     */
    private String subject;
    /**
     * ФИО преподавателя
     */
    private String professor;
    /**
     * Год аттестации
     */
    private String year;
    /**
     * Название факультета
     */
    private String faculty;
    /**
     * Номер курса
     */
    private Integer course;
    /**
     * Количество часов, отведенных на занятия.
     */
    private String hours;
    /**
     * Дата проведения аттестации.
     */
    private String date;
    /**
     * Путь к файлу
     */
    private String path;

    /**
     * Конструктор без параметров для создания объекта модели документа.
     */
    public DocModel(){

    };

    /**
     * Конструктор для создания объекта модели документа.
     * @param students Список студентов, относящихся к данной модели.
     * @param step Шаг в учебном процессе, например, "лекция" или "практика".
     * @param form Форма обучения, например, "очная" или "заочная".
     * @param semester Семестр, в котором проходит занятие.
     * @param groupName Название группы студентов.
     * @param attestationType Тип аттестации, например, "экзамен" или "зачет".
     * @param subject Название предмета, по которому проходит занятие.
     * @param professor ФИО преподавателя, ведущего занятие.
     * @param year Год, в котором проходит занятие.
     * @param faculty Название факультета, на котором проходит занятие.
     * @param course Номер курса, на котором проходит занятие.
     * @param hours Количество часов, отведенных на занятие.
     * @param date Дата проведения занятия.
     * @param path Путь к файлу, связанному с занятием.
     */
    public DocModel(List<StudentModel> students, String step, String form, String semester, String groupName, String attestationType, String subject, String professor, String year, String faculty, Integer course, String hours, String date, String path) {
        this.students = students;
        this.step = step;
        this.form = form;
        Semester = semester;
        this.groupName = groupName;
        this.attestationType = attestationType;
        this.subject = subject;
        this.professor = professor;
        this.year = year;
        this.faculty = faculty;
        this.course = course;
        this.hours = hours;
        this.date = date;
        this.path = path;
    }

    /**
     * Получает список студентов, относящихся к данной модели.
     * @return Список студентов, относящихся к данной модели.
     */
    public List<StudentModel> getStudents() {
        return students;
    }

    /**
     * Устанавливает список студентов, относящихся к данной модели.
     * @param students Список студентов, относящихся к данной модели.
     */
    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    /**
     * Получает название группы студентов.
     * @return Название группы студентов.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Устанавливает название группы студентов.
     * @param groupName Название группы студентов.
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Получает тип аттестации.
     * @return Тип аттестации.
     */
    public String getAttestationType() {
        return attestationType;
    }

    /**
     * Устанавливает тип аттестации.
     * @param attestationType Тип аттестации.
     */
    public void setAttestationType(String attestationType) {
        this.attestationType = attestationType;
    }

    /**
     * Получает название предмета, по которому проходит занятие.
     * @return Название предмета, по которому проходит занятие.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Устанавливает название предмета, по которому проходит занятие.
     * @param subject Название предмета, по которому проходит занятие.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Получает ФИО преподавателя
     * @return ФИО преподавателя
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * Устанавливает ФИО преподавателя.
     * @param professor ФИО преподавателя.
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * Получает шаг учебного процесса.
     * @return Шаг учебного процесса.
     */
    public String getStep() {
        return step;
    }

    /**
     * Устанавливает шаг учебного процесса.
     * @param step Шаг учебного процесса.
     */
    public void setStep(String step) {
        this.step = step;
    }

    /**
     * Получает форму обучения.
     * @return Форма обучения.
     */
    public String getForm() {
        return form;
    }

    /**
     * Устанавливает форму обучения.
     * @param form Форма обучения.
     */
    public void setForm(String form) {
        this.form = form;
    }

    /**
     * Возвращает номер семестра.
     * @return Номер семестра.
     */
    public String getSemester() {
        return Semester;
    }

    /**
     * Устанавливает номер семестра.
     * @param semester Номер семестра.
     */
    public void setSemester(String semester) {
        Semester = semester;
    }

    /**
     * Возвращает год обучения.
     * @return Год обучения.
     */
    public String getYear() {
        return year;
    }

    /**
     * Устанавливает год обучения.
     * @param year Год обучения.
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Возвращает факультет.
     * @return Факультет.
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Устанавливает факультет.
     * @param faculty Факультет.
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Возвращает номер курса.
     * @return Номер курса.
     */
    public Integer getCourse() {
        return course;
    }

    /**
     * Устанавливает номер курса.
     * @param course Номер курса.
     */
    public void setCourse(Integer course) {
        this.course = course;
    }

    /**
     * Возвращает количество часов.
     * @return Количество часов.
     */
    public String getHours() {
        return hours;
    }

    /**
     * Устанавливает количество часов.
     * @param hours Количество часов.
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * Возвращает дату.
     * @return Дата.
     */
    public String getDate() {
        return date;
    }

    /**
     * Устанавливает дату.
     * @param date Дата.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Возвращает путь.
     * @return Путь.
     */
    public String getPath() {
        return path;
    }

    /**
     * Устанавливает путь.
     * @param path Путь.
     */
    public void setPath(String path) {
        this.path = path;
    }

}
