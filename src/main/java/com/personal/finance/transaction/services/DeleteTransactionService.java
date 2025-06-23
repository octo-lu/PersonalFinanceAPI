package com.personal.finance.transaction.services;

import com.personal.finance.Command;
import com.personal.finance.transaction.TransactionRepository;
import com.personal.finance.transaction.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteTransactionService implements Command<Integer, Void> {

    private final TransactionRepository transactionRepository;

    public DeleteTransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if(optionalTransaction.isPresent()){
            transactionRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
