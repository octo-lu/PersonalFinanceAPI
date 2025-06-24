package com.personal.finance.transaction.model;

import com.personal.finance.user.model.CustomUser;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;

    //Turn this into an enum later
    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "instalments")
    private Integer instalments;

    //Turn this into an enum later
    @Column(name = "action")
    private String action;

    @Column(name = "user_id")
    private Integer userId;
}
