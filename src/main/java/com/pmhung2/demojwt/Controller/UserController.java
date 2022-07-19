package com.pmhung2.demojwt.Controller;

import com.pmhung2.demojwt.Service.role.IRoleService;
import com.pmhung2.demojwt.Service.user.IUserService;
import com.pmhung2.demojwt.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
@Autowired
private IUserService userService;
    @GetMapping
    public ResponseEntity<Iterable<User>> getAll() {
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findIncomeById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveIncome(@RequestBody User income) {
        return new ResponseEntity<>(userService.save(income), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateIncome(@PathVariable Long id, @RequestBody User income) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        income.setId(userOptional.get().getId());
        return new ResponseEntity<>(userService.save(income), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteIncome(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.removeById(id);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
    }
}
