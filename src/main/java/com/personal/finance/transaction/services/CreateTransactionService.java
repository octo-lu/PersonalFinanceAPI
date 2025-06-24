package com.personal.finance.transaction.services;
import com.personal.finance.Command;
import com.personal.finance.transaction.TransactionRepository;
import com.personal.finance.transaction.model.Transaction;
import com.personal.finance.transaction.model.TransactionDTO;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.services.ManageBalanceService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Transactional
public class CreateTransactionService implements Command<Transaction, TransactionDTO> {

    private final TransactionRepository transactionRepository;
    private final ManageBalanceService manageBalanceService;


    public CreateTransactionService(TransactionRepository transactionRepository, UserRepository userRepository, ManageBalanceService manageBalanceService) {
        this.transactionRepository = transactionRepository;

        this.manageBalanceService = manageBalanceService;
    }

    @Override
    public ResponseEntity<TransactionDTO> execute(Transaction transaction) {

        if(Objects.equals(transaction.getAction(), "Deduce")){
            manageBalanceService.deduceBalance(transaction.getUserId(), transaction.getAmount());
        }
        if(Objects.equals(transaction.getAction(), "Add")){
            manageBalanceService.addBalance(transaction.getUserId(), transaction.getAmount());
        }
        transaction.setDate(LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TransactionDTO(savedTransaction));
    }

}
