package com.miu.service;

import com.miu.domain.Course;
import com.miu.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    Student update(Student student, Long id);

    void remove(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);
}
