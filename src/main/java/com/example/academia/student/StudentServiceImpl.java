package com.example.academia.student;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.academia.course.domain.CourseRepository;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentRepository;
import com.example.academia.student.domain.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  private final CourseRepository courseRepository;
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

  @Override
  public Student createStudentAdmission(Student student) {
    int studentNumber = 1;
    int graduationYear = student.getGraduationYear();
    Domain domain = courseRepository.getDomainById(student.getDomainId());
    Optional<Student> st = studentRepository.getLastStudentForGraduationYear(graduationYear);

    if (st.isPresent())
      studentNumber = Integer.parseInt(st.get().getRollNumber().substring(6)) + 1;

    student.setRollNumber(generateRollNumber(studentNumber, graduationYear, domain));
    return studentRepository.createStudentAdmission(student);
  }

  private String generateRollNumber(int studentNumber, int graduationYear, Domain domain) {
    int courseDuration = 2;
    String rollNumberTemplate;
    switch (domain.getProgram()) {
      case "IM.Tech":
        rollNumberTemplate = "IMT%d%03d";
        courseDuration = 5;
        break;
      case "M.Tech":
        rollNumberTemplate = "MT%d%03d";
        break;
      default:
        rollNumberTemplate = "MS%d%03d";
        courseDuration = 3;
        break;
    }
    return String.format(rollNumberTemplate, graduationYear - courseDuration, studentNumber);
  }
}
