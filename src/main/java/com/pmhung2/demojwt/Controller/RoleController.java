package com.pmhung2.demojwt.Controller;


import com.pmhung2.demojwt.Service.role.IRoleService;
import com.pmhung2.demojwt.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<Iterable<Role>> getAllRole() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }
}