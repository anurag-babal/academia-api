package com.example.academia.placement.domain;

import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;

import java.util.List;

public interface PlacementService {
    List<Organisation> getAllOrganisations();

    List<String> getAllYears();

    List<AlumniOrganisation> getAllAlumniOrganisationsForOrganisationId(int id);

    Alumni getAlumniById(int id);

    List<PlacementStudent> getPlacementHistory(int organisationId, int domainId, String year);

    Organisation getOrganisationByPlacementId(int placementId);
}
