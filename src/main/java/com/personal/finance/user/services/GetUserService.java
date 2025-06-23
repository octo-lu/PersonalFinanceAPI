package com.personal.finance.user.services;

import com.personal.finance.Query;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.CustomUser;
import com.personal.finance.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService implements Query<Integer, UserDTO> {

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer id) {

        Optional<CustomUser> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(optionalUser.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
