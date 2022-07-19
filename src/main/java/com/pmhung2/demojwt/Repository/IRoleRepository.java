package com.pmhung2.demojwt.Repository;

import com.pmhung2.demojwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository <Role, Long> {

}
