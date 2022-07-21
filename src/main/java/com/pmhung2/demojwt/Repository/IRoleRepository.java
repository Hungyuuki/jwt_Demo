package com.pmhung2.demojwt.Repository;

import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
