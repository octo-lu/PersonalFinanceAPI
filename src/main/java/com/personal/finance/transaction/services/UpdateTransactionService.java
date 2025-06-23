package com.personal.finance.transaction.services;

import com.personal.finance.Command;
import com.personal.finance.transaction.TransactionRepository;
import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import com.personal.finance.transaction.model.UpdateTransactionCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateTransactionService implements Command<UpdateTransactionCommand, TransactionDTO> {

    private final TransactionRepository transactionRepository;

    public UpdateTransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<TransactionDTO> execute(UpdateTransactionCommand transactionCommand){

        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionCommand.getId());
        if(optionalTransaction.isPresent()){
            Transaction transaction = transactionCommand.getTransaction();
            transaction.setId(transactionCommand.getId());

            transactionRepository.save(transaction);
            return ResponseEntity.status(HttpStatus.OK).body(new TransactionDTO(transaction));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
