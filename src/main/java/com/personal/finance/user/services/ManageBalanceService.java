package com.personal.finance.user.services;

import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.CustomUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ManageBalanceService {

    private final UserRepository userRepository;

    public ManageBalanceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deduceBalance(Integer id, Double amount){
        Optional<CustomUser> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            optionalUser.get().setBalance(optionalUser.get().getBalance() - amount);
        }
    }

    public void addBalance(Integer id, Double amount){
        Optional<CustomUser> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            optionalUser.get().setBalance(optionalUser.get().getBalance() + amount);

        }
    }


}
