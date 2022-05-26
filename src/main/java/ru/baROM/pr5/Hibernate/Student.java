package ru.baROM.pr5.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "student")

public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column (nullable = false)
    private String name;
    private int mark;

    public Student() {
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student {id=" + id + ", name=" + name + ", mark=" + mark + "}";
    }
}
