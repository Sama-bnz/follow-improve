package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.entities.dto.UserCreateDto;
import com.thomas.followimprove.entities.dto.UserDto;
import com.thomas.followimprove.entities.dto.UserGetDto;
import com.thomas.followimprove.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserMapperService userMapperService;

    //Je récupere mon singleton
    private UserMapperMapStruct userMapperMapStruct = UserMapperMapStruct.INSTANCE;

    public UserGetDto create (UserCreateDto userCreateDto) {
        //JE CREER UNE INSTANCE DE USER ET J'INITIALISE LES CHAMPS AVEC LA VALEUR DE USERDTO
        User userCreated =  userRepository.save(userMapperMapStruct.userDtoToUser(userCreateDto));
        return userMapperMapStruct.userToUserGetDto(userCreated);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }


}
