package com.pmhung2.demojwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private Long id;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 20, message = "Tên User phải từ 5 tới 20 ký tự")
    private String name;
    @NotBlank
    private String userName;
    private String password;

    private Role role;
}
