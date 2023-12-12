package com.example.academia.course.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.course.domain.model.Specialisation;

public interface CourseRepository {
    public Course getCourseById(int id);
    public Page<Course> getCoursesByFacultyId(int facultyId, Pageable pageable);
    public List<CourseSchedule> getCourseScheduleByCourseId(int courseId);
    public List<Specialisation> getSpecialisationsByCourseId(int courseId);
    public List<Domain> getAllDomains();
    public Domain getDomainById(int id);
}
