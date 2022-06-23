package com.miu.controller;

import com.miu.domain.Course;
import com.miu.domain.Student;
import com.miu.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/api/v1/students")
    public ResponseEntity<List<Student>> findAll(){
        var students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/api/v1/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/api/v1/students/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id){
        var updateStudent = studentService.update(student, id);
        return ResponseEntity.ok(updateStudent);
    }

    @PostMapping("/api/v1/students")
    public ResponseEntity<Student> create(@RequestBody Student student){
        student = studentService.save(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/api/v1/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/api/v2/students/{id}/courses")
    public ResponseEntity<List<Course>> findStudentCourse(@PathVariable Long id){
        var courses = studentService.getCoursesByStudentId(id);
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping(value = "/api/v2/students")
    public ResponseEntity<List<Student>> findStudentByMajor(@RequestParam String major){
        var students = studentService.getStudentsByMajor(major);
        return ResponseEntity.ok().body(students);
    }

}
