package com.pmhung2.demojwt.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
    private String name;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private Set<String> roles;
}
