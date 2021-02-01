package com.mm.ehd.clareto.repository;

import com.mm.ehd.clareto.domain.ClaretoProvider;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ClaretoProvider entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClaretoProviderRepository extends JpaRepository<ClaretoProvider, Long> {
}
