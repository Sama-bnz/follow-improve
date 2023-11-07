package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

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
    @Column(name ="date_of_birthday")
    private String dateOfBirthday;
    private String login;
    private String password;


}
