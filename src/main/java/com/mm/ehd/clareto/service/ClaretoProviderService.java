package com.mm.ehd.clareto.service;

import com.mm.ehd.clareto.domain.ClaretoProvider;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ClaretoProvider}.
 */
public interface ClaretoProviderService {

    /**
     * Save a claretoProvider.
     *
     * @param claretoProvider the entity to save.
     * @return the persisted entity.
     */
    ClaretoProvider save(ClaretoProvider claretoProvider);

    /**
     * Get all the claretoProviders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ClaretoProvider> findAll(Pageable pageable);


    /**
     * Get the "id" claretoProvider.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClaretoProvider> findOne(Long id);

    /**
     * Delete the "id" claretoProvider.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
