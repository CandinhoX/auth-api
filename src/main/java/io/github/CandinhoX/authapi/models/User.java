package io.github.CandinhoX.authapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String login;
    private String password;


}
