package com.example.academia.student;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentService;
import com.example.academia.student.dto.StudentAdmissionCreateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentMapper studentMapper;
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
    public ResponseDto getStudentsForCourseId(@PathVariable(name = "courseId") int courseId,
                                              Pageable pageable) {
        List<Student> students =
                studentService.getAllStudentsForCourseId(courseId, pageable).getContent();
        return ResponseBuilder.createListResponse(students.size(), students);
    }

    @PostMapping("/v1/students")
    public ResponseDto createStudentAdmission(
            @Valid @RequestBody StudentAdmissionCreateRequestDto dto) {
        Student student = studentMapper.mapToDomainStudent(dto);
        Student createdStudent = studentService.createStudentAdmission(student);
        return ResponseBuilder.createResponse(createdStudent);
    }
}
