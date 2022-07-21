package com.pmhung2.demojwt.Controller;

import com.pmhung2.demojwt.Service.role.RoleService;
import com.pmhung2.demojwt.Service.user.UserService;
import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.RoleName;
import com.pmhung2.demojwt.domain.User;
import com.pmhung2.demojwt.dto.request.SignUpForm;
import com.pmhung2.demojwt.dto.response.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/auth")
@RestController
@NoArgsConstructor
@AllArgsConstructor
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    public ResponseEntity<?>register(@Valid @RequestBody SignUpForm signUpForm){
        if (userService.existByUsername(signUpForm.getUserName())){
            return new ResponseEntity<>(new ResponseMessage("The Username is existed"), HttpStatus.OK);
        }
        User users = new User(signUpForm.getName(), signUpForm.getUserName(), passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRole = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRole.forEach(role ->{
            switch (role){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow( () -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
            }
        });
    }
}
