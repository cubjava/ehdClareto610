package com.mm.ehd.clareto.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

import com.mm.ehd.clareto.domain.enumeration.ClaretoStatus;

/**
 * A ClaretoPerson.
 */
@Entity
@Table(name = "clareto_person")
public class ClaretoPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "guid", nullable = false)
    private String guid;

    @NotNull
    @Column(name = "ehd_order_guid", nullable = false)
    private String ehdOrderGuid;

    @Column(name = "ehd_empi")
    private String ehdEmpi;

    @Column(name = "provider_workflow_guid")
    private String providerWorkflowGuid;

    @Column(name = "provider_data")
    private String providerData;

    @Column(name = "clareto_search_guid")
    private String claretoSearchGuid;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClaretoStatus status;

    @Column(name = "hipaa_doc_store_guid")
    private String hipaaDocStoreGuid;

    @Column(name = "payload")
    private String payload;

    @Column(name = "response_code")
    private String responseCode;

    @Column(name = "response_msg")
    private String responseMsg;

    @Column(name = "clareto_status_code")
    private String claretoStatusCode;

    @Column(name = "clareto_status_text")
    private String claretoStatusText;

    @Column(name = "clareto_status_description")
    private String claretoStatusDescription;

    @Column(name = "retry_count")
    private Integer retryCount;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;

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

    public ClaretoPerson guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEhdOrderGuid() {
        return ehdOrderGuid;
    }

    public ClaretoPerson ehdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
        return this;
    }

    public void setEhdOrderGuid(String ehdOrderGuid) {
        this.ehdOrderGuid = ehdOrderGuid;
    }

    public String getEhdEmpi() {
        return ehdEmpi;
    }

    public ClaretoPerson ehdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
        return this;
    }

    public void setEhdEmpi(String ehdEmpi) {
        this.ehdEmpi = ehdEmpi;
    }

    public String getProviderWorkflowGuid() {
        return providerWorkflowGuid;
    }

    public ClaretoPerson providerWorkflowGuid(String providerWorkflowGuid) {
        this.providerWorkflowGuid = providerWorkflowGuid;
        return this;
    }

    public void setProviderWorkflowGuid(String providerWorkflowGuid) {
        this.providerWorkflowGuid = providerWorkflowGuid;
    }

    public String getProviderData() {
        return providerData;
    }

    public ClaretoPerson providerData(String providerData) {
        this.providerData = providerData;
        return this;
    }

    public void setProviderData(String providerData) {
        this.providerData = providerData;
    }

    public String getClaretoSearchGuid() {
        return claretoSearchGuid;
    }

    public ClaretoPerson claretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
        return this;
    }

    public void setClaretoSearchGuid(String claretoSearchGuid) {
        this.claretoSearchGuid = claretoSearchGuid;
    }

    public ClaretoStatus getStatus() {
        return status;
    }

    public ClaretoPerson status(ClaretoStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ClaretoStatus status) {
        this.status = status;
    }

    public String getHipaaDocStoreGuid() {
        return hipaaDocStoreGuid;
    }

    public ClaretoPerson hipaaDocStoreGuid(String hipaaDocStoreGuid) {
        this.hipaaDocStoreGuid = hipaaDocStoreGuid;
        return this;
    }

    public void setHipaaDocStoreGuid(String hipaaDocStoreGuid) {
        this.hipaaDocStoreGuid = hipaaDocStoreGuid;
    }

    public String getPayload() {
        return payload;
    }

    public ClaretoPerson payload(String payload) {
        this.payload = payload;
        return this;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public ClaretoPerson responseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public ClaretoPerson responseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
        return this;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getClaretoStatusCode() {
        return claretoStatusCode;
    }

    public ClaretoPerson claretoStatusCode(String claretoStatusCode) {
        this.claretoStatusCode = claretoStatusCode;
        return this;
    }

    public void setClaretoStatusCode(String claretoStatusCode) {
        this.claretoStatusCode = claretoStatusCode;
    }

    public String getClaretoStatusText() {
        return claretoStatusText;
    }

    public ClaretoPerson claretoStatusText(String claretoStatusText) {
        this.claretoStatusText = claretoStatusText;
        return this;
    }

    public void setClaretoStatusText(String claretoStatusText) {
        this.claretoStatusText = claretoStatusText;
    }

    public String getClaretoStatusDescription() {
        return claretoStatusDescription;
    }

    public ClaretoPerson claretoStatusDescription(String claretoStatusDescription) {
        this.claretoStatusDescription = claretoStatusDescription;
        return this;
    }

    public void setClaretoStatusDescription(String claretoStatusDescription) {
        this.claretoStatusDescription = claretoStatusDescription;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public ClaretoPerson retryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public ClaretoPerson createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public ClaretoPerson lastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
        return this;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClaretoPerson)) {
            return false;
        }
        return id != null && id.equals(((ClaretoPerson) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClaretoPerson{" +
            "id=" + getId() +
            ", guid='" + getGuid() + "'" +
            ", ehdOrderGuid='" + getEhdOrderGuid() + "'" +
            ", ehdEmpi='" + getEhdEmpi() + "'" +
            ", providerWorkflowGuid='" + getProviderWorkflowGuid() + "'" +
            ", providerData='" + getProviderData() + "'" +
            ", claretoSearchGuid='" + getClaretoSearchGuid() + "'" +
            ", status='" + getStatus() + "'" +
            ", hipaaDocStoreGuid='" + getHipaaDocStoreGuid() + "'" +
            ", payload='" + getPayload() + "'" +
            ", responseCode='" + getResponseCode() + "'" +
            ", responseMsg='" + getResponseMsg() + "'" +
            ", claretoStatusCode='" + getClaretoStatusCode() + "'" +
            ", claretoStatusText='" + getClaretoStatusText() + "'" +
            ", claretoStatusDescription='" + getClaretoStatusDescription() + "'" +
            ", retryCount=" + getRetryCount() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", lastModifiedAt='" + getLastModifiedAt() + "'" +
            "}";
    }
}
