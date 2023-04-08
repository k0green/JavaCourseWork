package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class EducationHours {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "Hours")
    private String hours;
    @Basic
    @Column(name = "GroupCode")
    private String groupCode;
    @Basic
    @Column(name = "Semestr")
    private String semestr;

    public EducationHours(int id, String hours, String groupCode, String semestr) {
        this.id = id;
        this.hours = hours;
        this.groupCode = groupCode;
        this.semestr = semestr;
    }

    public EducationHours() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationHours that = (EducationHours) o;
        return id == that.id && Objects.equals(hours, that.hours) && Objects.equals(groupCode, that.groupCode) && Objects.equals(semestr, that.semestr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hours, groupCode, semestr);
    }

    @Override
    public String toString() {
        return "EducationHours{" +
                "id=" + id +
                ", hours='" + hours + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", semestr='" + semestr + '\'' +
                '}';
    }
}
