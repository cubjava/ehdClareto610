package com.mm.ehd.clareto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

import com.mm.ehd.clareto.domain.enumeration.ClaretoStatus;

/**
 * A ClaretoOrganization.
 */
@Entity
@Table(name = "clareto_organization")
public class ClaretoOrganization implements Serializable {

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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClaretoStatus status;

    @Column(name = "clareto_provider_id")
    private Integer claretoProviderId;

    @Column(name = "organization_id")
    private String organizationId;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "special_auth_doc_store_guid")
    private String specialAuthDocStoreGuid;

    @Column(name = "retry_count")
    private Integer retryCount;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "claretoOrganizations", allowSetters = true)
    private ClaretoProvider claretoProvider;

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

    public ClaretoOrganization guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEhdOrderGuid() {
        return ehdOrderGuid;
    }

    public ClaretoOrganization ehdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
        return this;
    }

    public void setEhdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
    }

    public String getEhdEmpi() {
        return ehdEmpi;
    }

    public ClaretoOrganization ehdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
        return this;
    }

    public void setEhdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
    }

    public String getClaretoSearchGuid() {
        return claretoSearchGuid;
    }

    public ClaretoOrganization claretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
        return this;
    }

    public void setClaretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
    }

    public String getClaretoPersonGuid() {
        return claretoPersonGuid;
    }

    public ClaretoOrganization claretoPersonGuid(String claretoPersonGuid) {
        this.claretoPersonGuid = claretoPersonGuid;
        return this;
    }

    public void setClaretoPersonGuid(String claretoPersonGuid) {
        this.claretoPersonGuid = claretoPersonGuid;
    }

    public String getClaretoProviderGuid() {
        return claretoProviderGuid;
    }

    public ClaretoOrganization claretoProviderGuid(String claretoProviderGuid) {
        this.claretoProviderGuid = claretoProviderGuid;
        return this;
    }

    public void setClaretoProviderGuid(String claretoProviderGuid) {
        this.claretoProviderGuid = claretoProviderGuid;
    }

    public ClaretoStatus getStatus() {
        return status;
    }

    public ClaretoOrganization status(ClaretoStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ClaretoStatus status) {
        this.status = status;
    }

    public Integer getClaretoProviderId() {
        return claretoProviderId;
    }

    public ClaretoOrganization claretoProviderId(Integer claretoProviderId) {
        this.claretoProviderId = claretoProviderId;
        return this;
    }

    public void setClaretoProviderId(Integer claretoProviderId) {
        this.claretoProviderId = claretoProviderId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public ClaretoOrganization organizationId(String organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public ClaretoOrganization organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getSpecialAuthDocStoreGuid() {
        return specialAuthDocStoreGuid;
    }

    public ClaretoOrganization specialAuthDocStoreGuid(String specialAuthDocStoreGuid) {
        this.specialAuthDocStoreGuid = specialAuthDocStoreGuid;
        return this;
    }

    public void setSpecialAuthDocStoreGuid(String specialAuthDocStoreGuid) {
        this.specialAuthDocStoreGuid = specialAuthDocStoreGuid;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public ClaretoOrganization retryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public ClaretoOrganization createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public ClaretoOrganization lastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
        return this;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public ClaretoProvider getClaretoProvider() {
        return claretoProvider;
    }

    public ClaretoOrganization claretoProvider(ClaretoProvider claretoProvider) {
        this.claretoProvider = claretoProvider;
        return this;
    }

    public void setClaretoProvider(ClaretoProvider claretoProvider) {
        this.claretoProvider = claretoProvider;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClaretoOrganization)) {
            return false;
        }
        return id != null && id.equals(((ClaretoOrganization) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClaretoOrganization{" +
            "id=" + getId() +
            ", guid='" + getGuid() + "'" +
            ", ehdOrderGuid='" + getEhdOrderGuid() + "'" +
            ", ehdEmpi='" + getEhdEmpi() + "'" +
            ", claretoSearchGuid='" + getClaretoSearchGuid() + "'" +
            ", claretoPersonGuid='" + getClaretoPersonGuid() + "'" +
            ", claretoProviderGuid='" + getClaretoProviderGuid() + "'" +
            ", status='" + getStatus() + "'" +
            ", claretoProviderId=" + getClaretoProviderId() +
            ", organizationId='" + getOrganizationId() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", specialAuthDocStoreGuid='" + getSpecialAuthDocStoreGuid() + "'" +
            ", retryCount=" + getRetryCount() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", lastModifiedAt='" + getLastModifiedAt() + "'" +
            "}";
    }
}
