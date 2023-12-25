package com.example.academia.student.domain;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRepository {
    public Page<Student> getAllStudents(Pageable pageable);
    public Student getStudentById(int id);
    public Page<Student> getAllStudentsForCourseId(int courseId, Pageable pageable);
    public Student createStudentAdmission(Student student);
    public Optional<Student> getLastStudentForGraduationYear(int graduationYear);
}
