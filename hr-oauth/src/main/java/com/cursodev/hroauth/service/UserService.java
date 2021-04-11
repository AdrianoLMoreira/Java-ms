package com.cursodev.hroauth.service;

import com.cursodev.hroauth.entities.User;
import com.cursodev.hroauth.feignclients.UserFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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
}
