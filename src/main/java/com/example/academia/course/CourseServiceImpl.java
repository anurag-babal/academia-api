package com.example.academia.course;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.academia.course.domain.CourseRepository;
import com.example.academia.course.domain.CourseService;
import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.course.domain.model.Specialisation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Page<Course> getAllCoursesForFacultyId(int facultyId, Pageable pageable) {
        return courseRepository.getCoursesByFacultyId(facultyId, pageable);
    }

    @Override
    public List<CourseSchedule> getCourseSchedulesByCourseId(int id) {
        return courseRepository.getCourseScheduleByCourseId(id);
    }

    @Override
    public List<CourseSchedule> getCourseSchedulesByFacultyId(int facultyId) {
        List<Course> courses = getAllCoursesForFacultyId(facultyId, null).getContent();
        List<CourseSchedule> courseSchedules = courses.stream()
                .flatMap(course -> getCourseSchedulesByCourseId(course.getCourseId()).stream()).toList();
        return courseSchedules;
    }
    
    @Override
    public List<Specialisation> getSpecialisationsByCourseId(int courseId) {
        return courseRepository.getSpecialisationsByCourseId(courseId);
    }

    @Override
    public List<Domain> getAllDomains() {
        return courseRepository.getAllDomains();
    }

    @Override
    public Domain getDomainById(int id) {
        return courseRepository.getDomainById(id);
    }
}
