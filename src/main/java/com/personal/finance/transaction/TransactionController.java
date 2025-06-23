package com.personal.finance.transaction;

import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import com.personal.finance.transaction.model.UpdateTransactionCommand;
import com.personal.finance.transaction.services.*;
import com.personal.finance.user.model.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final CreateTransactionService createTransactionService;
    private final DeleteTransactionService deleteTransactionService;
    private final GetTransactionsService getTransactionsService;
    private final GetTransactionService getTransactionService;
    private final UpdateTransactionService updateTransactionService;

    public TransactionController(CreateTransactionService createTransactionService, DeleteTransactionService deleteTransactionService, GetTransactionsService getTransactionsService, GetTransactionService getTransactionService, UpdateTransactionService updateTransactionService) {
        this.createTransactionService = createTransactionService;
        this.deleteTransactionService = deleteTransactionService;
        this.getTransactionsService = getTransactionsService;
        this.getTransactionService = getTransactionService;
        this.updateTransactionService = updateTransactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody Transaction transaction){
        return createTransactionService.execute(transaction);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactions(){
        return getTransactionsService.execute(null);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Integer id){
        return getTransactionService.execute(id);
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id){
        return deleteTransactionService.execute(id);
    }

    @PutMapping("/transaction/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction){
        return updateTransactionService.execute(new UpdateTransactionCommand(id, transaction));

    }

}
