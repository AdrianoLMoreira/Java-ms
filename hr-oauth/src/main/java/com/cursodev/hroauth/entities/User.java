package com.cursodev.hroauth.entities;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String password;

    private Set<Role> roles = new HashSet<>();

}
