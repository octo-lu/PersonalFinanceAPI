package com.personal.finance.user.services;

import com.personal.finance.Command;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.CustomUser;
import com.personal.finance.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<CustomUser, UserDTO> {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<UserDTO> execute(CustomUser customUser) {
        CustomUser savedCustomUser = userRepository.save(customUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedCustomUser));
    }
}
