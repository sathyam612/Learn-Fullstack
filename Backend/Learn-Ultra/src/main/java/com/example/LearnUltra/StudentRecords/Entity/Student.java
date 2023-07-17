package com.example.LearnUltra.StudentRecords.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name="name")
    private String Name;

    @Column(name="email")
    private String Email;

    @Column(name="standard")
    private Integer Standard;

    @Column(name="section")
    private String Section;

    @Column(name="date_of_birth")
    private LocalDate DOB;

    @JsonManagedReference
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "usn_id")
    private Subjects subjects;

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Student() {
    }

    public Student(Long id, String name, String email, Integer standard, String section, LocalDate DOB, Subjects subjects) {
        Id = id;
        Name = name;
        Email = email;
        Standard = standard;
        Section = section;
        this.DOB = DOB;
    }

    public Student(String name, String email, Integer standard, String section, LocalDate DOB) {
        Name = name;
        Email = email;
        Standard = standard;
        Section = section;
        this.DOB = DOB;
    }

    public Student(String name, String email, Integer standard, String section, LocalDate DOB, Subjects subjects) {
        Name = name;
        Email = email;
        Standard = standard;
        Section = section;
        this.DOB = DOB;
        this.subjects = subjects;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getStandard() {
        return Standard;
    }

    public void setStandard(Integer standard) {
        Standard = standard;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Standard=" + Standard +
                ", Section='" + Section + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
