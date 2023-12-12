package com.example.academia.placement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.course.domain.CourseService;
import com.example.academia.placement.domain.PlacementService;
import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;
import com.example.academia.placement.dto.PlacementDetailsDto;
import com.example.academia.placement.dto.PlacementHistoryReqDto;
import com.example.academia.placement.dto.PlacementStudentHistoryDto;
import com.example.academia.placement.dto.WorkingAlumniDto;
import com.example.academia.student.domain.Student;
import com.example.academia.student.domain.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlacementController {
    private final PlacementService placementService;
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping("/placements/organisations/{id}/alumni")
    private ResponseDto getAllAlumniForOrganistation(@PathVariable(name = "id") int id) {
        List<AlumniOrganisation> alumniOrganisations = placementService.getAllAlumniOrganisationsForOrganisationId(id);
        List<WorkingAlumniDto> response = new ArrayList<>();
        for (AlumniOrganisation alumniOrganisation : alumniOrganisations) {
            Alumni alumni = placementService.getAlumniById(alumniOrganisation.getAlumniId());
            Student student = studentService.getStudentById(alumni.getStudentId());
            response.add(WorkingAlumniDto.builder()
                    .name(student.getFirstName() + " " + student.getLastName())
                    .position(alumniOrganisation.getPosition())
                    .joiningDate(alumniOrganisation.getJoiningDate().toString())
                    .email(alumni.getEmail())
                    .build());
        }
        return ResponseBuilder.createResponse(response);
    }

    @PostMapping("/placements/history")
    private ResponseDto getPlacementHistory(@RequestBody PlacementHistoryReqDto dto) {
        List<PlacementStudentHistoryDto> response = new ArrayList<>();
        List<PlacementStudent> placementStudents = placementService.getPlacementHistory(dto.getOrganisation(),
                dto.getDomain(), dto.getYear());
        for (PlacementStudent placementStudent : placementStudents) {
            Student student = studentService.getStudentById(placementStudent.getStudentId());
            Organisation organisation = placementService.getOrganisationByPlacementId(placementStudent.getPlacementId());
            response.add(PlacementStudentHistoryDto.builder()
                    .studentName(student.getFirstName() + " " + student.getLastName())
                    .email(student.getEmail())
                    .status(placementStudent.getAcceptance().toString())
                    .rollNo(student.getRollNumber())
                    .domainName(courseService.getDomainById(student.getDomainId()).getProgram())
                    .organisationName(organisation.getName())
                    .year(placementStudent.getDate().split("-")[0])
                    .build());
        }
        return ResponseBuilder.createListResponse(response.size(), response);
    }

    @GetMapping("/placements/details")
    private ResponseDto getAllPlacementDetails() {
        PlacementDetailsDto dto = PlacementDetailsDto.builder()
                .organisations(placementService.getAllOrganisations())
                .years(placementService.getAllYears())
                .domains(courseService.getAllDomains())
                .build();
        return ResponseBuilder.createResponse(dto);
    }
}
