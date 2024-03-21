package com.example.academia.course.data;

import com.example.academia.course.data.dao.CourseEntityDao;
import com.example.academia.course.data.dao.CourseScheduleEntityDao;
import com.example.academia.course.data.dao.DomainEntityDao;
import com.example.academia.course.data.dao.SpecialisationCourseEntityDao;
import com.example.academia.course.data.entity.*;
import com.example.academia.course.domain.CourseRepository;
import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Domain;
import com.example.academia.course.domain.model.Specialisation;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseRpositoryImpl implements CourseRepository {
    private final CourseEntityDao courseDao;
    private final DomainEntityDao domainEntityDao;
    private final CourseScheduleEntityDao courseScheduleDao;
    private final SpecialisationCourseEntityDao specialisationCourseEntityDao;

    @Override
    public Course getCourseById(int id) {
        return mapToDomainCourse(getCourseEntityById(id));
    }

    @Override
    public Page<Course> getCoursesByFacultyId(int facultyId, Pageable pageable) {
        return mapToDomainCoursesPage(courseDao.findAllByEmployeeEntityEmployeeId(facultyId, pageable));
    }

    @Override
    public List<CourseSchedule> getCourseScheduleByCourseId(int courseId) {
        return mapToDomainCourseSchedules(courseScheduleDao.findAllByCourseEntityCourseId(courseId));
    }

    @Override
    public List<Specialisation> getSpecialisationsByCourseId(int courseId) {
        List<SpecialisationCourseEntity> specialisationCourseEntities = specialisationCourseEntityDao
                .findAllByCourseEntityCourseId(courseId);
        List<SpecialisationEntity> specialisationEntities = specialisationCourseEntities.stream()
                .map(entity -> entity.getSpecialisationEntity()).toList();
        return mapToDomainSpecialisations(specialisationEntities);
    }

    @Override
    public List<Domain> getAllDomains() {
        return mapToDomains(domainEntityDao.findAll());
    }

    @Override
    public Domain getDomainById(int id) {
        return mapToDomainDomain(getDomainEntityById(id));
    }

    @Override
    public DomainEntity getDomainEntityById(int id) {
        return domainEntityDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Domain not found with id: " + id));
    }

    private CourseEntity getCourseEntityById(int id) {
        return courseDao.findById(id).orElseThrow(() -> new EntityNotFoundException("No courses found with id: " + id));
    }

    private Course mapToDomainCourse(CourseEntity courseEntity) {
        return Course.builder()
                .courseId(courseEntity.getCourseId())
                .courseCode(courseEntity.getCourseCode())
                .name(courseEntity.getName())
                .description(courseEntity.getDescription())
                .year(courseEntity.getYear())
                .term(courseEntity.getTerm())
                .credits(courseEntity.getCredits())
                .capacity(courseEntity.getCapacity())
                .build();
    }

    private Page<Course> mapToDomainCoursesPage(Page<CourseEntity> courseEntities) {
        return courseEntities.map(this::mapToDomainCourse);
    }

    private CourseSchedule mapToDomainCourseSchedule(CourseScheduleEntity courseScheduleEntity) {
        return CourseSchedule.builder()
                .id(courseScheduleEntity.getId())
                .time(courseScheduleEntity.getTime())
                .day(courseScheduleEntity.getDay())
                .room(courseScheduleEntity.getRoom())
                .building(courseScheduleEntity.getBuilding())
                .build();
    }

    private List<CourseSchedule> mapToDomainCourseSchedules(List<CourseScheduleEntity> courseScheduleEntities) {
        return courseScheduleEntities.stream().map(this::mapToDomainCourseSchedule).toList();
    }

    private Specialisation mapToDomainSpecialisation(SpecialisationEntity specialisationEntity) {
        return Specialisation.builder()
                .id(specialisationEntity.getId())
                .code(specialisationEntity.getCode())
                .name(specialisationEntity.getName())
                .description(specialisationEntity.getDescription())
                .year(specialisationEntity.getYear())
                .creditsRequired(specialisationEntity.getCreditsRequired())
                .build();
    }

    private List<Specialisation> mapToDomainSpecialisations(List<SpecialisationEntity> specialisationEntities) {
        return specialisationEntities.stream().map(this::mapToDomainSpecialisation).toList();
    }

    private Domain mapToDomainDomain(DomainEntity entity) {
        return Domain.builder()
                .id(entity.getId())
                .program(entity.getProgram())
                .batch(entity.getBatch())
                .capacity(entity.getCapacity())
                .qualification(entity.getQualification())
                .build();
    }

    private List<Domain> mapToDomains(List<DomainEntity> entities) {
        return entities.stream().map(this::mapToDomainDomain).toList();
    }
}
