package com.miu.service.impls;

import com.miu.domain.Course;
import com.miu.domain.Student;
import com.miu.repository.StudentRepository;
import com.miu.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        return studentRepository.update(student,id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepository.findById(studentId).getCoursesTaken();
    }
}
