package com.personal.finance.user.services;

import com.personal.finance.Command;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.CustomUser;
import com.personal.finance.user.model.UpdateUserCommand;
import com.personal.finance.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> {

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand userCommand) {

        Optional<CustomUser> optionalUser = userRepository.findById(userCommand.getId());

        if(optionalUser.isPresent()){
            CustomUser customUser = userCommand.getCustomUser();
            customUser.setId(userCommand.getId());

            userRepository.save(customUser);
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(customUser));

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
