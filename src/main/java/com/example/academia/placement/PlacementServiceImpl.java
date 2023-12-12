package com.example.academia.placement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.academia.placement.domain.PlacementRepository;
import com.example.academia.placement.domain.PlacementService;
import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;
import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlacementServiceImpl implements PlacementService {
    private final PlacementRepository placementRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<Organisation> getAllOrganisations() {
        return placementRepository.getAllOrganisations();
    }

    @Override
    public List<String> getAllYears() {
        List<PlacementStudent> students = placementRepository.getAllPlacementStudents();
        return students.stream().map(student -> student.getDate().split("-")[0]).distinct().toList();
    }

    @Override
    public List<AlumniOrganisation> getAllAlumniOrganisationsForOrganisationId(int id) {
        return placementRepository.getAllAlumnisForOrganisation(id);
    }

    @Override
    public Alumni getAlumniById(int id) {
        return placementRepository.getAlumniById(id);
    }

    @Override
    public Organisation getOrganisationByPlacementId(int placementId) {
        return placementRepository.getOrganistationByPlacementId(placementId);
    }

    @Override
    public List<PlacementStudent> getPlacementHistory(int organisationId, int domainId, String year) {
        List<PlacementStudent> placementStudentsWithDomain = new ArrayList<>();
        List<Student> studentsUpdated;
        List<PlacementStudent> placementStudentsWithYear;
        List<PlacementStudent> result;
        List<Student> students = studentRepository.getAllStudents(Pageable.ofSize(100)).toList();
        if (domainId == 0) {
            // placementStudentsWithDomain = placementRepository.getAllPlacementStudents();
            studentsUpdated = students;
        } else {
            // placementStudentsWithDomain = placementRepository.getAllPlacementStudentsForDomainId(domainId);
            studentsUpdated = students.stream().filter(item -> item.getDomainId() == domainId).toList();
        }
        for (Student student : studentsUpdated) {
            placementStudentsWithDomain.addAll(placementRepository.getAllPlacementStudentsForStudentId(student.getId()));
        }
        if (!year.isEmpty()) {
            placementStudentsWithYear = placementStudentsWithDomain.stream()
                    .filter(item -> item.getDate().split("-")[0].equals(year)).toList();
        } else {
            placementStudentsWithYear = placementStudentsWithDomain;
        }
        if (organisationId != 0) {
            result = placementStudentsWithYear.stream()
                    .filter(item -> getOrganisationByPlacementId(item.getPlacementId()).getId() == organisationId)
                    .toList();
        } else {
            result = placementStudentsWithYear;
        }
        return result;
    }
}
