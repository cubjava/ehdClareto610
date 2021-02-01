package com.mm.ehd.clareto.service.impl;

import com.mm.ehd.clareto.service.ClaretoProviderService;
import com.mm.ehd.clareto.domain.ClaretoProvider;
import com.mm.ehd.clareto.repository.ClaretoProviderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ClaretoProvider}.
 */
@Service
@Transactional
public class ClaretoProviderServiceImpl implements ClaretoProviderService {

    private final Logger log = LoggerFactory.getLogger(ClaretoProviderServiceImpl.class);

    private final ClaretoProviderRepository claretoProviderRepository;

    public ClaretoProviderServiceImpl(ClaretoProviderRepository claretoProviderRepository) {
        this.claretoProviderRepository = claretoProviderRepository;
    }

    @Override
    public ClaretoProvider save(ClaretoProvider claretoProvider) {
        log.debug("Request to save ClaretoProvider : {}", claretoProvider);
        return claretoProviderRepository.save(claretoProvider);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClaretoProvider> findAll(Pageable pageable) {
        log.debug("Request to get all ClaretoProviders");
        return claretoProviderRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ClaretoProvider> findOne(Long id) {
        log.debug("Request to get ClaretoProvider : {}", id);
        return claretoProviderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ClaretoProvider : {}", id);
        claretoProviderRepository.deleteById(id);
    }
}
