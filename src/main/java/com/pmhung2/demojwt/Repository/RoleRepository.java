package com.pmhung2.demojwt.Repository;

import com.pmhung2.demojwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String role);
}
