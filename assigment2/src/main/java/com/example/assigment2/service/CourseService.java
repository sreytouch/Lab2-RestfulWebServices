package com.miu.service;

import com.miu.domain.Course;
import com.miu.domain.Student;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    Course save(Course course);

    Course update(Course course, Long id);

    void remove(Long id);
}
