package com.wcf.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ClientEntity {

    @Id
    @Column(name = "CLIENT_ID", nullable = false, insertable = true, updatable = false, precision = 0)
    @GeneratedValue(generator="ClientIdGenerator",strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MAIN_PHONE")
    private String mainPhone;

    //// address, etc
}
