package com.pmhung2.demojwt.Service.user;

import com.pmhung2.demojwt.Service.IGeneralService;
import com.pmhung2.demojwt.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>{
    User findByUserName(String username);
}
