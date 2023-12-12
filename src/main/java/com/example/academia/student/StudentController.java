package com.example.academia.student;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/v1/students")
    public ResponseDto getAllStudents(Pageable pageable) {
        List<Student> students = studentService.getAllStudents(pageable).getContent();
        return ResponseBuilder.createListResponse(students.size(), students);
    }

    @GetMapping("/v1/students/{id}")
    public ResponseDto getStudentById(@PathVariable(name = "id") int id) {
        Student student = studentService.getStudentById(id);
        return ResponseBuilder.createResponse(student);
    }

    @GetMapping("/v1/students/courses/{courseId}")
    public ResponseDto getStudentsForCourseId(
            @PathVariable(name = "courseId") int courseId,
            Pageable pageable) {
        List<Student> students = studentService.getAllStudentsForCourseId(courseId, pageable).getContent();
        return ResponseBuilder.createListResponse(students.size(), students);
    }
}
