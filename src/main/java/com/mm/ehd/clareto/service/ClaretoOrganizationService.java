package com.mm.ehd.clareto.service;

import com.mm.ehd.clareto.domain.ClaretoOrganization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ClaretoOrganization}.
 */
public interface ClaretoOrganizationService {

    /**
     * Save a claretoOrganization.
     *
     * @param claretoOrganization the entity to save.
     * @return the persisted entity.
     */
    ClaretoOrganization save(ClaretoOrganization claretoOrganization);

    /**
     * Get all the claretoOrganizations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ClaretoOrganization> findAll(Pageable pageable);


    /**
     * Get the "id" claretoOrganization.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClaretoOrganization> findOne(Long id);

    /**
     * Delete the "id" claretoOrganization.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
