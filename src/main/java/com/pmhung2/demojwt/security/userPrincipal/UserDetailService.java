package com.pmhung2.demojwt.security.userPrincipal;

import com.pmhung2.demojwt.Repository.IUserRepository;
import com.pmhung2.demojwt.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found -> username or password"+username));
        return UserPrinciple.build(users);//khi tìm thấy 1 user trên db thì ta sẽ build một user trên hệ thống
    } //kế thừa UserDetailsService của Security, tìm kiếm trên hệ thống xem có user này không
}
