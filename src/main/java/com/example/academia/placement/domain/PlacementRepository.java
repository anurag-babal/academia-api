package com.example.academia.placement.domain;

import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;

import java.util.List;

public interface PlacementRepository {
    Alumni getAlumniById(int id);

    List<PlacementStudent> getAllPlacementStudents();

    List<Organisation> getAllOrganisations();

    List<AlumniOrganisation> getAllAlumnisForOrganisation(int organisationId);

    List<PlacementStudent> getAllPlacementStudentsForDomainId(int domainId);

    Organisation getOrganistationByPlacementId(int placementId);

    List<PlacementStudent> getAllPlacementStudentsForStudentId(int id);
}
