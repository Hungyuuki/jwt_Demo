package com.pmhung2.demojwt.Service;

import com.pmhung2.demojwt.Repository.RoleRepository;
import com.pmhung2.demojwt.Repository.UserRepository;
import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null){
            log.error("User not found in DB");
            throw new UsernameNotFoundException("User not found in DB");
        } else
            log.info("User is found in DB: {}", username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
    });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user{} to the DB", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role{} to the DB", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding new role{} to user{}", roleName, username);
        User user = userRepository.findByUserName(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user{}", username);
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all user{}");
        return userRepository.findAll();
    }
}
