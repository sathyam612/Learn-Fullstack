package com.example.LearnUltra.StudentRecords.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subjects")
public class Subjects implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "english")
    private Integer english;

    @Column(name = "spanish")
    private Integer spanish;

    @Column(name = "environmental_study")
    private Integer environmentalStudy;

    @Column(name = "polity")
    private Integer polity;

    @Column(name="sociology")
    private Integer sociology;

    @Column(name = "geography")
    private Integer geography;

    @Column(name="student_grade")
    private String studentGrade;

    @JsonBackReference
    @OneToOne(mappedBy = "subjects",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Student student;

    public Subjects(Long id, Integer english, Integer spanish, Integer environmentalStudy, Integer polity, Integer sociology, Integer geography) {
        this.id = id;
        this.english = english;
        this.spanish = spanish;
        this.environmentalStudy = environmentalStudy;
        this.polity = polity;
        this.sociology = sociology;
        this.geography = geography;
    }

    public Subjects(Integer english, Integer spanish, Integer environmentalStudy, Integer polity, Integer sociology, Integer geography) {
        this.english = english;
        this.spanish = spanish;
        this.environmentalStudy = environmentalStudy;
        this.polity = polity;
        this.sociology = sociology;
        this.geography = geography;
    }

    public Subjects() {
    }

    public Subjects(Long id, Integer english, Integer spanish, Integer environmentalStudy, Integer polity, Integer sociology, Integer geography, String studentGrade, Student student) {
        this.id = id;
        this.english = english;
        this.spanish = spanish;
        this.environmentalStudy = environmentalStudy;
        this.polity = polity;
        this.sociology = sociology;
        this.geography = geography;
        this.studentGrade = studentGrade;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        if(english<=100) {
            this.english = english;
        }
    }

    public Integer getSpanish() {
        return spanish;
    }

    public void setSpanish(Integer spanish) {
        if(spanish<=100){
            this.spanish = spanish;}
    }

    public Integer getEnvironmentalStudy() {
        return environmentalStudy;
    }

    public void setEnvironmentalStudy(Integer environmentalStudy) {
        if(environmentalStudy<=100){
            this.environmentalStudy = environmentalStudy;}
    }

    public Integer getPolity() {
        return polity;
    }

    public void setPolity(Integer polity) {
        if(polity<=100){
            this.polity = polity;}
    }

    public Integer getSociology() {
        return sociology;
    }

    public void setSociology(Integer sociology) {
        if(sociology<=100){
            this.sociology = sociology;}
    }

    public Integer getGeography() {
        return geography;
    }

    public void setGeography(Integer geography) {
        if(geography<=100){
            this.geography = geography;}
    }

    {
        if (english == null) {
            english = 0;
        }
        if (spanish == null) {
            spanish = 0;
        }
        if (polity == null) {
            polity = 0;
        }
        if (environmentalStudy == null) {
            environmentalStudy = 0;
        }
        if (geography == null) {
            geography = 0;
        }
        if (sociology == null) {
            sociology = 0;
        }
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade=studentGrade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", english=" + english +
                ", spanish=" + spanish +
                ", environmentalStudy=" + environmentalStudy +
                ", polity=" + polity +
                ", sociology=" + sociology +
                ", geography=" + geography +
                ", studentGrade='" + studentGrade + '\'' +
                ", student=" + student +
                '}';
    }
}
