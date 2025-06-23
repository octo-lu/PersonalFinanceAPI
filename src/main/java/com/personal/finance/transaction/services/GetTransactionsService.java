package com.personal.finance.transaction.services;

import com.personal.finance.Query;
import com.personal.finance.transaction.TransactionRepository;
import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionsService implements Query<Void, List<TransactionDTO>> {

    private final TransactionRepository transactionRepository;

    public GetTransactionsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<List<TransactionDTO>> execute(Void input) {
        List<Transaction> transactionList = transactionRepository.findAll();
        List<TransactionDTO> transactionDTOList = transactionList.stream().map(TransactionDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(transactionDTOList);
    }
}
