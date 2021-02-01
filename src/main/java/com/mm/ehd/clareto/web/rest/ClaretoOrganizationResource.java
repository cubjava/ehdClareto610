package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.domain.ClaretoOrganization;
import com.mm.ehd.clareto.service.ClaretoOrganizationService;
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
 * REST controller for managing {@link com.mm.ehd.clareto.domain.ClaretoOrganization}.
 */
@RestController
@RequestMapping("/api")
public class ClaretoOrganizationResource {

    private final Logger log = LoggerFactory.getLogger(ClaretoOrganizationResource.class);

    private static final String ENTITY_NAME = "ehdClareto610ClaretoOrganization";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ClaretoOrganizationService claretoOrganizationService;

    public ClaretoOrganizationResource(ClaretoOrganizationService claretoOrganizationService) {
        this.claretoOrganizationService = claretoOrganizationService;
    }

    /**
     * {@code POST  /clareto-organizations} : Create a new claretoOrganization.
     *
     * @param claretoOrganization the claretoOrganization to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new claretoOrganization, or with status {@code 400 (Bad Request)} if the claretoOrganization has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clareto-organizations")
    public ResponseEntity<ClaretoOrganization> createClaretoOrganization(@Valid @RequestBody ClaretoOrganization claretoOrganization) throws URISyntaxException {
        log.debug("REST request to save ClaretoOrganization : {}", claretoOrganization);
        if (claretoOrganization.getId() != null) {
            throw new BadRequestAlertException("A new claretoOrganization cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ClaretoOrganization result = claretoOrganizationService.save(claretoOrganization);
        return ResponseEntity.created(new URI("/api/clareto-organizations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /clareto-organizations} : Updates an existing claretoOrganization.
     *
     * @param claretoOrganization the claretoOrganization to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated claretoOrganization,
     * or with status {@code 400 (Bad Request)} if the claretoOrganization is not valid,
     * or with status {@code 500 (Internal Server Error)} if the claretoOrganization couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/clareto-organizations")
    public ResponseEntity<ClaretoOrganization> updateClaretoOrganization(@Valid @RequestBody ClaretoOrganization claretoOrganization) throws URISyntaxException {
        log.debug("REST request to update ClaretoOrganization : {}", claretoOrganization);
        if (claretoOrganization.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ClaretoOrganization result = claretoOrganizationService.save(claretoOrganization);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, claretoOrganization.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clareto-organizations} : get all the claretoOrganizations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of claretoOrganizations in body.
     */
    @GetMapping("/clareto-organizations")
    public ResponseEntity<List<ClaretoOrganization>> getAllClaretoOrganizations(Pageable pageable) {
        log.debug("REST request to get a page of ClaretoOrganizations");
        Page<ClaretoOrganization> page = claretoOrganizationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /clareto-organizations/:id} : get the "id" claretoOrganization.
     *
     * @param id the id of the claretoOrganization to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the claretoOrganization, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clareto-organizations/{id}")
    public ResponseEntity<ClaretoOrganization> getClaretoOrganization(@PathVariable Long id) {
        log.debug("REST request to get ClaretoOrganization : {}", id);
        Optional<ClaretoOrganization> claretoOrganization = claretoOrganizationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(claretoOrganization);
    }

    /**
     * {@code DELETE  /clareto-organizations/:id} : delete the "id" claretoOrganization.
     *
     * @param id the id of the claretoOrganization to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clareto-organizations/{id}")
    public ResponseEntity<Void> deleteClaretoOrganization(@PathVariable Long id) {
        log.debug("REST request to delete ClaretoOrganization : {}", id);
        claretoOrganizationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
