package com.personal.finance.user.model;

import lombok.Data;

@Data
public class BalanceDTO {

    private String username;
    private Double balance;

    public BalanceDTO(String username, Double balance) {
        this.username = username;
        this.balance = balance;
    }

}
