package com.personal.finance.transaction.services;

import com.personal.finance.Query;
import com.personal.finance.transaction.TransactionRepository;
import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTransactionService implements Query<Integer, TransactionDTO> {

    private final TransactionRepository transactionRepository;

    public GetTransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<TransactionDTO> execute(Integer id) {

        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if(optionalTransaction.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new TransactionDTO(optionalTransaction.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
