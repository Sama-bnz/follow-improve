package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity(name= "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    @Column(name ="date_of_birthday")
    private String dateOfBirthday;
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Le login doit contenir uniquement des lettres et des chiffres")
    private String login;
    private String password;
}
