package com.thomas.followimprove.entities.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class UserDto {

    public String firstName;
    public String lastName;
    public String email;
    public String dateOfBirthday;
    public String login;
}
