package com.example.academia.course.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.course.domain.model.Specialisation;

public interface CourseService {
    public Course getCourseById(int id);
    public List<Domain> getAllDomains();
    public Page<Course> getAllCoursesForFacultyId(int facultyId, Pageable pageable);
    public List<CourseSchedule> getCourseSchedulesByCourseId(int id);
    public List<CourseSchedule> getCourseSchedulesByFacultyId(int facultyId);
    public List<Specialisation> getSpecialisationsByCourseId(int courseId);
    public Domain getDomainById(int id);
}
