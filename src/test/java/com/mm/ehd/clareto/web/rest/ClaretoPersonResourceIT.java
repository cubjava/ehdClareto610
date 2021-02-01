package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.EhdClareto610App;
import com.mm.ehd.clareto.config.TestSecurityConfiguration;
import com.mm.ehd.clareto.domain.ClaretoPerson;
import com.mm.ehd.clareto.repository.ClaretoPersonRepository;
import com.mm.ehd.clareto.service.ClaretoPersonService;

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
 * Integration tests for the {@link ClaretoPersonResource} REST controller.
 */
@SpringBootTest(classes = { EhdClareto610App.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ClaretoPersonResourceIT {

    private static final String DEFAULT_GUID = "AAAAAAAAAA";
    private static final String UPDATED_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_EHD_ORDER_GUID = "AAAAAAAAAA";
    private static final String UPDATED_EHD_ORDER_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_EHD_EMPI = "AAAAAAAAAA";
    private static final String UPDATED_EHD_EMPI = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDER_WORKFLOW_GUID = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_WORKFLOW_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDER_DATA = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER_DATA = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_SEARCH_GUID = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_SEARCH_GUID = "BBBBBBBBBB";

    private static final ClaretoStatus DEFAULT_STATUS = ClaretoStatus.NEW;
    private static final ClaretoStatus UPDATED_STATUS = ClaretoStatus.RECEIVED;

    private static final String DEFAULT_HIPAA_DOC_STORE_GUID = "AAAAAAAAAA";
    private static final String UPDATED_HIPAA_DOC_STORE_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_PAYLOAD = "AAAAAAAAAA";
    private static final String UPDATED_PAYLOAD = "BBBBBBBBBB";

    private static final String DEFAULT_RESPONSE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RESPONSE_MSG = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSE_MSG = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_STATUS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_STATUS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_STATUS_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_STATUS_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_CLARETO_STATUS_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_STATUS_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_RETRY_COUNT = 1;
    private static final Integer UPDATED_RETRY_COUNT = 2;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_LAST_MODIFIED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_MODIFIED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ClaretoPersonRepository claretoPersonRepository;

    @Autowired
    private ClaretoPersonService claretoPersonService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restClaretoPersonMockMvc;

    private ClaretoPerson claretoPerson;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoPerson createEntity(EntityManager em) {
        ClaretoPerson claretoPerson = new ClaretoPerson()
            .guid(DEFAULT_GUID)
            .ehdOrderGuid(DEFAULT_EHD_ORDER_GUID)
            .ehdEmpi(DEFAULT_EHD_EMPI)
            .providerWorkflowGuid(DEFAULT_PROVIDER_WORKFLOW_GUID)
            .providerData(DEFAULT_PROVIDER_DATA)
            .claretoSearchGuid(DEFAULT_CLARETO_SEARCH_GUID)
            .status(DEFAULT_STATUS)
            .hipaaDocStoreGuid(DEFAULT_HIPAA_DOC_STORE_GUID)
            .payload(DEFAULT_PAYLOAD)
            .responseCode(DEFAULT_RESPONSE_CODE)
            .responseMsg(DEFAULT_RESPONSE_MSG)
            .claretoStatusCode(DEFAULT_CLARETO_STATUS_CODE)
            .claretoStatusText(DEFAULT_CLARETO_STATUS_TEXT)
            .claretoStatusDescription(DEFAULT_CLARETO_STATUS_DESCRIPTION)
            .retryCount(DEFAULT_RETRY_COUNT)
            .createdAt(DEFAULT_CREATED_AT)
            .lastModifiedAt(DEFAULT_LAST_MODIFIED_AT);
        return claretoPerson;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoPerson createUpdatedEntity(EntityManager em) {
        ClaretoPerson claretoPerson = new ClaretoPerson()
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .providerWorkflowGuid(UPDATED_PROVIDER_WORKFLOW_GUID)
            .providerData(UPDATED_PROVIDER_DATA)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .status(UPDATED_STATUS)
            .hipaaDocStoreGuid(UPDATED_HIPAA_DOC_STORE_GUID)
            .payload(UPDATED_PAYLOAD)
            .responseCode(UPDATED_RESPONSE_CODE)
            .responseMsg(UPDATED_RESPONSE_MSG)
            .claretoStatusCode(UPDATED_CLARETO_STATUS_CODE)
            .claretoStatusText(UPDATED_CLARETO_STATUS_TEXT)
            .claretoStatusDescription(UPDATED_CLARETO_STATUS_DESCRIPTION)
            .retryCount(UPDATED_RETRY_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);
        return claretoPerson;
    }

    @BeforeEach
    public void initTest() {
        claretoPerson = createEntity(em);
    }

    @Test
    @Transactional
    public void createClaretoPerson() throws Exception {
        int databaseSizeBeforeCreate = claretoPersonRepository.findAll().size();
        // Create the ClaretoPerson
        restClaretoPersonMockMvc.perform(post("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isCreated());

        // Validate the ClaretoPerson in the database
        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeCreate + 1);
        ClaretoPerson testClaretoPerson = claretoPersonList.get(claretoPersonList.size() - 1);
        assertThat(testClaretoPerson.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testClaretoPerson.getEhdOrderGuid()).isEqualTo(DEFAULT_EHD_ORDER_GUID);
        assertThat(testClaretoPerson.getEhdEmpi()).isEqualTo(DEFAULT_EHD_EMPI);
        assertThat(testClaretoPerson.getProviderWorkflowGuid()).isEqualTo(DEFAULT_PROVIDER_WORKFLOW_GUID);
        assertThat(testClaretoPerson.getProviderData()).isEqualTo(DEFAULT_PROVIDER_DATA);
        assertThat(testClaretoPerson.getClaretoSearchGuid()).isEqualTo(DEFAULT_CLARETO_SEARCH_GUID);
        assertThat(testClaretoPerson.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testClaretoPerson.getHipaaDocStoreGuid()).isEqualTo(DEFAULT_HIPAA_DOC_STORE_GUID);
        assertThat(testClaretoPerson.getPayload()).isEqualTo(DEFAULT_PAYLOAD);
        assertThat(testClaretoPerson.getResponseCode()).isEqualTo(DEFAULT_RESPONSE_CODE);
        assertThat(testClaretoPerson.getResponseMsg()).isEqualTo(DEFAULT_RESPONSE_MSG);
        assertThat(testClaretoPerson.getClaretoStatusCode()).isEqualTo(DEFAULT_CLARETO_STATUS_CODE);
        assertThat(testClaretoPerson.getClaretoStatusText()).isEqualTo(DEFAULT_CLARETO_STATUS_TEXT);
        assertThat(testClaretoPerson.getClaretoStatusDescription()).isEqualTo(DEFAULT_CLARETO_STATUS_DESCRIPTION);
        assertThat(testClaretoPerson.getRetryCount()).isEqualTo(DEFAULT_RETRY_COUNT);
        assertThat(testClaretoPerson.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testClaretoPerson.getLastModifiedAt()).isEqualTo(DEFAULT_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void createClaretoPersonWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = claretoPersonRepository.findAll().size();

        // Create the ClaretoPerson with an existing ID
        claretoPerson.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restClaretoPersonMockMvc.perform(post("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoPerson in the database
        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkGuidIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoPersonRepository.findAll().size();
        // set the field null
        claretoPerson.setGuid(null);

        // Create the ClaretoPerson, which fails.


        restClaretoPersonMockMvc.perform(post("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isBadRequest());

        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEhdOrderGuidIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoPersonRepository.findAll().size();
        // set the field null
        claretoPerson.setEhdOrderGuid(null);

        // Create the ClaretoPerson, which fails.


        restClaretoPersonMockMvc.perform(post("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isBadRequest());

        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoPersonRepository.findAll().size();
        // set the field null
        claretoPerson.setStatus(null);

        // Create the ClaretoPerson, which fails.


        restClaretoPersonMockMvc.perform(post("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isBadRequest());

        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreatedAtIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoPersonRepository.findAll().size();
        // set the field null
        claretoPerson.setCreatedAt(null);

        // Create the ClaretoPerson, which fails.


        restClaretoPersonMockMvc.perform(post("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isBadRequest());

        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllClaretoPeople() throws Exception {
        // Initialize the database
        claretoPersonRepository.saveAndFlush(claretoPerson);

        // Get all the claretoPersonList
        restClaretoPersonMockMvc.perform(get("/api/clareto-people?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(claretoPerson.getId().intValue())))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)))
            .andExpect(jsonPath("$.[*].ehdOrderGuid").value(hasItem(DEFAULT_EHD_ORDER_GUID)))
            .andExpect(jsonPath("$.[*].ehdEmpi").value(hasItem(DEFAULT_EHD_EMPI)))
            .andExpect(jsonPath("$.[*].providerWorkflowGuid").value(hasItem(DEFAULT_PROVIDER_WORKFLOW_GUID)))
            .andExpect(jsonPath("$.[*].providerData").value(hasItem(DEFAULT_PROVIDER_DATA)))
            .andExpect(jsonPath("$.[*].claretoSearchGuid").value(hasItem(DEFAULT_CLARETO_SEARCH_GUID)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].hipaaDocStoreGuid").value(hasItem(DEFAULT_HIPAA_DOC_STORE_GUID)))
            .andExpect(jsonPath("$.[*].payload").value(hasItem(DEFAULT_PAYLOAD)))
            .andExpect(jsonPath("$.[*].responseCode").value(hasItem(DEFAULT_RESPONSE_CODE)))
            .andExpect(jsonPath("$.[*].responseMsg").value(hasItem(DEFAULT_RESPONSE_MSG)))
            .andExpect(jsonPath("$.[*].claretoStatusCode").value(hasItem(DEFAULT_CLARETO_STATUS_CODE)))
            .andExpect(jsonPath("$.[*].claretoStatusText").value(hasItem(DEFAULT_CLARETO_STATUS_TEXT)))
            .andExpect(jsonPath("$.[*].claretoStatusDescription").value(hasItem(DEFAULT_CLARETO_STATUS_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].retryCount").value(hasItem(DEFAULT_RETRY_COUNT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedAt").value(hasItem(DEFAULT_LAST_MODIFIED_AT.toString())));
    }
    
    @Test
    @Transactional
    public void getClaretoPerson() throws Exception {
        // Initialize the database
        claretoPersonRepository.saveAndFlush(claretoPerson);

        // Get the claretoPerson
        restClaretoPersonMockMvc.perform(get("/api/clareto-people/{id}", claretoPerson.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(claretoPerson.getId().intValue()))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID))
            .andExpect(jsonPath("$.ehdOrderGuid").value(DEFAULT_EHD_ORDER_GUID))
            .andExpect(jsonPath("$.ehdEmpi").value(DEFAULT_EHD_EMPI))
            .andExpect(jsonPath("$.providerWorkflowGuid").value(DEFAULT_PROVIDER_WORKFLOW_GUID))
            .andExpect(jsonPath("$.providerData").value(DEFAULT_PROVIDER_DATA))
            .andExpect(jsonPath("$.claretoSearchGuid").value(DEFAULT_CLARETO_SEARCH_GUID))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.hipaaDocStoreGuid").value(DEFAULT_HIPAA_DOC_STORE_GUID))
            .andExpect(jsonPath("$.payload").value(DEFAULT_PAYLOAD))
            .andExpect(jsonPath("$.responseCode").value(DEFAULT_RESPONSE_CODE))
            .andExpect(jsonPath("$.responseMsg").value(DEFAULT_RESPONSE_MSG))
            .andExpect(jsonPath("$.claretoStatusCode").value(DEFAULT_CLARETO_STATUS_CODE))
            .andExpect(jsonPath("$.claretoStatusText").value(DEFAULT_CLARETO_STATUS_TEXT))
            .andExpect(jsonPath("$.claretoStatusDescription").value(DEFAULT_CLARETO_STATUS_DESCRIPTION))
            .andExpect(jsonPath("$.retryCount").value(DEFAULT_RETRY_COUNT))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.lastModifiedAt").value(DEFAULT_LAST_MODIFIED_AT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingClaretoPerson() throws Exception {
        // Get the claretoPerson
        restClaretoPersonMockMvc.perform(get("/api/clareto-people/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateClaretoPerson() throws Exception {
        // Initialize the database
        claretoPersonService.save(claretoPerson);

        int databaseSizeBeforeUpdate = claretoPersonRepository.findAll().size();

        // Update the claretoPerson
        ClaretoPerson updatedClaretoPerson = claretoPersonRepository.findById(claretoPerson.getId()).get();
        // Disconnect from session so that the updates on updatedClaretoPerson are not directly saved in db
        em.detach(updatedClaretoPerson);
        updatedClaretoPerson
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .providerWorkflowGuid(UPDATED_PROVIDER_WORKFLOW_GUID)
            .providerData(UPDATED_PROVIDER_DATA)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .status(UPDATED_STATUS)
            .hipaaDocStoreGuid(UPDATED_HIPAA_DOC_STORE_GUID)
            .payload(UPDATED_PAYLOAD)
            .responseCode(UPDATED_RESPONSE_CODE)
            .responseMsg(UPDATED_RESPONSE_MSG)
            .claretoStatusCode(UPDATED_CLARETO_STATUS_CODE)
            .claretoStatusText(UPDATED_CLARETO_STATUS_TEXT)
            .claretoStatusDescription(UPDATED_CLARETO_STATUS_DESCRIPTION)
            .retryCount(UPDATED_RETRY_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);

        restClaretoPersonMockMvc.perform(put("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedClaretoPerson)))
            .andExpect(status().isOk());

        // Validate the ClaretoPerson in the database
        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeUpdate);
        ClaretoPerson testClaretoPerson = claretoPersonList.get(claretoPersonList.size() - 1);
        assertThat(testClaretoPerson.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testClaretoPerson.getEhdOrderGuid()).isEqualTo(UPDATED_EHD_ORDER_GUID);
        assertThat(testClaretoPerson.getEhdEmpi()).isEqualTo(UPDATED_EHD_EMPI);
        assertThat(testClaretoPerson.getProviderWorkflowGuid()).isEqualTo(UPDATED_PROVIDER_WORKFLOW_GUID);
        assertThat(testClaretoPerson.getProviderData()).isEqualTo(UPDATED_PROVIDER_DATA);
        assertThat(testClaretoPerson.getClaretoSearchGuid()).isEqualTo(UPDATED_CLARETO_SEARCH_GUID);
        assertThat(testClaretoPerson.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testClaretoPerson.getHipaaDocStoreGuid()).isEqualTo(UPDATED_HIPAA_DOC_STORE_GUID);
        assertThat(testClaretoPerson.getPayload()).isEqualTo(UPDATED_PAYLOAD);
        assertThat(testClaretoPerson.getResponseCode()).isEqualTo(UPDATED_RESPONSE_CODE);
        assertThat(testClaretoPerson.getResponseMsg()).isEqualTo(UPDATED_RESPONSE_MSG);
        assertThat(testClaretoPerson.getClaretoStatusCode()).isEqualTo(UPDATED_CLARETO_STATUS_CODE);
        assertThat(testClaretoPerson.getClaretoStatusText()).isEqualTo(UPDATED_CLARETO_STATUS_TEXT);
        assertThat(testClaretoPerson.getClaretoStatusDescription()).isEqualTo(UPDATED_CLARETO_STATUS_DESCRIPTION);
        assertThat(testClaretoPerson.getRetryCount()).isEqualTo(UPDATED_RETRY_COUNT);
        assertThat(testClaretoPerson.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testClaretoPerson.getLastModifiedAt()).isEqualTo(UPDATED_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingClaretoPerson() throws Exception {
        int databaseSizeBeforeUpdate = claretoPersonRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restClaretoPersonMockMvc.perform(put("/api/clareto-people").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoPerson)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoPerson in the database
        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteClaretoPerson() throws Exception {
        // Initialize the database
        claretoPersonService.save(claretoPerson);

        int databaseSizeBeforeDelete = claretoPersonRepository.findAll().size();

        // Delete the claretoPerson
        restClaretoPersonMockMvc.perform(delete("/api/clareto-people/{id}", claretoPerson.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ClaretoPerson> claretoPersonList = claretoPersonRepository.findAll();
        assertThat(claretoPersonList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
