package com.example.academia.student.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentRepository {
    Page<Student> getAllStudents(Pageable pageable);

    Student getStudentById(int id);

    Page<Student> getAllStudentsForCourseId(int courseId, Pageable pageable);

    Student createStudentAdmission(Student student);

    Optional<Student> getLastStudentForGraduationYear(int graduationYear);
}
