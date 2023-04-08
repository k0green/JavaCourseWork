package com.example.javacoursework.models;

import com.example.javacoursework.entity.Students;

import java.time.Month;
import java.util.List;

public class DocModel {
    private List<Students> students;
    private String step;
    private String form;
    private String Semester;
    private String groupName;
    private String attestationType;
    private String subject;
    private String professor;
/*    private int day;
    private Month month;*/
    private String year;
    private String faculty;
    private Integer course;
    private String hours;
    private String date;
    private String path;


    public DocModel(){

    };

    public DocModel(List<Students> students, String step, String form, String semester, String groupName, String attestationType, String subject, String professor, String year, String faculty, Integer course, String hours, String date, String path) {
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

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAttestationType() {
        return attestationType;
    }

    public void setAttestationType(String attestationType) {
        this.attestationType = attestationType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

/*    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }*/

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocModel docModel = (DocModel) o;
        return day == docModel.day && Objects.equals(students, docModel.students) && Objects.equals(groupName, docModel.groupName) && Objects.equals(attestationType, docModel.attestationType) && Objects.equals(subject, docModel.subject) && Objects.equals(professor, docModel.professor) && month == docModel.month;
    }*/

/*    @Override
    public int hashCode() {
        return Objects.hash(students, groupName, attestationType, subject, professor, day, month);
    }
*/

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

/*    @Override
    public String toString() {
        return "DocModel{" +
                "students=" + students +
                ", step='" + step + '\'' +
                ", form='" + form + '\'' +
                ", Semester='" + Semester + '\'' +
                ", groupName='" + groupName + '\'' +
                ", attestationType='" + attestationType + '\'' +
                ", subject='" + subject + '\'' +
                ", professor='" + professor + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year='" + year + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", hours='" + hours + '\'' +
                '}';
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
