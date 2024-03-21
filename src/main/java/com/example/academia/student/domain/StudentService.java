package com.example.academia.student.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);

    Page<Student> getAllStudentsForCourseId(int id, Pageable pageable);

    Student getStudentById(int id);

    Student createStudentAdmission(Student student);
}
