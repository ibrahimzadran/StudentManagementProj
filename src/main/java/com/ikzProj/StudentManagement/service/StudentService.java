package com.ikzProj.StudentManagement.service;

import com.ikzProj.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudentById(Long id);

    Student addStudent(Student student);

    void deleteById(Long id);

    Student updateStudentById(Long id, Student student);

}
