package com.example.academia.course.domain;

import com.example.academia.course.data.entity.DomainEntity;
import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.course.domain.model.Specialisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseRepository {
    Course getCourseById(int id);

    Page<Course> getCoursesByFacultyId(int facultyId, Pageable pageable);

    List<CourseSchedule> getCourseScheduleByCourseId(int courseId);

    List<Specialisation> getSpecialisationsByCourseId(int courseId);

    List<Domain> getAllDomains();

    Domain getDomainById(int id);

    DomainEntity getDomainEntityById(int id);
}
