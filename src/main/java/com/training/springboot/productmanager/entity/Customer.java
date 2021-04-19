package com.training.springboot.productmanager.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "ECM_CUSTOMER")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "STORE_ID")
    private String storeId;

    @Column(name = "DOSSIER_ID")
    private String dossierId;

    @Column(name = "CIFNO")
    private String cifNo;

    @Column(name = "CUSTOMERNAME")
    private String customerName;


    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CASEID")
    private String caseId;

    @Column(name = "DATECREATE")
    private Date dateCreate;

    public Integer getId() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getDossierId() {
        return dossierId;
    }

    public void setDossierId(String dossierId) {
        this.dossierId = dossierId;
    }

    public String getCifNo() {
        return cifNo;
    }

    public void setCifNo(String cifNo) {
        this.cifNo = cifNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }


    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
