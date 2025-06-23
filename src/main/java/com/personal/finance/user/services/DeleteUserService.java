package com.personal.finance.user.services;

import com.personal.finance.Command;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.CustomUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService implements Command<Integer, Void> {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<CustomUser> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
