package com.mm.ehd.clareto.service;

import com.mm.ehd.clareto.domain.ClaretoDocument;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ClaretoDocument}.
 */
public interface ClaretoDocumentService {

    /**
     * Save a claretoDocument.
     *
     * @param claretoDocument the entity to save.
     * @return the persisted entity.
     */
    ClaretoDocument save(ClaretoDocument claretoDocument);

    /**
     * Get all the claretoDocuments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ClaretoDocument> findAll(Pageable pageable);


    /**
     * Get the "id" claretoDocument.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClaretoDocument> findOne(Long id);

    /**
     * Delete the "id" claretoDocument.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
