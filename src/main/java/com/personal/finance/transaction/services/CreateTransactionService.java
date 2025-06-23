package com.personal.finance.transaction.services;

import com.personal.finance.Command;
import com.personal.finance.transaction.TransactionRepository;
import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CreateTransactionService implements Command<Transaction, TransactionDTO> {

    private final TransactionRepository transactionRepository;

    public CreateTransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<TransactionDTO> execute(Transaction transaction) {

        transaction.setDate(LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TransactionDTO(savedTransaction));
    }

}
