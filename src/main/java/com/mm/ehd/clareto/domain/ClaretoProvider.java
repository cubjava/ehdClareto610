package com.mm.ehd.clareto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

import com.mm.ehd.clareto.domain.enumeration.ClaretoStatus;

/**
 * A ClaretoProvider.
 */
@Entity
@Table(name = "clareto_provider")
public class ClaretoProvider implements Serializable {

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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClaretoStatus status;

    @Column(name = "clareto_person_id")
    private Integer claretoPersonId;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "provider_status_code")
    private String providerStatusCode;

    @Column(name = "provider_status_text")
    private String providerStatusText;

    @Column(name = "provider_status_description")
    private String providerStatusDescription;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "claretoProviders", allowSetters = true)
    private ClaretoPerson claretoPerson;

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

    public ClaretoProvider guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEhdOrderGuid() {
        return ehdOrderGuid;
    }

    public ClaretoProvider ehdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
        return this;
    }

    public void setEhdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
    }

    public String getEhdEmpi() {
        return ehdEmpi;
    }

    public ClaretoProvider ehdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
        return this;
    }

    public void setEhdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
    }

    public String getClaretoSearchGuid() {
        return claretoSearchGuid;
    }

    public ClaretoProvider claretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
        return this;
    }

    public void setClaretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
    }

    public String getClaretoPersonGuid() {
        return claretoPersonGuid;
    }

    public ClaretoProvider claretoPersonGuid(String claretoPersonGuid) {
        this.claretoPersonGuid = claretoPersonGuid;
        return this;
    }

    public void setClaretoPersonGuid(String claretoPersonGuid) {
        this.claretoPersonGuid = claretoPersonGuid;
    }

    public ClaretoStatus getStatus() {
        return status;
    }

    public ClaretoProvider status(ClaretoStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ClaretoStatus status) {
        this.status = status;
    }

    public Integer getClaretoPersonId() {
        return claretoPersonId;
    }

    public ClaretoProvider claretoPersonId(Integer claretoPersonId) {
        this.claretoPersonId = claretoPersonId;
        return this;
    }

    public void setClaretoPersonId(Integer claretoPersonId) {
        this.claretoPersonId = claretoPersonId;
    }

    public String getProviderId() {
        return providerId;
    }

    public ClaretoProvider providerId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public ClaretoProvider providerName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderStatusCode() {
        return providerStatusCode;
    }

    public ClaretoProvider providerStatusCode(String providerStatusCode) {
        this.providerStatusCode = providerStatusCode;
        return this;
    }

    public void setProviderStatusCode(String providerStatusCode) {
        this.providerStatusCode = providerStatusCode;
    }

    public String getProviderStatusText() {
        return providerStatusText;
    }

    public ClaretoProvider providerStatusText(String providerStatusText) {
        this.providerStatusText = providerStatusText;
        return this;
    }

    public void setProviderStatusText(String providerStatusText) {
        this.providerStatusText = providerStatusText;
    }

    public String getProviderStatusDescription() {
        return providerStatusDescription;
    }

    public ClaretoProvider providerStatusDescription(String providerStatusDescription) {
        this.providerStatusDescription = providerStatusDescription;
        return this;
    }

    public void setProviderStatusDescription(String providerStatusDescription) {
        this.providerStatusDescription = providerStatusDescription;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public ClaretoProvider createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public ClaretoProvider lastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
        return this;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public ClaretoPerson getClaretoPerson() {
        return claretoPerson;
    }

    public ClaretoProvider claretoPerson(ClaretoPerson claretoPerson) {
        this.claretoPerson = claretoPerson;
        return this;
    }

    public void setClaretoPerson(ClaretoPerson claretoPerson) {
        this.claretoPerson = claretoPerson;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClaretoProvider)) {
            return false;
        }
        return id != null && id.equals(((ClaretoProvider) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClaretoProvider{" +
            "id=" + getId() +
            ", guid='" + getGuid() + "'" +
            ", ehdOrderGuid='" + getEhdOrderGuid() + "'" +
            ", ehdEmpi='" + getEhdEmpi() + "'" +
            ", claretoSearchGuid='" + getClaretoSearchGuid() + "'" +
            ", claretoPersonGuid='" + getClaretoPersonGuid() + "'" +
            ", status='" + getStatus() + "'" +
            ", claretoPersonId=" + getClaretoPersonId() +
            ", providerId='" + getProviderId() + "'" +
            ", providerName='" + getProviderName() + "'" +
            ", providerStatusCode='" + getProviderStatusCode() + "'" +
            ", providerStatusText='" + getProviderStatusText() + "'" +
            ", providerStatusDescription='" + getProviderStatusDescription() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", lastModifiedAt='" + getLastModifiedAt() + "'" +
            "}";
    }
}
