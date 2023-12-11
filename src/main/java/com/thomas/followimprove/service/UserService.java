package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.entities.dto.UserCreateDto;
import com.thomas.followimprove.entities.dto.UserGetDto;
import com.thomas.followimprove.repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

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

    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public User findByLogin(String login) {

        return  userRepository.findByLogin(login);
    }

}
