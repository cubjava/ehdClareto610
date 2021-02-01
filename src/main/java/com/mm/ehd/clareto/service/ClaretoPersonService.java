package com.mm.ehd.clareto.service;

import com.mm.ehd.clareto.domain.ClaretoPerson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ClaretoPerson}.
 */
public interface ClaretoPersonService {

    /**
     * Save a claretoPerson.
     *
     * @param claretoPerson the entity to save.
     * @return the persisted entity.
     */
    ClaretoPerson save(ClaretoPerson claretoPerson);

    /**
     * Get all the claretoPeople.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ClaretoPerson> findAll(Pageable pageable);


    /**
     * Get the "id" claretoPerson.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClaretoPerson> findOne(Long id);

    /**
     * Delete the "id" claretoPerson.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
