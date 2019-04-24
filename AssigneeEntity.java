package com.wcf.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AssigneeEntity {

    @Id
    @Column(name = "ASSIGNEE_ID", nullable = false, insertable = true, updatable = false, precision = 0)
    @GeneratedValue(generator="AssigneeIdGenerator",strategy = GenerationType.IDENTITY)
    private Long assigneeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    // ....

}
