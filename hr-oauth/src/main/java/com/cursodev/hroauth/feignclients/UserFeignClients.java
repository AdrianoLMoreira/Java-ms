package com.cursodev.hroauth.feignclients;

import com.cursodev.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component //Essa anotação indica que é um componente gerenciado pelo spring e pode ser injetado em outras classes
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClients {

    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam String email);
}
