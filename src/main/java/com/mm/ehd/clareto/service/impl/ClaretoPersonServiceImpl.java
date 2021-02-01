package com.mm.ehd.clareto.service.impl;

import com.mm.ehd.clareto.service.ClaretoPersonService;
import com.mm.ehd.clareto.domain.ClaretoPerson;
import com.mm.ehd.clareto.repository.ClaretoPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ClaretoPerson}.
 */
@Service
@Transactional
public class ClaretoPersonServiceImpl implements ClaretoPersonService {

    private final Logger log = LoggerFactory.getLogger(ClaretoPersonServiceImpl.class);

    private final ClaretoPersonRepository claretoPersonRepository;

    public ClaretoPersonServiceImpl(ClaretoPersonRepository claretoPersonRepository) {
        this.claretoPersonRepository = claretoPersonRepository;
    }

    @Override
    public ClaretoPerson save(ClaretoPerson claretoPerson) {
        log.debug("Request to save ClaretoPerson : {}", claretoPerson);
        return claretoPersonRepository.save(claretoPerson);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClaretoPerson> findAll(Pageable pageable) {
        log.debug("Request to get all ClaretoPeople");
        return claretoPersonRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ClaretoPerson> findOne(Long id) {
        log.debug("Request to get ClaretoPerson : {}", id);
        return claretoPersonRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ClaretoPerson : {}", id);
        claretoPersonRepository.deleteById(id);
    }
}
