package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.EhdClareto610App;
import com.mm.ehd.clareto.config.TestSecurityConfiguration;
import com.mm.ehd.clareto.domain.ClaretoProvider;
import com.mm.ehd.clareto.repository.ClaretoProviderRepository;
import com.mm.ehd.clareto.service.ClaretoProviderService;

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
 * Integration tests for the {@link ClaretoProviderResource} REST controller.
 */
@SpringBootTest(classes = { EhdClareto610App.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ClaretoProviderResourceIT {

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

    private static final ClaretoStatus DEFAULT_STATUS = ClaretoStatus.NEW;
    private static final ClaretoStatus UPDATED_STATUS = ClaretoStatus.RECEIVED;

    private static final Integer DEFAULT_CLARETO_PERSON_ID = 1;
    private static final Integer UPDATED_CLARETO_PERSON_ID = 2;

    private static final String DEFAULT_PROVIDER_ID = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDER_STATUS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_STATUS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDER_STATUS_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_STATUS_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDER_STATUS_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_STATUS_DESCRIPTION = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_LAST_MODIFIED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_MODIFIED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ClaretoProviderRepository claretoProviderRepository;

    @Autowired
    private ClaretoProviderService claretoProviderService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restClaretoProviderMockMvc;

    private ClaretoProvider claretoProvider;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoProvider createEntity(EntityManager em) {
        ClaretoProvider claretoProvider = new ClaretoProvider()
            .guid(DEFAULT_GUID)
            .ehdOrderGuid(DEFAULT_EHD_ORDER_GUID)
            .ehdEmpi(DEFAULT_EHD_EMPI)
            .claretoSearchGuid(DEFAULT_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(DEFAULT_CLARETO_PERSON_GUID)
            .status(DEFAULT_STATUS)
            .claretoPersonId(DEFAULT_CLARETO_PERSON_ID)
            .providerId(DEFAULT_PROVIDER_ID)
            .providerName(DEFAULT_PROVIDER_NAME)
            .providerStatusCode(DEFAULT_PROVIDER_STATUS_CODE)
            .providerStatusText(DEFAULT_PROVIDER_STATUS_TEXT)
            .providerStatusDescription(DEFAULT_PROVIDER_STATUS_DESCRIPTION)
            .createdAt(DEFAULT_CREATED_AT)
            .lastModifiedAt(DEFAULT_LAST_MODIFIED_AT);
        return claretoProvider;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoProvider createUpdatedEntity(EntityManager em) {
        ClaretoProvider claretoProvider = new ClaretoProvider()
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(UPDATED_CLARETO_PERSON_GUID)
            .status(UPDATED_STATUS)
            .claretoPersonId(UPDATED_CLARETO_PERSON_ID)
            .providerId(UPDATED_PROVIDER_ID)
            .providerName(UPDATED_PROVIDER_NAME)
            .providerStatusCode(UPDATED_PROVIDER_STATUS_CODE)
            .providerStatusText(UPDATED_PROVIDER_STATUS_TEXT)
            .providerStatusDescription(UPDATED_PROVIDER_STATUS_DESCRIPTION)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);
        return claretoProvider;
    }

    @BeforeEach
    public void initTest() {
        claretoProvider = createEntity(em);
    }

    @Test
    @Transactional
    public void createClaretoProvider() throws Exception {
        int databaseSizeBeforeCreate = claretoProviderRepository.findAll().size();
        // Create the ClaretoProvider
        restClaretoProviderMockMvc.perform(post("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoProvider)))
            .andExpect(status().isCreated());

        // Validate the ClaretoProvider in the database
        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeCreate + 1);
        ClaretoProvider testClaretoProvider = claretoProviderList.get(claretoProviderList.size() - 1);
        assertThat(testClaretoProvider.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testClaretoProvider.getEhdOrderGuid()).isEqualTo(DEFAULT_EHD_ORDER_GUID);
        assertThat(testClaretoProvider.getEhdEmpi()).isEqualTo(DEFAULT_EHD_EMPI);
        assertThat(testClaretoProvider.getClaretoSearchGuid()).isEqualTo(DEFAULT_CLARETO_SEARCH_GUID);
        assertThat(testClaretoProvider.getClaretoPersonGuid()).isEqualTo(DEFAULT_CLARETO_PERSON_GUID);
        assertThat(testClaretoProvider.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testClaretoProvider.getClaretoPersonId()).isEqualTo(DEFAULT_CLARETO_PERSON_ID);
        assertThat(testClaretoProvider.getProviderId()).isEqualTo(DEFAULT_PROVIDER_ID);
        assertThat(testClaretoProvider.getProviderName()).isEqualTo(DEFAULT_PROVIDER_NAME);
        assertThat(testClaretoProvider.getProviderStatusCode()).isEqualTo(DEFAULT_PROVIDER_STATUS_CODE);
        assertThat(testClaretoProvider.getProviderStatusText()).isEqualTo(DEFAULT_PROVIDER_STATUS_TEXT);
        assertThat(testClaretoProvider.getProviderStatusDescription()).isEqualTo(DEFAULT_PROVIDER_STATUS_DESCRIPTION);
        assertThat(testClaretoProvider.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testClaretoProvider.getLastModifiedAt()).isEqualTo(DEFAULT_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void createClaretoProviderWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = claretoProviderRepository.findAll().size();

        // Create the ClaretoProvider with an existing ID
        claretoProvider.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restClaretoProviderMockMvc.perform(post("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoProvider)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoProvider in the database
        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkGuidIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoProviderRepository.findAll().size();
        // set the field null
        claretoProvider.setGuid(null);

        // Create the ClaretoProvider, which fails.


        restClaretoProviderMockMvc.perform(post("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoProvider)))
            .andExpect(status().isBadRequest());

        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoProviderRepository.findAll().size();
        // set the field null
        claretoProvider.setStatus(null);

        // Create the ClaretoProvider, which fails.


        restClaretoProviderMockMvc.perform(post("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoProvider)))
            .andExpect(status().isBadRequest());

        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreatedAtIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoProviderRepository.findAll().size();
        // set the field null
        claretoProvider.setCreatedAt(null);

        // Create the ClaretoProvider, which fails.


        restClaretoProviderMockMvc.perform(post("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoProvider)))
            .andExpect(status().isBadRequest());

        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllClaretoProviders() throws Exception {
        // Initialize the database
        claretoProviderRepository.saveAndFlush(claretoProvider);

        // Get all the claretoProviderList
        restClaretoProviderMockMvc.perform(get("/api/clareto-providers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(claretoProvider.getId().intValue())))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)))
            .andExpect(jsonPath("$.[*].ehdOrderGuid").value(hasItem(DEFAULT_EHD_ORDER_GUID)))
            .andExpect(jsonPath("$.[*].ehdEmpi").value(hasItem(DEFAULT_EHD_EMPI)))
            .andExpect(jsonPath("$.[*].claretoSearchGuid").value(hasItem(DEFAULT_CLARETO_SEARCH_GUID)))
            .andExpect(jsonPath("$.[*].claretoPersonGuid").value(hasItem(DEFAULT_CLARETO_PERSON_GUID)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].claretoPersonId").value(hasItem(DEFAULT_CLARETO_PERSON_ID)))
            .andExpect(jsonPath("$.[*].providerId").value(hasItem(DEFAULT_PROVIDER_ID)))
            .andExpect(jsonPath("$.[*].providerName").value(hasItem(DEFAULT_PROVIDER_NAME)))
            .andExpect(jsonPath("$.[*].providerStatusCode").value(hasItem(DEFAULT_PROVIDER_STATUS_CODE)))
            .andExpect(jsonPath("$.[*].providerStatusText").value(hasItem(DEFAULT_PROVIDER_STATUS_TEXT)))
            .andExpect(jsonPath("$.[*].providerStatusDescription").value(hasItem(DEFAULT_PROVIDER_STATUS_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedAt").value(hasItem(DEFAULT_LAST_MODIFIED_AT.toString())));
    }
    
    @Test
    @Transactional
    public void getClaretoProvider() throws Exception {
        // Initialize the database
        claretoProviderRepository.saveAndFlush(claretoProvider);

        // Get the claretoProvider
        restClaretoProviderMockMvc.perform(get("/api/clareto-providers/{id}", claretoProvider.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(claretoProvider.getId().intValue()))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID))
            .andExpect(jsonPath("$.ehdOrderGuid").value(DEFAULT_EHD_ORDER_GUID))
            .andExpect(jsonPath("$.ehdEmpi").value(DEFAULT_EHD_EMPI))
            .andExpect(jsonPath("$.claretoSearchGuid").value(DEFAULT_CLARETO_SEARCH_GUID))
            .andExpect(jsonPath("$.claretoPersonGuid").value(DEFAULT_CLARETO_PERSON_GUID))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.claretoPersonId").value(DEFAULT_CLARETO_PERSON_ID))
            .andExpect(jsonPath("$.providerId").value(DEFAULT_PROVIDER_ID))
            .andExpect(jsonPath("$.providerName").value(DEFAULT_PROVIDER_NAME))
            .andExpect(jsonPath("$.providerStatusCode").value(DEFAULT_PROVIDER_STATUS_CODE))
            .andExpect(jsonPath("$.providerStatusText").value(DEFAULT_PROVIDER_STATUS_TEXT))
            .andExpect(jsonPath("$.providerStatusDescription").value(DEFAULT_PROVIDER_STATUS_DESCRIPTION))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.lastModifiedAt").value(DEFAULT_LAST_MODIFIED_AT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingClaretoProvider() throws Exception {
        // Get the claretoProvider
        restClaretoProviderMockMvc.perform(get("/api/clareto-providers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateClaretoProvider() throws Exception {
        // Initialize the database
        claretoProviderService.save(claretoProvider);

        int databaseSizeBeforeUpdate = claretoProviderRepository.findAll().size();

        // Update the claretoProvider
        ClaretoProvider updatedClaretoProvider = claretoProviderRepository.findById(claretoProvider.getId()).get();
        // Disconnect from session so that the updates on updatedClaretoProvider are not directly saved in db
        em.detach(updatedClaretoProvider);
        updatedClaretoProvider
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(UPDATED_CLARETO_PERSON_GUID)
            .status(UPDATED_STATUS)
            .claretoPersonId(UPDATED_CLARETO_PERSON_ID)
            .providerId(UPDATED_PROVIDER_ID)
            .providerName(UPDATED_PROVIDER_NAME)
            .providerStatusCode(UPDATED_PROVIDER_STATUS_CODE)
            .providerStatusText(UPDATED_PROVIDER_STATUS_TEXT)
            .providerStatusDescription(UPDATED_PROVIDER_STATUS_DESCRIPTION)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);

        restClaretoProviderMockMvc.perform(put("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedClaretoProvider)))
            .andExpect(status().isOk());

        // Validate the ClaretoProvider in the database
        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeUpdate);
        ClaretoProvider testClaretoProvider = claretoProviderList.get(claretoProviderList.size() - 1);
        assertThat(testClaretoProvider.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testClaretoProvider.getEhdOrderGuid()).isEqualTo(UPDATED_EHD_ORDER_GUID);
        assertThat(testClaretoProvider.getEhdEmpi()).isEqualTo(UPDATED_EHD_EMPI);
        assertThat(testClaretoProvider.getClaretoSearchGuid()).isEqualTo(UPDATED_CLARETO_SEARCH_GUID);
        assertThat(testClaretoProvider.getClaretoPersonGuid()).isEqualTo(UPDATED_CLARETO_PERSON_GUID);
        assertThat(testClaretoProvider.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testClaretoProvider.getClaretoPersonId()).isEqualTo(UPDATED_CLARETO_PERSON_ID);
        assertThat(testClaretoProvider.getProviderId()).isEqualTo(UPDATED_PROVIDER_ID);
        assertThat(testClaretoProvider.getProviderName()).isEqualTo(UPDATED_PROVIDER_NAME);
        assertThat(testClaretoProvider.getProviderStatusCode()).isEqualTo(UPDATED_PROVIDER_STATUS_CODE);
        assertThat(testClaretoProvider.getProviderStatusText()).isEqualTo(UPDATED_PROVIDER_STATUS_TEXT);
        assertThat(testClaretoProvider.getProviderStatusDescription()).isEqualTo(UPDATED_PROVIDER_STATUS_DESCRIPTION);
        assertThat(testClaretoProvider.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testClaretoProvider.getLastModifiedAt()).isEqualTo(UPDATED_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingClaretoProvider() throws Exception {
        int databaseSizeBeforeUpdate = claretoProviderRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restClaretoProviderMockMvc.perform(put("/api/clareto-providers").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoProvider)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoProvider in the database
        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteClaretoProvider() throws Exception {
        // Initialize the database
        claretoProviderService.save(claretoProvider);

        int databaseSizeBeforeDelete = claretoProviderRepository.findAll().size();

        // Delete the claretoProvider
        restClaretoProviderMockMvc.perform(delete("/api/clareto-providers/{id}", claretoProvider.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ClaretoProvider> claretoProviderList = claretoProviderRepository.findAll();
        assertThat(claretoProviderList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
