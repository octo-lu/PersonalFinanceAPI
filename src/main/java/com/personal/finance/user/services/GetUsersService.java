package com.personal.finance.user.services;

import com.personal.finance.Query;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.CustomUser;
import com.personal.finance.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService implements Query<Void, List<UserDTO>> {

    private final UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<List<UserDTO>> execute(Void input) {

        List<CustomUser> customUserList = userRepository.findAll();
        List<UserDTO> userDTOList = customUserList.stream().map(UserDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(userDTOList);
    }
}
