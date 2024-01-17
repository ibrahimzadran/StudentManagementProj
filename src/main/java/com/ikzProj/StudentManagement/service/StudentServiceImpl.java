package com.ikzProj.StudentManagement.service;

import com.ikzProj.StudentManagement.entity.Student;
import com.ikzProj.StudentManagement.exception.ResourceNotFoundException;
import com.ikzProj.StudentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getStudents(){
        return (List<Student>)  studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student with id"+id+" not found"));
    }

    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudentById(Long id, Student student){
        Student existingStudent= getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setGender(student.getGender());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setStarted(student.getStarted());
        existingStudent.setGraduation(student.getGraduation());
        studentRepository.save(existingStudent);
        return existingStudent;

    }
}
