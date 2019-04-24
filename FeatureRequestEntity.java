package com.wcf.model;

import javax.persistence.*;
import java.sql.Date;

import com.wcf.model.AssigneeEntity;
import com.wcf.model.ClientEntity;

@Entity
@Table(schema= "WCF", name= "FEATURE_REQUEST")

public class FeatureRequestEntity {

    @Id
    @Column(name = "FEATURE_REQUEST_ID", nullable = false, insertable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEATURE_REQUEST_SEQ")
    private Integer featureRequestId;

    @Column(name = "Title")
    private String customerId;

    @Column(name = "Description")
    private String description;

    // the client could have more requests ???
    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(name = "Priority",nullable = false, insertable = true)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "Status", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "target_date", nullable = true, insertable = true, updatable = true)
    private Date targetDate;

    @Column(name = "product_area", nullable = false, insertable = true)
    @Enumerated(EnumType.STRING)
    private Area productArea;

    @OneToOne
    @JoinColumn(name = "assignee_id")
    private AssigneeEntity assignee;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Area getProductArea() {
        return productArea;
    }

    public void setProductArea(Area productArea) {
        this.productArea = productArea;
    }

    public AssigneeEntity getAssignee() {
        return assignee;
    }

    public void setAssignee(AssigneeEntity assignee) {
        this.assignee = assignee;
    }

    // enums -> separate classes ...??

    public enum Priority{
        UNDETERMINED,
        CRITICAL,
        MAJOR,
        TRIVIAL
    }

    public enum Status {
        OPEN,
        IN_PROGRESS,
        AWAITING_VERIFICATION,
        CLOSED,
        REJECTED
    }

    public enum Area {
        POLICIES,
        BILLING,
        CLAIMS,
        REPORTS
    }
}
