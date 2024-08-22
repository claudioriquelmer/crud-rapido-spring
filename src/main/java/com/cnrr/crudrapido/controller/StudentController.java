package com.cnrr.crudrapido.controller;

import com.cnrr.crudrapido.entity.Student;
import com.cnrr.crudrapido.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }


}
