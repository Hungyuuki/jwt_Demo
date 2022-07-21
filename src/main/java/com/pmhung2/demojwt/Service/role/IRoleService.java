package com.pmhung2.demojwt.Service.role;

import com.pmhung2.demojwt.Service.IGeneralService;
import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.RoleName;

import java.util.Optional;

public interface IRoleService extends IGeneralService<Role> {
    Optional<Role> findByName(RoleName name);
}
