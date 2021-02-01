package com.mm.ehd.clareto.service.impl;

import com.mm.ehd.clareto.service.ClaretoDocumentService;
import com.mm.ehd.clareto.domain.ClaretoDocument;
import com.mm.ehd.clareto.repository.ClaretoDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ClaretoDocument}.
 */
@Service
@Transactional
public class ClaretoDocumentServiceImpl implements ClaretoDocumentService {

    private final Logger log = LoggerFactory.getLogger(ClaretoDocumentServiceImpl.class);

    private final ClaretoDocumentRepository claretoDocumentRepository;

    public ClaretoDocumentServiceImpl(ClaretoDocumentRepository claretoDocumentRepository) {
        this.claretoDocumentRepository = claretoDocumentRepository;
    }

    @Override
    public ClaretoDocument save(ClaretoDocument claretoDocument) {
        log.debug("Request to save ClaretoDocument : {}", claretoDocument);
        return claretoDocumentRepository.save(claretoDocument);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClaretoDocument> findAll(Pageable pageable) {
        log.debug("Request to get all ClaretoDocuments");
        return claretoDocumentRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ClaretoDocument> findOne(Long id) {
        log.debug("Request to get ClaretoDocument : {}", id);
        return claretoDocumentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ClaretoDocument : {}", id);
        claretoDocumentRepository.deleteById(id);
    }
}
