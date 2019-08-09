package com.example.security.config;

import com.example.security.dao.MyUserRepository;
import com.example.security.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 通过用户，查询用户
        MyUser myUser = myUserRepository.findByUsername(username);

        return new User(username, this.passwordEncoder.encode(myUser.getPassword()), myUser.isEnabled(),
                myUser.isAccountNonExpired(), myUser.isCredentialsNonExpired(),
                myUser.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList(myUser.getRole()));
    }
}