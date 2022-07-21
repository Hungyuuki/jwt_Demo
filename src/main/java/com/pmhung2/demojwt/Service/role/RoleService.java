package com.pmhung2.demojwt.Service.role;

import com.pmhung2.demojwt.Repository.IRoleRepository;
import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Iterable<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return iRoleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return iRoleRepository.save(role);
    }

    @Override
    public void removeById(Long id) {
        iRoleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findByName(RoleName name){
        return iRoleRepository.findByName(name);
    }
}
