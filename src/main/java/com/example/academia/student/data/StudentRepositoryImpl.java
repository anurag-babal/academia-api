package com.example.academia.student.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
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
}
