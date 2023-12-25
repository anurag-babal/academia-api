package com.example.academia.student;

import org.springframework.stereotype.Component;

import com.example.academia.student.domain.Student;
import com.example.academia.student.dto.StudentAdmissionCreateRequestDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentMapper {
  public Student mapToDomainStudent(StudentAdmissionCreateRequestDto dto) {
    return Student.builder()
        .firstName(dto.getFname())
        .lastName(dto.getLname())
        .email(dto.getEmail())
        .domainId(dto.getDomainId())
        .photographPath(dto.getPhotoPath())
        .graduationYear(dto.getGraduationYear())
        .build();
  }
}
