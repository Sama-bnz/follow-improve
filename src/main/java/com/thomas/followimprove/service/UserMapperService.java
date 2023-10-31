package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.entities.dto.UserCreateDto;
import com.thomas.followimprove.entities.dto.UserGetDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapperService {

    public User mapFromUserCreateDto(UserCreateDto userCreateDto) {

        User user = new User();
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setDateOfBirthday(userCreateDto.getDateOfBirthday());
        user.setLogin(userCreateDto.getLogin());
        user.setPassword(userCreateDto.getPassword());

        return user;
    }

    public UserGetDto mapFromUser(User userCreated) {

        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setId(userCreated.getId());
        userGetDto.setFirstName(userCreated.getFirstName());
        userGetDto.setLastName(userCreated.getLastName());
        userGetDto.setLogin(userCreated.getLogin());

        return userGetDto;
    }
}
