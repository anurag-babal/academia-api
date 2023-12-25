package com.example.academia.student.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    public Page<Student> getAllStudents(Pageable pageable);
    public Page<Student> getAllStudentsForCourseId(int id, Pageable pageable);
    public Student getStudentById(int id);
    public Student createStudentAdmission(Student student);
}
