package com.mm.ehd.clareto.repository;

import com.mm.ehd.clareto.domain.ClaretoOrganization;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ClaretoOrganization entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClaretoOrganizationRepository extends JpaRepository<ClaretoOrganization, Long> {
}
