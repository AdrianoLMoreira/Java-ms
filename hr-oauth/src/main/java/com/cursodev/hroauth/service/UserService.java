package com.cursodev.hroauth.service;

import com.cursodev.hroauth.entities.User;
import com.cursodev.hroauth.feignclients.UserFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserFeignClients userFeignClients;

    public User finByEmail(String email){
        User user =userFeignClients.findByEmail(email).getBody();
        if(user == null){
            throw new IllegalArgumentException("email not found");
        }else {
            return userFeignClients.findByEmail(email).getBody();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userFeignClients.findByEmail(username).getBody();
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }else {
            return userFeignClients.findByEmail(username).getBody();
        }
    }
}
