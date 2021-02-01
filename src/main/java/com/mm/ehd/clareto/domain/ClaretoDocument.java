package com.mm.ehd.clareto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

import com.mm.ehd.clareto.domain.enumeration.ClaretoStatus;

/**
 * A ClaretoDocument.
 */
@Entity
@Table(name = "clareto_document")
public class ClaretoDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "guid", nullable = false)
    private String guid;

    @Column(name = "ehd_order_guid")
    private String ehdOrderGuid;

    @Column(name = "ehd_empi")
    private String ehdEmpi;

    @Column(name = "clareto_search_guid")
    private String claretoSearchGuid;

    @Column(name = "clareto_person_guid")
    private String claretoPersonGuid;

    @Column(name = "clareto_provider_guid")
    private String claretoProviderGuid;

    @Column(name = "clareto_document_search_guid")
    private String claretoDocumentSearchGuid;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClaretoStatus status;

    @Column(name = "clareto_organization_id")
    private Integer claretoOrganizationId;

    @Column(name = "document_id")
    private String documentId;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_description")
    private String documentDescription;

    @Column(name = "document_status")
    private String documentStatus;

    @Column(name = "ccda_doc_store_guid")
    private String ccdaDocStoreGuid;

    @Column(name = "ecm_pdf_guid")
    private String ecmPdfGuid;

    @Column(name = "retry_count")
    private Integer retryCount;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "claretoDocuments", allowSetters = true)
    private ClaretoOrganization claretoOrganization;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public ClaretoDocument guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEhdOrderGuid() {
        return ehdOrderGuid;
    }

    public ClaretoDocument ehdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
        return this;
    }

    public void setEhdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
    }

    public String getEhdEmpi() {
        return ehdEmpi;
    }

    public ClaretoDocument ehdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
        return this;
    }

    public void setEhdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
    }

    public String getClaretoSearchGuid() {
        return claretoSearchGuid;
    }

    public ClaretoDocument claretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
        return this;
    }

    public void setClaretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
    }

    public String getClaretoPersonGuid() {
        return claretoPersonGuid;
    }

    public ClaretoDocument claretoPersonGuid(String claretoPersonGuid) {
        this.claretoPersonGuid = claretoPersonGuid;
        return this;
    }

    public void setClaretoPersonGuid(String claretoPersonGuid) {
        this.claretoPersonGuid = claretoPersonGuid;
    }

    public String getClaretoProviderGuid() {
        return claretoProviderGuid;
    }

    public ClaretoDocument claretoProviderGuid(String claretoProviderGuid) {
        this.claretoProviderGuid = claretoProviderGuid;
        return this;
    }

    public void setClaretoProviderGuid(String claretoProviderGuid) {
        this.claretoProviderGuid = claretoProviderGuid;
    }

    public String getClaretoDocumentSearchGuid() {
        return claretoDocumentSearchGuid;
    }

    public ClaretoDocument claretoDocumentSearchGuid(String claretoDocumentSearchGuid) {
        this.claretoDocumentSearchGuid = claretoDocumentSearchGuid;
        return this;
    }

    public void setClaretoDocumentSearchGuid(String claretoDocumentSearchGuid) {
        this.claretoDocumentSearchGuid = claretoDocumentSearchGuid;
    }

    public ClaretoStatus getStatus() {
        return status;
    }

    public ClaretoDocument status(ClaretoStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ClaretoStatus status) {
        this.status = status;
    }

    public Integer getClaretoOrganizationId() {
        return claretoOrganizationId;
    }

    public ClaretoDocument claretoOrganizationId(Integer claretoOrganizationId) {
        this.claretoOrganizationId = claretoOrganizationId;
        return this;
    }

    public void setClaretoOrganizationId(Integer claretoOrganizationId) {
        this.claretoOrganizationId = claretoOrganizationId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public ClaretoDocument documentId(String documentId) {
        this.documentId = documentId;
        return this;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public ClaretoDocument documentName(String documentName) {
        this.documentName = documentName;
        return this;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public ClaretoDocument documentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public ClaretoDocument documentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
        return this;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public ClaretoDocument documentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
        return this;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getCcdaDocStoreGuid() {
        return ccdaDocStoreGuid;
    }

    public ClaretoDocument ccdaDocStoreGuid(String ccdaDocStoreGuid) {
        this.ccdaDocStoreGuid = ccdaDocStoreGuid;
        return this;
    }

    public void setCcdaDocStoreGuid(String ccdaDocStoreGuid) {
        this.ccdaDocStoreGuid = ccdaDocStoreGuid;
    }

    public String getEcmPdfGuid() {
        return ecmPdfGuid;
    }

    public ClaretoDocument ecmPdfGuid(String ecmPdfGuid) {
        this.ecmPdfGuid = ecmPdfGuid;
        return this;
    }

    public void setEcmPdfGuid(String ecmPdfGuid) {
        this.ecmPdfGuid = ecmPdfGuid;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public ClaretoDocument retryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public ClaretoDocument createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public ClaretoDocument lastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
        return this;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public ClaretoOrganization getClaretoOrganization() {
        return claretoOrganization;
    }

    public ClaretoDocument claretoOrganization(ClaretoOrganization claretoOrganization) {
        this.claretoOrganization = claretoOrganization;
        return this;
    }

    public void setClaretoOrganization(ClaretoOrganization claretoOrganization) {
        this.claretoOrganization = claretoOrganization;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClaretoDocument)) {
            return false;
        }
        return id != null && id.equals(((ClaretoDocument) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClaretoDocument{" +
            "id=" + getId() +
            ", guid='" + getGuid() + "'" +
            ", ehdOrderGuid='" + getEhdOrderGuid() + "'" +
            ", ehdEmpi='" + getEhdEmpi() + "'" +
            ", claretoSearchGuid='" + getClaretoSearchGuid() + "'" +
            ", claretoPersonGuid='" + getClaretoPersonGuid() + "'" +
            ", claretoProviderGuid='" + getClaretoProviderGuid() + "'" +
            ", claretoDocumentSearchGuid='" + getClaretoDocumentSearchGuid() + "'" +
            ", status='" + getStatus() + "'" +
            ", claretoOrganizationId=" + getClaretoOrganizationId() +
            ", documentId='" + getDocumentId() + "'" +
            ", documentName='" + getDocumentName() + "'" +
            ", documentType='" + getDocumentType() + "'" +
            ", documentDescription='" + getDocumentDescription() + "'" +
            ", documentStatus='" + getDocumentStatus() + "'" +
            ", ccdaDocStoreGuid='" + getCcdaDocStoreGuid() + "'" +
            ", ecmPdfGuid='" + getEcmPdfGuid() + "'" +
            ", retryCount=" + getRetryCount() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", lastModifiedAt='" + getLastModifiedAt() + "'" +
            "}";
    }
}
