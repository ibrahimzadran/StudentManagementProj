package com.ikzProj.StudentManagement.web;

import com.ikzProj.StudentManagement.entity.Student;
import com.ikzProj.StudentManagement.entity.Teacher;
import com.ikzProj.StudentManagement.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getTeacher(){
        return new ResponseEntity<>(teacherService.getTeacher(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id){
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    private ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.addTeacher(teacher),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> deleteTeacherById(@PathVariable Long id){
        teacherService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacherById(@PathVariable Long id, @RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.updateTeacherById(id,teacher),HttpStatus.ACCEPTED);
    }

}
