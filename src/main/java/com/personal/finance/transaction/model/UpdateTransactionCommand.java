package com.personal.finance.transaction.model;

import com.personal.finance.user.model.CustomUser;
import lombok.Data;

@Data
public class UpdateTransactionCommand {

    private Integer id;
    private Transaction transaction;

    public UpdateTransactionCommand(Integer id, Transaction transaction) {
        this.id = id;
        this.transaction = transaction;
    }
}