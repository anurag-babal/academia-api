package com.example.academia.student.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentEntityDao extends JpaRepository<StudentEntity, Integer> {
    Page<StudentEntity> findAllByStudentCourseEntitiesCourseEntityCourseId(int courseId, Pageable pageable);

    Optional<StudentEntity> findFirstByGraduationYearOrderByIdDesc(int graduationYear);
}
