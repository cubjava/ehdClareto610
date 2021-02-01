package com.mm.ehd.clareto.web.rest;

import com.mm.ehd.clareto.EhdClareto610App;
import com.mm.ehd.clareto.config.TestSecurityConfiguration;
import com.mm.ehd.clareto.domain.ClaretoDocument;
import com.mm.ehd.clareto.repository.ClaretoDocumentRepository;
import com.mm.ehd.clareto.service.ClaretoDocumentService;

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
 * Integration tests for the {@link ClaretoDocumentResource} REST controller.
 */
@SpringBootTest(classes = { EhdClareto610App.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ClaretoDocumentResourceIT {

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

    private static final String DEFAULT_CLARETO_DOCUMENT_SEARCH_GUID = "AAAAAAAAAA";
    private static final String UPDATED_CLARETO_DOCUMENT_SEARCH_GUID = "BBBBBBBBBB";

    private static final ClaretoStatus DEFAULT_STATUS = ClaretoStatus.NEW;
    private static final ClaretoStatus UPDATED_STATUS = ClaretoStatus.RECEIVED;

    private static final Integer DEFAULT_CLARETO_ORGANIZATION_ID = 1;
    private static final Integer UPDATED_CLARETO_ORGANIZATION_ID = 2;

    private static final String DEFAULT_DOCUMENT_ID = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_CCDA_DOC_STORE_GUID = "AAAAAAAAAA";
    private static final String UPDATED_CCDA_DOC_STORE_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_ECM_PDF_GUID = "AAAAAAAAAA";
    private static final String UPDATED_ECM_PDF_GUID = "BBBBBBBBBB";

    private static final Integer DEFAULT_RETRY_COUNT = 1;
    private static final Integer UPDATED_RETRY_COUNT = 2;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_LAST_MODIFIED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_MODIFIED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ClaretoDocumentRepository claretoDocumentRepository;

    @Autowired
    private ClaretoDocumentService claretoDocumentService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restClaretoDocumentMockMvc;

    private ClaretoDocument claretoDocument;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoDocument createEntity(EntityManager em) {
        ClaretoDocument claretoDocument = new ClaretoDocument()
            .guid(DEFAULT_GUID)
            .ehdOrderGuid(DEFAULT_EHD_ORDER_GUID)
            .ehdEmpi(DEFAULT_EHD_EMPI)
            .claretoSearchGuid(DEFAULT_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(DEFAULT_CLARETO_PERSON_GUID)
            .claretoProviderGuid(DEFAULT_CLARETO_PROVIDER_GUID)
            .claretoDocumentSearchGuid(DEFAULT_CLARETO_DOCUMENT_SEARCH_GUID)
            .status(DEFAULT_STATUS)
            .claretoOrganizationId(DEFAULT_CLARETO_ORGANIZATION_ID)
            .documentId(DEFAULT_DOCUMENT_ID)
            .documentName(DEFAULT_DOCUMENT_NAME)
            .documentType(DEFAULT_DOCUMENT_TYPE)
            .documentDescription(DEFAULT_DOCUMENT_DESCRIPTION)
            .documentStatus(DEFAULT_DOCUMENT_STATUS)
            .ccdaDocStoreGuid(DEFAULT_CCDA_DOC_STORE_GUID)
            .ecmPdfGuid(DEFAULT_ECM_PDF_GUID)
            .retryCount(DEFAULT_RETRY_COUNT)
            .createdAt(DEFAULT_CREATED_AT)
            .lastModifiedAt(DEFAULT_LAST_MODIFIED_AT);
        return claretoDocument;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ClaretoDocument createUpdatedEntity(EntityManager em) {
        ClaretoDocument claretoDocument = new ClaretoDocument()
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(UPDATED_CLARETO_PERSON_GUID)
            .claretoProviderGuid(UPDATED_CLARETO_PROVIDER_GUID)
            .claretoDocumentSearchGuid(UPDATED_CLARETO_DOCUMENT_SEARCH_GUID)
            .status(UPDATED_STATUS)
            .claretoOrganizationId(UPDATED_CLARETO_ORGANIZATION_ID)
            .documentId(UPDATED_DOCUMENT_ID)
            .documentName(UPDATED_DOCUMENT_NAME)
            .documentType(UPDATED_DOCUMENT_TYPE)
            .documentDescription(UPDATED_DOCUMENT_DESCRIPTION)
            .documentStatus(UPDATED_DOCUMENT_STATUS)
            .ccdaDocStoreGuid(UPDATED_CCDA_DOC_STORE_GUID)
            .ecmPdfGuid(UPDATED_ECM_PDF_GUID)
            .retryCount(UPDATED_RETRY_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);
        return claretoDocument;
    }

    @BeforeEach
    public void initTest() {
        claretoDocument = createEntity(em);
    }

    @Test
    @Transactional
    public void createClaretoDocument() throws Exception {
        int databaseSizeBeforeCreate = claretoDocumentRepository.findAll().size();
        // Create the ClaretoDocument
        restClaretoDocumentMockMvc.perform(post("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoDocument)))
            .andExpect(status().isCreated());

        // Validate the ClaretoDocument in the database
        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeCreate + 1);
        ClaretoDocument testClaretoDocument = claretoDocumentList.get(claretoDocumentList.size() - 1);
        assertThat(testClaretoDocument.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testClaretoDocument.getEhdOrderGuid()).isEqualTo(DEFAULT_EHD_ORDER_GUID);
        assertThat(testClaretoDocument.getEhdEmpi()).isEqualTo(DEFAULT_EHD_EMPI);
        assertThat(testClaretoDocument.getClaretoSearchGuid()).isEqualTo(DEFAULT_CLARETO_SEARCH_GUID);
        assertThat(testClaretoDocument.getClaretoPersonGuid()).isEqualTo(DEFAULT_CLARETO_PERSON_GUID);
        assertThat(testClaretoDocument.getClaretoProviderGuid()).isEqualTo(DEFAULT_CLARETO_PROVIDER_GUID);
        assertThat(testClaretoDocument.getClaretoDocumentSearchGuid()).isEqualTo(DEFAULT_CLARETO_DOCUMENT_SEARCH_GUID);
        assertThat(testClaretoDocument.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testClaretoDocument.getClaretoOrganizationId()).isEqualTo(DEFAULT_CLARETO_ORGANIZATION_ID);
        assertThat(testClaretoDocument.getDocumentId()).isEqualTo(DEFAULT_DOCUMENT_ID);
        assertThat(testClaretoDocument.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
        assertThat(testClaretoDocument.getDocumentType()).isEqualTo(DEFAULT_DOCUMENT_TYPE);
        assertThat(testClaretoDocument.getDocumentDescription()).isEqualTo(DEFAULT_DOCUMENT_DESCRIPTION);
        assertThat(testClaretoDocument.getDocumentStatus()).isEqualTo(DEFAULT_DOCUMENT_STATUS);
        assertThat(testClaretoDocument.getCcdaDocStoreGuid()).isEqualTo(DEFAULT_CCDA_DOC_STORE_GUID);
        assertThat(testClaretoDocument.getEcmPdfGuid()).isEqualTo(DEFAULT_ECM_PDF_GUID);
        assertThat(testClaretoDocument.getRetryCount()).isEqualTo(DEFAULT_RETRY_COUNT);
        assertThat(testClaretoDocument.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testClaretoDocument.getLastModifiedAt()).isEqualTo(DEFAULT_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void createClaretoDocumentWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = claretoDocumentRepository.findAll().size();

        // Create the ClaretoDocument with an existing ID
        claretoDocument.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restClaretoDocumentMockMvc.perform(post("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoDocument)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoDocument in the database
        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkGuidIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoDocumentRepository.findAll().size();
        // set the field null
        claretoDocument.setGuid(null);

        // Create the ClaretoDocument, which fails.


        restClaretoDocumentMockMvc.perform(post("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoDocument)))
            .andExpect(status().isBadRequest());

        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoDocumentRepository.findAll().size();
        // set the field null
        claretoDocument.setStatus(null);

        // Create the ClaretoDocument, which fails.


        restClaretoDocumentMockMvc.perform(post("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoDocument)))
            .andExpect(status().isBadRequest());

        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreatedAtIsRequired() throws Exception {
        int databaseSizeBeforeTest = claretoDocumentRepository.findAll().size();
        // set the field null
        claretoDocument.setCreatedAt(null);

        // Create the ClaretoDocument, which fails.


        restClaretoDocumentMockMvc.perform(post("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoDocument)))
            .andExpect(status().isBadRequest());

        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllClaretoDocuments() throws Exception {
        // Initialize the database
        claretoDocumentRepository.saveAndFlush(claretoDocument);

        // Get all the claretoDocumentList
        restClaretoDocumentMockMvc.perform(get("/api/clareto-documents?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(claretoDocument.getId().intValue())))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)))
            .andExpect(jsonPath("$.[*].ehdOrderGuid").value(hasItem(DEFAULT_EHD_ORDER_GUID)))
            .andExpect(jsonPath("$.[*].ehdEmpi").value(hasItem(DEFAULT_EHD_EMPI)))
            .andExpect(jsonPath("$.[*].claretoSearchGuid").value(hasItem(DEFAULT_CLARETO_SEARCH_GUID)))
            .andExpect(jsonPath("$.[*].claretoPersonGuid").value(hasItem(DEFAULT_CLARETO_PERSON_GUID)))
            .andExpect(jsonPath("$.[*].claretoProviderGuid").value(hasItem(DEFAULT_CLARETO_PROVIDER_GUID)))
            .andExpect(jsonPath("$.[*].claretoDocumentSearchGuid").value(hasItem(DEFAULT_CLARETO_DOCUMENT_SEARCH_GUID)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].claretoOrganizationId").value(hasItem(DEFAULT_CLARETO_ORGANIZATION_ID)))
            .andExpect(jsonPath("$.[*].documentId").value(hasItem(DEFAULT_DOCUMENT_ID)))
            .andExpect(jsonPath("$.[*].documentName").value(hasItem(DEFAULT_DOCUMENT_NAME)))
            .andExpect(jsonPath("$.[*].documentType").value(hasItem(DEFAULT_DOCUMENT_TYPE)))
            .andExpect(jsonPath("$.[*].documentDescription").value(hasItem(DEFAULT_DOCUMENT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].documentStatus").value(hasItem(DEFAULT_DOCUMENT_STATUS)))
            .andExpect(jsonPath("$.[*].ccdaDocStoreGuid").value(hasItem(DEFAULT_CCDA_DOC_STORE_GUID)))
            .andExpect(jsonPath("$.[*].ecmPdfGuid").value(hasItem(DEFAULT_ECM_PDF_GUID)))
            .andExpect(jsonPath("$.[*].retryCount").value(hasItem(DEFAULT_RETRY_COUNT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedAt").value(hasItem(DEFAULT_LAST_MODIFIED_AT.toString())));
    }
    
    @Test
    @Transactional
    public void getClaretoDocument() throws Exception {
        // Initialize the database
        claretoDocumentRepository.saveAndFlush(claretoDocument);

        // Get the claretoDocument
        restClaretoDocumentMockMvc.perform(get("/api/clareto-documents/{id}", claretoDocument.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(claretoDocument.getId().intValue()))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID))
            .andExpect(jsonPath("$.ehdOrderGuid").value(DEFAULT_EHD_ORDER_GUID))
            .andExpect(jsonPath("$.ehdEmpi").value(DEFAULT_EHD_EMPI))
            .andExpect(jsonPath("$.claretoSearchGuid").value(DEFAULT_CLARETO_SEARCH_GUID))
            .andExpect(jsonPath("$.claretoPersonGuid").value(DEFAULT_CLARETO_PERSON_GUID))
            .andExpect(jsonPath("$.claretoProviderGuid").value(DEFAULT_CLARETO_PROVIDER_GUID))
            .andExpect(jsonPath("$.claretoDocumentSearchGuid").value(DEFAULT_CLARETO_DOCUMENT_SEARCH_GUID))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.claretoOrganizationId").value(DEFAULT_CLARETO_ORGANIZATION_ID))
            .andExpect(jsonPath("$.documentId").value(DEFAULT_DOCUMENT_ID))
            .andExpect(jsonPath("$.documentName").value(DEFAULT_DOCUMENT_NAME))
            .andExpect(jsonPath("$.documentType").value(DEFAULT_DOCUMENT_TYPE))
            .andExpect(jsonPath("$.documentDescription").value(DEFAULT_DOCUMENT_DESCRIPTION))
            .andExpect(jsonPath("$.documentStatus").value(DEFAULT_DOCUMENT_STATUS))
            .andExpect(jsonPath("$.ccdaDocStoreGuid").value(DEFAULT_CCDA_DOC_STORE_GUID))
            .andExpect(jsonPath("$.ecmPdfGuid").value(DEFAULT_ECM_PDF_GUID))
            .andExpect(jsonPath("$.retryCount").value(DEFAULT_RETRY_COUNT))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.lastModifiedAt").value(DEFAULT_LAST_MODIFIED_AT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingClaretoDocument() throws Exception {
        // Get the claretoDocument
        restClaretoDocumentMockMvc.perform(get("/api/clareto-documents/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateClaretoDocument() throws Exception {
        // Initialize the database
        claretoDocumentService.save(claretoDocument);

        int databaseSizeBeforeUpdate = claretoDocumentRepository.findAll().size();

        // Update the claretoDocument
        ClaretoDocument updatedClaretoDocument = claretoDocumentRepository.findById(claretoDocument.getId()).get();
        // Disconnect from session so that the updates on updatedClaretoDocument are not directly saved in db
        em.detach(updatedClaretoDocument);
        updatedClaretoDocument
            .guid(UPDATED_GUID)
            .ehdOrderGuid(UPDATED_EHD_ORDER_GUID)
            .ehdEmpi(UPDATED_EHD_EMPI)
            .claretoSearchGuid(UPDATED_CLARETO_SEARCH_GUID)
            .claretoPersonGuid(UPDATED_CLARETO_PERSON_GUID)
            .claretoProviderGuid(UPDATED_CLARETO_PROVIDER_GUID)
            .claretoDocumentSearchGuid(UPDATED_CLARETO_DOCUMENT_SEARCH_GUID)
            .status(UPDATED_STATUS)
            .claretoOrganizationId(UPDATED_CLARETO_ORGANIZATION_ID)
            .documentId(UPDATED_DOCUMENT_ID)
            .documentName(UPDATED_DOCUMENT_NAME)
            .documentType(UPDATED_DOCUMENT_TYPE)
            .documentDescription(UPDATED_DOCUMENT_DESCRIPTION)
            .documentStatus(UPDATED_DOCUMENT_STATUS)
            .ccdaDocStoreGuid(UPDATED_CCDA_DOC_STORE_GUID)
            .ecmPdfGuid(UPDATED_ECM_PDF_GUID)
            .retryCount(UPDATED_RETRY_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .lastModifiedAt(UPDATED_LAST_MODIFIED_AT);

        restClaretoDocumentMockMvc.perform(put("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedClaretoDocument)))
            .andExpect(status().isOk());

        // Validate the ClaretoDocument in the database
        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeUpdate);
        ClaretoDocument testClaretoDocument = claretoDocumentList.get(claretoDocumentList.size() - 1);
        assertThat(testClaretoDocument.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testClaretoDocument.getEhdOrderGuid()).isEqualTo(UPDATED_EHD_ORDER_GUID);
        assertThat(testClaretoDocument.getEhdEmpi()).isEqualTo(UPDATED_EHD_EMPI);
        assertThat(testClaretoDocument.getClaretoSearchGuid()).isEqualTo(UPDATED_CLARETO_SEARCH_GUID);
        assertThat(testClaretoDocument.getClaretoPersonGuid()).isEqualTo(UPDATED_CLARETO_PERSON_GUID);
        assertThat(testClaretoDocument.getClaretoProviderGuid()).isEqualTo(UPDATED_CLARETO_PROVIDER_GUID);
        assertThat(testClaretoDocument.getClaretoDocumentSearchGuid()).isEqualTo(UPDATED_CLARETO_DOCUMENT_SEARCH_GUID);
        assertThat(testClaretoDocument.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testClaretoDocument.getClaretoOrganizationId()).isEqualTo(UPDATED_CLARETO_ORGANIZATION_ID);
        assertThat(testClaretoDocument.getDocumentId()).isEqualTo(UPDATED_DOCUMENT_ID);
        assertThat(testClaretoDocument.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testClaretoDocument.getDocumentType()).isEqualTo(UPDATED_DOCUMENT_TYPE);
        assertThat(testClaretoDocument.getDocumentDescription()).isEqualTo(UPDATED_DOCUMENT_DESCRIPTION);
        assertThat(testClaretoDocument.getDocumentStatus()).isEqualTo(UPDATED_DOCUMENT_STATUS);
        assertThat(testClaretoDocument.getCcdaDocStoreGuid()).isEqualTo(UPDATED_CCDA_DOC_STORE_GUID);
        assertThat(testClaretoDocument.getEcmPdfGuid()).isEqualTo(UPDATED_ECM_PDF_GUID);
        assertThat(testClaretoDocument.getRetryCount()).isEqualTo(UPDATED_RETRY_COUNT);
        assertThat(testClaretoDocument.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testClaretoDocument.getLastModifiedAt()).isEqualTo(UPDATED_LAST_MODIFIED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingClaretoDocument() throws Exception {
        int databaseSizeBeforeUpdate = claretoDocumentRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restClaretoDocumentMockMvc.perform(put("/api/clareto-documents").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(claretoDocument)))
            .andExpect(status().isBadRequest());

        // Validate the ClaretoDocument in the database
        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteClaretoDocument() throws Exception {
        // Initialize the database
        claretoDocumentService.save(claretoDocument);

        int databaseSizeBeforeDelete = claretoDocumentRepository.findAll().size();

        // Delete the claretoDocument
        restClaretoDocumentMockMvc.perform(delete("/api/clareto-documents/{id}", claretoDocument.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ClaretoDocument> claretoDocumentList = claretoDocumentRepository.findAll();
        assertThat(claretoDocumentList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
