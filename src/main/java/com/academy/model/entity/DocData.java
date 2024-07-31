package com.academy.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DocData {

    private String docNumber;
    private String docType;
    private String docIssueDate;
}
