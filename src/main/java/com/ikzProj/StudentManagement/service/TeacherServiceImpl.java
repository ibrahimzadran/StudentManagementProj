package com.ikzProj.StudentManagement.service;

import com.ikzProj.StudentManagement.entity.Teacher;
import com.ikzProj.StudentManagement.exception.ResourceNotFoundException;
import com.ikzProj.StudentManagement.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public List<Teacher> getTeacher() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher with id"+id+" not found"));

    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher updateTeacherById(Long id, Teacher teacher) {
        Teacher existingTeacher= getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        teacherRepository.save(existingTeacher);
        return existingTeacher;
    }
}
