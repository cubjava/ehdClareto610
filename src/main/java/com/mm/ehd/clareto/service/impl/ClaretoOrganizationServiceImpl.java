package com.mm.ehd.clareto.service.impl;

import com.mm.ehd.clareto.service.ClaretoOrganizationService;
import com.mm.ehd.clareto.domain.ClaretoOrganization;
import com.mm.ehd.clareto.repository.ClaretoOrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ClaretoOrganization}.
 */
@Service
@Transactional
public class ClaretoOrganizationServiceImpl implements ClaretoOrganizationService {

    private final Logger log = LoggerFactory.getLogger(ClaretoOrganizationServiceImpl.class);

    private final ClaretoOrganizationRepository claretoOrganizationRepository;

    public ClaretoOrganizationServiceImpl(ClaretoOrganizationRepository claretoOrganizationRepository) {
        this.claretoOrganizationRepository = claretoOrganizationRepository;
    }

    @Override
    public ClaretoOrganization save(ClaretoOrganization claretoOrganization) {
        log.debug("Request to save ClaretoOrganization : {}", claretoOrganization);
        return claretoOrganizationRepository.save(claretoOrganization);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClaretoOrganization> findAll(Pageable pageable) {
        log.debug("Request to get all ClaretoOrganizations");
        return claretoOrganizationRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ClaretoOrganization> findOne(Long id) {
        log.debug("Request to get ClaretoOrganization : {}", id);
        return claretoOrganizationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ClaretoOrganization : {}", id);
        claretoOrganizationRepository.deleteById(id);
    }
}
