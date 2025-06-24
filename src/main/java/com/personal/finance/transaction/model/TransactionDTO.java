package com.personal.finance.transaction.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Integer id;
    private String description;
    private String type;
    private Double amount;
    private Integer instalments;
    private LocalDateTime date;
    private String action;

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.description = transaction.getDescription();
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.instalments = transaction.getInstalments();
        this.date = transaction.getDate();
        this.action = transaction.getAction();
    }
}
