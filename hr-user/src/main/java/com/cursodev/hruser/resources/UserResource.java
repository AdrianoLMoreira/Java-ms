package com.cursodev.hruser.resources;

import com.cursodev.hruser.entities.User;
import com.cursodev.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userRepo.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent())
            return ResponseEntity.ok(user.get());
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        Optional<User> user = Optional.ofNullable(userRepo.findByEmail(email));
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.noContent().build();
    }
}
