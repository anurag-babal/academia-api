package com.example.academia.student.data;

import com.example.academia.course.domain.CourseRepository;
import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
    private final CourseRepository courseRepository;
    private final StudentEntityDao studentEntityDao;

    @Override
    public Student getStudentById(int id) {
        return mapToDomainStudent(getStudentEntityById(id));
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return mapToDomainStudents(studentEntityDao.findAll(pageable));
    }

    @Override
    public Page<Student> getAllStudentsForCourseId(int courseId, Pageable pageable) {
        return mapToDomainStudents(studentEntityDao.findAllByStudentCourseEntitiesCourseEntityCourseId(courseId, pageable));
    }

    @Override
    public Student createStudentAdmission(Student student) {
        StudentEntity studentEntity = mapToEntityStudent(student);
        StudentEntity savedStudentEntity = studentEntityDao.save(studentEntity);
        return mapToDomainStudent(savedStudentEntity);
    }

    @Override
    public Optional<Student> getLastStudentForGraduationYear(int graduationYear) {
        Optional<StudentEntity> studentEntity = studentEntityDao.findFirstByGraduationYearOrderByIdDesc(graduationYear);
        if (studentEntity.isPresent()) return Optional.of(mapToDomainStudent(studentEntity.get()));
        return Optional.empty();
    }

    private StudentEntity getStudentEntityById(int id) {
        return studentEntityDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

    private Student mapToDomainStudent(StudentEntity studentEntity) {
        return Student.builder()
                .id(studentEntity.getId())
                .rollNumber(studentEntity.getRollNumber())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .email(studentEntity.getEmail())
                .photographPath(studentEntity.getPhotographPath())
                .cgpa(studentEntity.getCgpa().doubleValue())
                .totalCredits(studentEntity.getTotalCredits())
                .graduationYear(studentEntity.getGraduationYear())
                .domainId(studentEntity.getDomainEntity().getId())
                .build();
    }

    private Page<Student> mapToDomainStudents(Page<StudentEntity> studentEntities) {
        return studentEntities.map(this::mapToDomainStudent);
    }

    private StudentEntity mapToEntityStudent(Student student) {
        return StudentEntity.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .photographPath(student.getPhotographPath())
                .graduationYear(student.getGraduationYear())
                .rollNumber(student.getRollNumber())
                .domainEntity(courseRepository.getDomainEntityById(student.getDomainId()))
                .build();
    }
}
