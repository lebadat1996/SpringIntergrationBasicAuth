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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CASEID")
    private String caseId;

    @Column(name = "DATECREATE")
    private Date dateCreate;





}
