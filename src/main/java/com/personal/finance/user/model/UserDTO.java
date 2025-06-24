package com.personal.finance.user.model;

import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private List<TransactionDTO> transactionDTOList;

    public UserDTO(CustomUser customUser) {
        this.id = customUser.getId();
        this.name = customUser.getName();
        this.email = customUser.getEmail();

        if(customUser.getTransactionList() != null){
            this.transactionDTOList = customUser.getTransactionList().stream().map(TransactionDTO::new).toList();
        }

    }



}
