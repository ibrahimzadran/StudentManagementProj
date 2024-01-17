package com.ikzProj.StudentManagement.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    private String firstName;
    private String lastName;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_teacher",
            joinColumns = {@JoinColumn(name = "teacherid")},
            inverseJoinColumns={@JoinColumn(name = "id")})
    private Set<Student>students=new HashSet<Student>();
    public Set<Student>getStudents(){return students;}
    public void setStudents(Set<Student>students){this.students=students;}

    public Teacher(){}



    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
