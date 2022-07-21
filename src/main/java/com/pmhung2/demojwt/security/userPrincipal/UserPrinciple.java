package com.pmhung2.demojwt.security.userPrincipal;

import com.pmhung2.demojwt.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class UserPrinciple implements UserDetails {
//class này dùng để tạo form login
    private Long id;
    private String name;
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> roles; //gán role kiểu collection bằng cách kế thừa grantedAuthority
    //để role vào được form login của security

    public static UserPrinciple build(User users) { //hàm này để gán cái User thực tại của mình với một cái security thông qua form login
        List<GrantedAuthority> authorities = users.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        //convert từ một list sang set
        return new UserPrinciple(
                users.getId(),//lấy ra từng trường của user một
                users.getName(),
                users.getUserName(),
                users.getPassword(),
                authorities //giống như là lấy ra role nhưng ta thay role cũ bằng cái authorities(phân quyền) này
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
