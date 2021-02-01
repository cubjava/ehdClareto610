package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.domain.ClaretoPerson;
import com.mm.ehd.clareto.service.ClaretoPersonService;
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
 * REST controller for managing {@link com.mm.ehd.clareto.domain.ClaretoPerson}.
 */
@RestController
@RequestMapping("/api")
public class ClaretoPersonResource {

    private final Logger log = LoggerFactory.getLogger(ClaretoPersonResource.class);

    private static final String ENTITY_NAME = "ehdClareto610ClaretoPerson";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ClaretoPersonService claretoPersonService;

    public ClaretoPersonResource(ClaretoPersonService claretoPersonService) {
        this.claretoPersonService = claretoPersonService;
    }

    /**
     * {@code POST  /clareto-people} : Create a new claretoPerson.
     *
     * @param claretoPerson the claretoPerson to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new claretoPerson, or with status {@code 400 (Bad Request)} if the claretoPerson has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clareto-people")
    public ResponseEntity<ClaretoPerson> createClaretoPerson(@Valid @RequestBody ClaretoPerson claretoPerson) throws URISyntaxException {
        log.debug("REST request to save ClaretoPerson : {}", claretoPerson);
        if (claretoPerson.getId() != null) {
            throw new BadRequestAlertException("A new claretoPerson cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ClaretoPerson result = claretoPersonService.save(claretoPerson);
        return ResponseEntity.created(new URI("/api/clareto-people/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /clareto-people} : Updates an existing claretoPerson.
     *
     * @param claretoPerson the claretoPerson to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated claretoPerson,
     * or with status {@code 400 (Bad Request)} if the claretoPerson is not valid,
     * or with status {@code 500 (Internal Server Error)} if the claretoPerson couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/clareto-people")
    public ResponseEntity<ClaretoPerson> updateClaretoPerson(@Valid @RequestBody ClaretoPerson claretoPerson) throws URISyntaxException {
        log.debug("REST request to update ClaretoPerson : {}", claretoPerson);
        if (claretoPerson.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ClaretoPerson result = claretoPersonService.save(claretoPerson);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, claretoPerson.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clareto-people} : get all the claretoPeople.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of claretoPeople in body.
     */
    @GetMapping("/clareto-people")
    public ResponseEntity<List<ClaretoPerson>> getAllClaretoPeople(Pageable pageable) {
        log.debug("REST request to get a page of ClaretoPeople");
        Page<ClaretoPerson> page = claretoPersonService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /clareto-people/:id} : get the "id" claretoPerson.
     *
     * @param id the id of the claretoPerson to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the claretoPerson, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clareto-people/{id}")
    public ResponseEntity<ClaretoPerson> getClaretoPerson(@PathVariable Long id) {
        log.debug("REST request to get ClaretoPerson : {}", id);
        Optional<ClaretoPerson> claretoPerson = claretoPersonService.findOne(id);
        return ResponseUtil.wrapOrNotFound(claretoPerson);
    }

    /**
     * {@code DELETE  /clareto-people/:id} : delete the "id" claretoPerson.
     *
     * @param id the id of the claretoPerson to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clareto-people/{id}")
    public ResponseEntity<Void> deleteClaretoPerson(@PathVariable Long id) {
        log.debug("REST request to delete ClaretoPerson : {}", id);
        claretoPersonService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
