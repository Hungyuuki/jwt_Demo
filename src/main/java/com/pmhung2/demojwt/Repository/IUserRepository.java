package com.pmhung2.demojwt.Repository;

import com.pmhung2.demojwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository <User, Long>{
    Optional<User> findByUserName(String name); //Tìm kiếm User có tồn tại trong DB không

    Boolean existsByUserName(String username);
}
