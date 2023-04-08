package com.example.javacoursework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Students", schema = "javacw")
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name="bookNumber")
    private String bookNumber;
    @Basic
    @Column(name = "groupId")
    private Integer groupId;

    public Students(int id, String fullName, String bookNumber, Integer groupId) {
        this.id = id;
        this.fullName = fullName;
        this.bookNumber = bookNumber;
        this.groupId = groupId;
    }

    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && Objects.equals(fullName, students.fullName) && Objects.equals(bookNumber, students.bookNumber) && Objects.equals(groupId, students.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, bookNumber, groupId);
    }

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
