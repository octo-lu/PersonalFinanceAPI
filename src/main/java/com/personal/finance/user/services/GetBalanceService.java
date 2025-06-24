package com.personal.finance.user.services;
import com.personal.finance.Query;
import com.personal.finance.user.UserRepository;
import com.personal.finance.user.model.BalanceDTO;
import com.personal.finance.user.model.CustomUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GetBalanceService implements Query<Integer, BalanceDTO> {

    private final UserRepository userRepository;

    public GetBalanceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<BalanceDTO> execute(Integer userid) {

        Optional<CustomUser> optionalCustomUser = userRepository.findById(userid);
        if(optionalCustomUser.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(new BalanceDTO(
                    optionalCustomUser.get().getName(),
                    optionalCustomUser.get().getBalance()));
        }

       throw new RuntimeException("User not found");
    }
}
