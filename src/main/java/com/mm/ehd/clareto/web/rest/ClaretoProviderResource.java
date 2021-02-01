package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.domain.ClaretoProvider;
import com.mm.ehd.clareto.service.ClaretoProviderService;
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
 * REST controller for managing {@link com.mm.ehd.clareto.domain.ClaretoProvider}.
 */
@RestController
@RequestMapping("/api")
public class ClaretoProviderResource {

    private final Logger log = LoggerFactory.getLogger(ClaretoProviderResource.class);

    private static final String ENTITY_NAME = "ehdClareto610ClaretoProvider";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ClaretoProviderService claretoProviderService;

    public ClaretoProviderResource(ClaretoProviderService claretoProviderService) {
        this.claretoProviderService = claretoProviderService;
    }

    /**
     * {@code POST  /clareto-providers} : Create a new claretoProvider.
     *
     * @param claretoProvider the claretoProvider to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new claretoProvider, or with status {@code 400 (Bad Request)} if the claretoProvider has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clareto-providers")
    public ResponseEntity<ClaretoProvider> createClaretoProvider(@Valid @RequestBody ClaretoProvider claretoProvider) throws URISyntaxException {
        log.debug("REST request to save ClaretoProvider : {}", claretoProvider);
        if (claretoProvider.getId() != null) {
            throw new BadRequestAlertException("A new claretoProvider cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ClaretoProvider result = claretoProviderService.save(claretoProvider);
        return ResponseEntity.created(new URI("/api/clareto-providers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /clareto-providers} : Updates an existing claretoProvider.
     *
     * @param claretoProvider the claretoProvider to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated claretoProvider,
     * or with status {@code 400 (Bad Request)} if the claretoProvider is not valid,
     * or with status {@code 500 (Internal Server Error)} if the claretoProvider couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/clareto-providers")
    public ResponseEntity<ClaretoProvider> updateClaretoProvider(@Valid @RequestBody ClaretoProvider claretoProvider) throws URISyntaxException {
        log.debug("REST request to update ClaretoProvider : {}", claretoProvider);
        if (claretoProvider.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ClaretoProvider result = claretoProviderService.save(claretoProvider);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, claretoProvider.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clareto-providers} : get all the claretoProviders.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of claretoProviders in body.
     */
    @GetMapping("/clareto-providers")
    public ResponseEntity<List<ClaretoProvider>> getAllClaretoProviders(Pageable pageable) {
        log.debug("REST request to get a page of ClaretoProviders");
        Page<ClaretoProvider> page = claretoProviderService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /clareto-providers/:id} : get the "id" claretoProvider.
     *
     * @param id the id of the claretoProvider to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the claretoProvider, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clareto-providers/{id}")
    public ResponseEntity<ClaretoProvider> getClaretoProvider(@PathVariable Long id) {
        log.debug("REST request to get ClaretoProvider : {}", id);
        Optional<ClaretoProvider> claretoProvider = claretoProviderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(claretoProvider);
    }

    /**
     * {@code DELETE  /clareto-providers/:id} : delete the "id" claretoProvider.
     *
     * @param id the id of the claretoProvider to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clareto-providers/{id}")
    public ResponseEntity<Void> deleteClaretoProvider(@PathVariable Long id) {
        log.debug("REST request to delete ClaretoProvider : {}", id);
        claretoProviderService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
