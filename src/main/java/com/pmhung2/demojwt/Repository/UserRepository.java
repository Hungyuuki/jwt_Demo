package com.pmhung2.demojwt.Repository;

import com.pmhung2.demojwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByUserName(String username);
}
