package com.example.academia.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentRepository;
import com.example.academia.student.domain.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    
    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.getAllStudents(pageable);
    }

    @Override
    public Page<Student> getAllStudentsForCourseId(int id, Pageable pageable) {
        return studentRepository.getAllStudentsForCourseId(id, pageable);
    }
}
