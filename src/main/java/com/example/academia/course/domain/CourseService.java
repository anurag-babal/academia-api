package com.example.academia.course.domain;

import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.course.domain.model.Specialisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Course getCourseById(int id);

    List<Domain> getAllDomains();

    Page<Course> getAllCoursesForFacultyId(int facultyId, Pageable pageable);

    List<CourseSchedule> getCourseSchedulesByCourseId(int id);

    List<CourseSchedule> getCourseSchedulesByFacultyId(int facultyId);

    List<Specialisation> getSpecialisationsByCourseId(int courseId);

    Domain getDomainById(int id);
}
