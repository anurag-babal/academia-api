package com.example.academia.placement.domain;

import java.util.List;

import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;

public interface PlacementRepository {
    public Alumni getAlumniById(int id);
    public List<PlacementStudent> getAllPlacementStudents();
    public List<Organisation> getAllOrganisations();
    public List<AlumniOrganisation> getAllAlumnisForOrganisation(int organisationId);
    public List<PlacementStudent> getAllPlacementStudentsForDomainId(int domainId);
    public Organisation getOrganistationByPlacementId(int placementId);
    public List<PlacementStudent> getAllPlacementStudentsForStudentId(int id);
}
