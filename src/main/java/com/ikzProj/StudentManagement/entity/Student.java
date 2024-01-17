package com.ikzProj.StudentManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String course;
    private String email;
    private LocalDate started;
    private LocalDate graduation;
    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers=new HashSet<Teacher>();
    public Set<Teacher> getTeachers(){return teachers;}
    public void setTeachers(Set<Teacher>teachers){this.teachers=teachers;}

    public Student() {
    }

    public Student(String firstName, String lastName, Gender gender, String course, String email, LocalDate started, LocalDate graduation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.course = course;
        this.email = email;
        this.started = started ;
        this.graduation = graduation;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public LocalDate getGraduation() {
        return graduation;
    }

    public void setGraduation(LocalDate graduation) {
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", started=" + started +
                ", graduation=" + graduation +
                '}';
    }
}
