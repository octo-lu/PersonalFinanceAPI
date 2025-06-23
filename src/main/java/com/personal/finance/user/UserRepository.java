package com.personal.finance.user;


import com.personal.finance.user.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {

    List<CustomUser> findByEmail(String email);

}
