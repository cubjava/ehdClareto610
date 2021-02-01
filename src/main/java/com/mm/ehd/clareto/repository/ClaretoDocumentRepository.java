package com.mm.ehd.clareto.repository;

import com.mm.ehd.clareto.domain.ClaretoDocument;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ClaretoDocument entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClaretoDocumentRepository extends JpaRepository<ClaretoDocument, Long> {
}
