package com.example.academia.placement.domain;

import java.util.List;

import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;

public interface PlacementService {
    public List<Organisation> getAllOrganisations();
    public List<String> getAllYears();
    public List<AlumniOrganisation> getAllAlumniOrganisationsForOrganisationId(int id);
    public Alumni getAlumniById(int id);
    public List<PlacementStudent> getPlacementHistory(int organisationId, int domainId, String year);
    public Organisation getOrganisationByPlacementId(int placementId);
}
