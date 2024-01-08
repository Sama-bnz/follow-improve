package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Roles;
import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.entities.dto.UserCreateDto;
import com.thomas.followimprove.entities.dto.UserGetDto;
import com.thomas.followimprove.repository.IRolesRepository;
import com.thomas.followimprove.repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    //Je récupere mon singleton
    private UserMapperMapStruct userMapperMapStruct = UserMapperMapStruct.INSTANCE;
    @Autowired
    private PasswordEncoder encoder;
    private IRolesRepository rolesRepository;


    public UserGetDto create (UserCreateDto userCreateDto) {
        //JE CREER UNE INSTANCE DE USER ET J'INITIALISE LES CHAMPS AVEC LA VALEUR DE USERDTO
        User userToCreate = userMapperMapStruct.userDtoToUser(userCreateDto);
        userToCreate.setPassword(encoder.encode(userToCreate.getPassword()));
        Roles roles = rolesRepository.findRolesByLabel("ROLE_USER");
        userToCreate.getRoles().add(roles);
        User userCreated =  userRepository.save(userToCreate);
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
