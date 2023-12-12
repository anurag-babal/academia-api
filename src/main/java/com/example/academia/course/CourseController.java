package com.example.academia.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.course.domain.CourseService;
import com.example.academia.course.domain.model.Course;
import com.example.academia.course.dto.CourseScheduleDto;
import com.example.academia.employee.domain.EmployeeService;
import com.example.academia.employee.domain.model.Employee;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final EmployeeService employeeService;

    @GetMapping("/v1/courses/{id}")
    public ResponseDto getCourseById(@PathVariable(name = "id") int id) {
        Course course = courseService.getCourseById(id);
        return ResponseBuilder.createResponse(course);
    }

    @GetMapping("/v1/employees/{id}/courses")
    public ResponseDto getAllCoursesByFacultyId(
            @PathVariable(name = "id") int facultyId,
            Pageable pageable) {
        List<Course> courses = courseService.getAllCoursesForFacultyId(facultyId, pageable).getContent();
        return ResponseBuilder.createListResponse(courses.size(), courses);
    }

    @GetMapping("/v1/employees/{id}/schedule")
    public ResponseDto getCourseScdedulesForFaculty(@PathVariable(name = "id") int id) {
        List<Course> courses = courseService.getAllCoursesForFacultyId(id, null).getContent();
        List<CourseScheduleDto> courseSchedulesDto = new ArrayList<>();
        Employee faculty = employeeService.getEmployeeById(id);
        courses.forEach(course -> {
            courseSchedulesDto.add(CourseScheduleDto.builder()
                    .faculty(faculty)
                    .course(course)
                    .specialisations(courseService.getSpecialisationsByCourseId(course.getCourseId()))
                    .schedules(courseService.getCourseSchedulesByCourseId(course.getCourseId()))
                    .build());
        });
        return ResponseBuilder.createListResponse(courseSchedulesDto.size(), courseSchedulesDto);
    }
}
