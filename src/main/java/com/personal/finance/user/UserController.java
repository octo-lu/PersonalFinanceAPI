package com.personal.finance.user;

import com.personal.finance.user.model.BalanceDTO;
import com.personal.finance.user.model.CustomUser;
import com.personal.finance.user.model.UpdateUserCommand;
import com.personal.finance.user.model.UserDTO;
import com.personal.finance.user.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final CreateUserService createUserService;
    private final DeleteUserService deleteUserService;
    private final GetUsersService getUsersService;
    private final GetUserService getUserService;
    private final UpdateUserService updateUserService;
    private final GetBalanceService getBalanceService;

    public UserController(CreateUserService createUserService,
                          DeleteUserService deleteUserService,
                          GetUsersService getUsersService,
                          GetUserService getUserService,
                          UpdateUserService updateUserService,
                          GetBalanceService getBalanceService) {

        this.createUserService = createUserService;
        this.deleteUserService = deleteUserService;
        this.getUsersService = getUsersService;
        this.getUserService = getUserService;
        this.updateUserService = updateUserService;
        this.getBalanceService = getBalanceService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody CustomUser customUser){
        return createUserService.execute(customUser);
    }

    @PostMapping("/user/balance/{id}")
    public ResponseEntity<BalanceDTO> getBalance(@PathVariable Integer id){
        return getBalanceService.execute(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
        return getUserService.execute(id);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return getUsersService.execute(null);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){

        return deleteUserService.execute(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody CustomUser customUser){
        return updateUserService.execute(new UpdateUserCommand(id, customUser));
    }
}

