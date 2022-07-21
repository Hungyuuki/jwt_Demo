package com.pmhung2.demojwt.Service.user;

import com.pmhung2.demojwt.Service.IGeneralService;
import com.pmhung2.demojwt.domain.User;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>{
    Optional<User> findByUserName(String name);
    Boolean existByUsername(String username);
    User save (User user);
}
