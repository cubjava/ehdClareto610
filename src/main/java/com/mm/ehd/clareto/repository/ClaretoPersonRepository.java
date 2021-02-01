package com.mm.ehd.clareto.repository;

import com.mm.ehd.clareto.domain.ClaretoPerson;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ClaretoPerson entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClaretoPersonRepository extends JpaRepository<ClaretoPerson, Long> {
}
