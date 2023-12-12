package com.example.academia.placement.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.academia.placement.data.dao.AlumniEntityDao;
import com.example.academia.placement.data.dao.AlumniOrganisationEntityDao;
import com.example.academia.placement.data.dao.OrganisationEntityDao;
import com.example.academia.placement.data.dao.PlacementEntityDao;
import com.example.academia.placement.data.dao.PlacementFilterEntityDao;
import com.example.academia.placement.data.dao.PlacementStudentEntityDao;
import com.example.academia.placement.data.entity.AlumniEntity;
import com.example.academia.placement.data.entity.AlumniOrganisationEntity;
import com.example.academia.placement.data.entity.OrganisationEntity;
import com.example.academia.placement.data.entity.PlacementEntity;
import com.example.academia.placement.data.entity.PlacementFilterEntity;
import com.example.academia.placement.data.entity.PlacementStudentEntity;
import com.example.academia.placement.domain.PlacementRepository;
import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.AlumniOrganisation;
import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.PlacementStudent;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlacementRepositoryImpl implements PlacementRepository {
    private final PlacementStudentEntityDao placementStudentEntityDao;
    private final AlumniEntityDao alumniEntityDao;
    private final PlacementEntityDao placementEntityDao;
    private final PlacementFilterEntityDao placementFilterEntityDao;
    private final OrganisationEntityDao organisationEntityDao;
    private final AlumniOrganisationEntityDao alumniOrganisationEntityDao;

    @Override
    public List<AlumniOrganisation> getAllAlumnisForOrganisation(int organisationId) {
        List<AlumniOrganisationEntity> alumniOrganisationEntities = alumniOrganisationEntityDao
                .findAllByOrganisationEntityId(organisationId);
        return mapToDomainAlumniOrganisations(alumniOrganisationEntities);
    }

    @Override
    public List<Organisation> getAllOrganisations() {
        return mapToDomainOrganisations(organisationEntityDao.findAll());
    }

    @Override
    public List<PlacementStudent> getAllPlacementStudents() {
        return mapToDomainPlacementStudents(placementStudentEntityDao.findAll());
    }

    @Override
    public Alumni getAlumniById(int id) {
        return mapToDomainAlumni(getAlumniEntityById(id));
    }

    @Override
    public List<PlacementStudent> getAllPlacementStudentsForDomainId(int domainId) {
        List<PlacementFilterEntity> placementFilterEntities = placementFilterEntityDao
                .findAllByDomainEntityId(domainId);
        List<PlacementStudentEntity> result = new ArrayList<>();
        for (PlacementFilterEntity placementFilterEntity : placementFilterEntities) {
            result.addAll(placementFilterEntity.getPlacementEntity().getPlacementStudentEntities());
        }
        return mapToDomainPlacementStudents(result);
    }

    @Override
    public Organisation getOrganistationByPlacementId(int placementId) {
        return mapToDomainOrganisation(getPlacementEntityById(placementId).getOrganisationEntity());
    }

    @Override
    public List<PlacementStudent> getAllPlacementStudentsForStudentId(int id) {
        return mapToDomainPlacementStudents(placementStudentEntityDao.findAllByStudentEntityId(id));
    }

    private PlacementEntity getPlacementEntityById(int id) {
        return placementEntityDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Placment not found with id: " + id));
    }

    private AlumniEntity getAlumniEntityById(int id) {
        return alumniEntityDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alumni not found with id: " + id));
    }

    private Organisation mapToDomainOrganisation(OrganisationEntity entity) {
        return Organisation.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .build();
    }

    private List<Organisation> mapToDomainOrganisations(List<OrganisationEntity> entities) {
        return entities.stream().map(this::mapToDomainOrganisation).toList();
    }

    private Alumni mapToDomainAlumni(AlumniEntity entity) {
        return Alumni.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .contactNumber(entity.getContactNumber())
                .studentId(entity.getStudentEntity().getId())
                .build();
    }

    private PlacementStudent mapToDomainPlacementStudent(PlacementStudentEntity entity) {
        return PlacementStudent.builder()
                .id(entity.getId())
                .studentId(entity.getStudentEntity().getId())
                .placementId(entity.getPlacementEntity().getId())
                .cvApplication(entity.getCvApplication())
                .about(entity.getAbout())
                .acceptance(entity.getAcceptance())
                .comments(entity.getComments())
                .date(entity.getDate().toString())
                .build();
    }

    private List<PlacementStudent> mapToDomainPlacementStudents(List<PlacementStudentEntity> entities) {
        return entities.stream().map(this::mapToDomainPlacementStudent).toList();
    }

    private AlumniOrganisation mapToDomainAlumniOrganisation(AlumniOrganisationEntity entity) {
        return AlumniOrganisation.builder()
                .organisationId(entity.getOrganisationEntity().getId())
                .alumniId(entity.getAlumniEntity().getId())
                .position(entity.getPosition())
                .joiningDate(entity.getJoiningDate())
                .leavingDate(entity.getLeavingDate())
                .build();
    }

    private List<AlumniOrganisation> mapToDomainAlumniOrganisations(List<AlumniOrganisationEntity> entities) {
        return entities.stream().map(this::mapToDomainAlumniOrganisation).toList();
    }

}
