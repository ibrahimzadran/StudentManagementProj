package com.ikzProj.StudentManagement.service;

import com.ikzProj.StudentManagement.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacher();

    Teacher getTeacherById(Long id);

    Teacher addTeacher(Teacher teacher);

    void deleteById(Long id);

    Teacher updateTeacherById(Long id, Teacher teacher);

}
