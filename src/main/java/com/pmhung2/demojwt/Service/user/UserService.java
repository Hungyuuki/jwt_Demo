package com.pmhung2.demojwt.Service.user;


import com.pmhung2.demojwt.Repository.IUserRepository;
import com.pmhung2.demojwt.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUserName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public Boolean existByUsername(String username) {
        return userRepository.existsByUserName(username);
    }
}
