package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.domain.ClaretoDocument;
import com.mm.ehd.clareto.service.ClaretoDocumentService;
import com.mm.ehd.clareto.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mm.ehd.clareto.domain.ClaretoDocument}.
 */
@RestController
@RequestMapping("/api")
public class ClaretoDocumentResource {

    private final Logger log = LoggerFactory.getLogger(ClaretoDocumentResource.class);

    private static final String ENTITY_NAME = "ehdClareto610ClaretoDocument";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ClaretoDocumentService claretoDocumentService;

    public ClaretoDocumentResource(ClaretoDocumentService claretoDocumentService) {
        this.claretoDocumentService = claretoDocumentService;
    }

    /**
     * {@code POST  /clareto-documents} : Create a new claretoDocument.
     *
     * @param claretoDocument the claretoDocument to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new claretoDocument, or with status {@code 400 (Bad Request)} if the claretoDocument has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clareto-documents")
    public ResponseEntity<ClaretoDocument> createClaretoDocument(@Valid @RequestBody ClaretoDocument claretoDocument) throws URISyntaxException {
        log.debug("REST request to save ClaretoDocument : {}", claretoDocument);
        if (claretoDocument.getId() != null) {
            throw new BadRequestAlertException("A new claretoDocument cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ClaretoDocument result = claretoDocumentService.save(claretoDocument);
        return ResponseEntity.created(new URI("/api/clareto-documents/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /clareto-documents} : Updates an existing claretoDocument.
     *
     * @param claretoDocument the claretoDocument to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated claretoDocument,
     * or with status {@code 400 (Bad Request)} if the claretoDocument is not valid,
     * or with status {@code 500 (Internal Server Error)} if the claretoDocument couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/clareto-documents")
    public ResponseEntity<ClaretoDocument> updateClaretoDocument(@Valid @RequestBody ClaretoDocument claretoDocument) throws URISyntaxException {
        log.debug("REST request to update ClaretoDocument : {}", claretoDocument);
        if (claretoDocument.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ClaretoDocument result = claretoDocumentService.save(claretoDocument);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, claretoDocument.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clareto-documents} : get all the claretoDocuments.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of claretoDocuments in body.
     */
    @GetMapping("/clareto-documents")
    public ResponseEntity<List<ClaretoDocument>> getAllClaretoDocuments(Pageable pageable) {
        log.debug("REST request to get a page of ClaretoDocuments");
        Page<ClaretoDocument> page = claretoDocumentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /clareto-documents/:id} : get the "id" claretoDocument.
     *
     * @param id the id of the claretoDocument to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the claretoDocument, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clareto-documents/{id}")
    public ResponseEntity<ClaretoDocument> getClaretoDocument(@PathVariable Long id) {
        log.debug("REST request to get ClaretoDocument : {}", id);
        Optional<ClaretoDocument> claretoDocument = claretoDocumentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(claretoDocument);
    }

    /**
     * {@code DELETE  /clareto-documents/:id} : delete the "id" claretoDocument.
     *
     * @param id the id of the claretoDocument to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clareto-documents/{id}")
    public ResponseEntity<Void> deleteClaretoDocument(@PathVariable Long id) {
        log.debug("REST request to delete ClaretoDocument : {}", id);
        claretoDocumentService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
