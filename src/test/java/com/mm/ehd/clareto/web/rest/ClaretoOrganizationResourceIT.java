package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.EhdClareto610App;
import com.mm.ehd.clareto.config.TestSecurityConfiguration;
import com.mm.ehd.clareto.domain.ClaretoOrganization;
import com.mm.ehd.clareto.repository.ClaretoOrganizationRepository;
import com.mm.ehd.clareto.service.ClaretoOrganizationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mm.ehd.clareto.domain.enumeration.ClaretoStatus;
/**
 * Integration tests for the {@link ClaretoOrganizationResource} REST controller.
 */
@SpringBootTest(classes = { EhdClareto610App.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ClaretoOrganizationResourceIT {

    private static final String DEFAULT_GUID = "AAAAAAAAAA";
    private static final String UPDATED_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_EHD_ORDER_GUID = "AAAAAAAAAA";
    private static final String UPDATED_EHD_ORDER_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_EHD_EMPI = "AAAAAAAAAA";
    private static final String UPDATED_EHD_EMPI = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_SEARCH_GUID = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_SEARCH_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_PERSON_GUID = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_PERSON_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_PROVIDER_GUID = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_PROVIDER_GUID = "BBBBBBBBBB";

    private static final ClaretoStatus DEFAULT_STATUS = ClaretoStatus.NEW;
    private static final ClaretoStatus UPDATED_STATUS = ClaretoStatus.RECEIVED;

    private static final Integer DEFAULT_CLARETO_PROVIDER_ID = 1;
    private static final Integer UPDATED_CLARETO_PROVIDER_ID = 2;

    private static final String DEFAULT_ORGANIZATION_ID = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SPECIAL_AUTH_DOC_STORE_GUID = "AAAAAAAAAA";
    private static final String UPDATED_SPECIAL_AUTH_DOC_STORE_GUID = "BBBBBBBBBB";

    private static final Integer DEFAULT_RETRY_COUNT = 1;
    private static final Integer UPDATED_RETRY_COUNT = 2;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_LAST_MODIFIED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_MODIFIED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ClaretoOrganizationRepository claretoOrganizationRepository;

    @Autowired
    private ClaretoOrganizationService claretoOrganizationService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restClaretoOrganizationMockMvc;

    private ClaretoOrganization claretoOrganization;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoOrganization createEntity(EntityManager em) {
        ClaretoOrganization claretoOrganization = new ClaretoOrganization()
            .guid(DEFAULT_GUID)
            .ehdOrderGuid(DEFAULT_EHD_ORDER_GUID)
            .ehdEmpi(DEFAULT_EHD_EMPI)
            .claretoSearchGuid(DEFAULT_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(DEFAULT_CLARETO_PERSON_GUID)
            .claretoProviderGuid(DEFAULT_CLARETO_PROVIDER_GUID)
            .status(DEFAULT_STATUS)
            .claretoProviderId(DEFAULT_CLARETO_PROVIDER_ID)
            .organizationId(DEFAULT_ORGANIZATION_ID)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .specialAuthDocStoreGuid(DEFAULT_SPECIAL_AUTH_DOC_STORE_GUID)
            .retryCount(DEFAULT_RETRY_COUNT)
            .createdAt(DEFAULT_CREATED_AT)
            .lastModifiedAt(DEFAULT_LAST_MODIFIED_AT);
        return claretoOrganization;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoOrganization createUpdatedEntity(EntityManager em) {
        ClaretoOrganization claretoOrganization = new ClaretoOrganization()
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(UPDATED_CLARETO_PERSON_GUID)
            .claretoProviderGuid(UPDATED_CLARETO_PROVIDER_GUID)
            .status(UPDATED_STATUS)
            .claretoProviderId(UPDATED_CLARETO_PROVIDER_ID)
            .organizationId(UPDATED_ORGANIZATION_ID)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .specialAuthDocStoreGuid(UPDATED_SPECIAL_AUTH_DOC_STORE_GUID)
            .retryCount(UPDATED_RETRY_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);
        return claretoOrganization;
    }

    @BeforeEach
    public void initTest() {
        claretoOrganization = createEntity(em);
    }

    @Test
    @Transactional
    public void createClaretoOrganization() throws Exception {
        int databaseSizeBeforeCreate = claretoOrganizationRepository.findAll().size();
        // Create the ClaretoOrganization
        restClaretoOrganizationMockMvc.perform(post("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoOrganization)))
            .andExpect(status().isCreated());

        // Validate the ClaretoOrganization in the database
        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeCreate + 1);
        ClaretoOrganization testClaretoOrganization = claretoOrganizationList.get(claretoOrganizationList.size() - 1);
        assertThat(testClaretoOrganization.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testClaretoOrganization.getEhdOrderGuid()).isEqualTo(DEFAULT_EHD_ORDER_GUID);
        assertThat(testClaretoOrganization.getEhdEmpi()).isEqualTo(DEFAULT_EHD_EMPI);
        assertThat(testClaretoOrganization.getClaretoSearchGuid()).isEqualTo(DEFAULT_CLARETO_SEARCH_GUID);
        assertThat(testClaretoOrganization.getClaretoPersonGuid()).isEqualTo(DEFAULT_CLARETO_PERSON_GUID);
        assertThat(testClaretoOrganization.getClaretoProviderGuid()).isEqualTo(DEFAULT_CLARETO_PROVIDER_GUID);
        assertThat(testClaretoOrganization.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testClaretoOrganization.getClaretoProviderId()).isEqualTo(DEFAULT_CLARETO_PROVIDER_ID);
        assertThat(testClaretoOrganization.getOrganizationId()).isEqualTo(DEFAULT_ORGANIZATION_ID);
        assertThat(testClaretoOrganization.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testClaretoOrganization.getSpecialAuthDocStoreGuid()).isEqualTo(DEFAULT_SPECIAL_AUTH_DOC_STORE_GUID);
        assertThat(testClaretoOrganization.getRetryCount()).isEqualTo(DEFAULT_RETRY_COUNT);
        assertThat(testClaretoOrganization.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testClaretoOrganization.getLastModifiedAt()).isEqualTo(DEFAULT_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void createClaretoOrganizationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = claretoOrganizationRepository.findAll().size();

        // Create the ClaretoOrganization with an existing ID
        claretoOrganization.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restClaretoOrganizationMockMvc.perform(post("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoOrganization)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoOrganization in the database
        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkGuidIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoOrganizationRepository.findAll().size();
        // set the field null
        claretoOrganization.setGuid(null);

        // Create the ClaretoOrganization, which fails.


        restClaretoOrganizationMockMvc.perform(post("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoOrganization)))
            .andExpect(status().isBadRequest());

        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoOrganizationRepository.findAll().size();
        // set the field null
        claretoOrganization.setStatus(null);

        // Create the ClaretoOrganization, which fails.


        restClaretoOrganizationMockMvc.perform(post("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoOrganization)))
            .andExpect(status().isBadRequest());

        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreatedAtIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoOrganizationRepository.findAll().size();
        // set the field null
        claretoOrganization.setCreatedAt(null);

        // Create the ClaretoOrganization, which fails.


        restClaretoOrganizationMockMvc.perform(post("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoOrganization)))
            .andExpect(status().isBadRequest());

        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllClaretoOrganizations() throws Exception {
        // Initialize the database
        claretoOrganizationRepository.saveAndFlush(claretoOrganization);

        // Get all the claretoOrganizationList
        restClaretoOrganizationMockMvc.perform(get("/api/clareto-organizations?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(claretoOrganization.getId().intValue())))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)))
            .andExpect(jsonPath("$.[*].ehdOrderGuid").value(hasItem(DEFAULT_EHD_ORDER_GUID)))
            .andExpect(jsonPath("$.[*].ehdEmpi").value(hasItem(DEFAULT_EHD_EMPI)))
            .andExpect(jsonPath("$.[*].claretoSearchGuid").value(hasItem(DEFAULT_CLARETO_SEARCH_GUID)))
            .andExpect(jsonPath("$.[*].claretoPersonGuid").value(hasItem(DEFAULT_CLARETO_PERSON_GUID)))
            .andExpect(jsonPath("$.[*].claretoProviderGuid").value(hasItem(DEFAULT_CLARETO_PROVIDER_GUID)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].claretoProviderId").value(hasItem(DEFAULT_CLARETO_PROVIDER_ID)))
            .andExpect(jsonPath("$.[*].organizationId").value(hasItem(DEFAULT_ORGANIZATION_ID)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].specialAuthDocStoreGuid").value(hasItem(DEFAULT_SPECIAL_AUTH_DOC_STORE_GUID)))
            .andExpect(jsonPath("$.[*].retryCount").value(hasItem(DEFAULT_RETRY_COUNT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedAt").value(hasItem(DEFAULT_LAST_MODIFIED_AT.toString())));
    }
    
    @Test
    @Transactional
    public void getClaretoOrganization() throws Exception {
        // Initialize the database
        claretoOrganizationRepository.saveAndFlush(claretoOrganization);

        // Get the claretoOrganization
        restClaretoOrganizationMockMvc.perform(get("/api/clareto-organizations/{id}", claretoOrganization.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(claretoOrganization.getId().intValue()))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID))
            .andExpect(jsonPath("$.ehdOrderGuid").value(DEFAULT_EHD_ORDER_GUID))
            .andExpect(jsonPath("$.ehdEmpi").value(DEFAULT_EHD_EMPI))
            .andExpect(jsonPath("$.claretoSearchGuid").value(DEFAULT_CLARETO_SEARCH_GUID))
            .andExpect(jsonPath("$.claretoPersonGuid").value(DEFAULT_CLARETO_PERSON_GUID))
            .andExpect(jsonPath("$.claretoProviderGuid").value(DEFAULT_CLARETO_PROVIDER_GUID))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.claretoProviderId").value(DEFAULT_CLARETO_PROVIDER_ID))
            .andExpect(jsonPath("$.organizationId").value(DEFAULT_ORGANIZATION_ID))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.specialAuthDocStoreGuid").value(DEFAULT_SPECIAL_AUTH_DOC_STORE_GUID))
            .andExpect(jsonPath("$.retryCount").value(DEFAULT_RETRY_COUNT))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.lastModifiedAt").value(DEFAULT_LAST_MODIFIED_AT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingClaretoOrganization() throws Exception {
        // Get the claretoOrganization
        restClaretoOrganizationMockMvc.perform(get("/api/clareto-organizations/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateClaretoOrganization() throws Exception {
        // Initialize the database
        claretoOrganizationService.save(claretoOrganization);

        int databaseSizeBeforeUpdate = claretoOrganizationRepository.findAll().size();

        // Update the claretoOrganization
        ClaretoOrganization updatedClaretoOrganization = claretoOrganizationRepository.findById(claretoOrganization.getId()).get();
        // Disconnect from session so that the updates on updatedClaretoOrganization are not directly saved in db
        em.detach(updatedClaretoOrganization);
        updatedClaretoOrganization
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(UPDATED_CLARETO_PERSON_GUID)
            .claretoProviderGuid(UPDATED_CLARETO_PROVIDER_GUID)
            .status(UPDATED_STATUS)
            .claretoProviderId(UPDATED_CLARETO_PROVIDER_ID)
            .organizationId(UPDATED_ORGANIZATION_ID)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .specialAuthDocStoreGuid(UPDATED_SPECIAL_AUTH_DOC_STORE_GUID)
            .retryCount(UPDATED_RETRY_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);

        restClaretoOrganizationMockMvc.perform(put("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedClaretoOrganization)))
            .andExpect(status().isOk());

        // Validate the ClaretoOrganization in the database
        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeUpdate);
        ClaretoOrganization testClaretoOrganization = claretoOrganizationList.get(claretoOrganizationList.size() - 1);
        assertThat(testClaretoOrganization.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testClaretoOrganization.getEhdOrderGuid()).isEqualTo(UPDATED_EHD_ORDER_GUID);
        assertThat(testClaretoOrganization.getEhdEmpi()).isEqualTo(UPDATED_EHD_EMPI);
        assertThat(testClaretoOrganization.getClaretoSearchGuid()).isEqualTo(UPDATED_CLARETO_SEARCH_GUID);
        assertThat(testClaretoOrganization.getClaretoPersonGuid()).isEqualTo(UPDATED_CLARETO_PERSON_GUID);
        assertThat(testClaretoOrganization.getClaretoProviderGuid()).isEqualTo(UPDATED_CLARETO_PROVIDER_GUID);
        assertThat(testClaretoOrganization.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testClaretoOrganization.getClaretoProviderId()).isEqualTo(UPDATED_CLARETO_PROVIDER_ID);
        assertThat(testClaretoOrganization.getOrganizationId()).isEqualTo(UPDATED_ORGANIZATION_ID);
        assertThat(testClaretoOrganization.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testClaretoOrganization.getSpecialAuthDocStoreGuid()).isEqualTo(UPDATED_SPECIAL_AUTH_DOC_STORE_GUID);
        assertThat(testClaretoOrganization.getRetryCount()).isEqualTo(UPDATED_RETRY_COUNT);
        assertThat(testClaretoOrganization.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testClaretoOrganization.getLastModifiedAt()).isEqualTo(UPDATED_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingClaretoOrganization() throws Exception {
        int databaseSizeBeforeUpdate = claretoOrganizationRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restClaretoOrganizationMockMvc.perform(put("/api/clareto-organizations").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoOrganization)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoOrganization in the database
        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteClaretoOrganization() throws Exception {
        // Initialize the database
        claretoOrganizationService.save(claretoOrganization);

        int databaseSizeBeforeDelete = claretoOrganizationRepository.findAll().size();

        // Delete the claretoOrganization
        restClaretoOrganizationMockMvc.perform(delete("/api/clareto-organizations/{id}", claretoOrganization.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ClaretoOrganization> claretoOrganizationList = claretoOrganizationRepository.findAll();
        assertThat(claretoOrganizationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
