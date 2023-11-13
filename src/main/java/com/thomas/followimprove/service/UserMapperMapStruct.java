package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.entities.dto.UserCreateDto;
import com.thomas.followimprove.entities.dto.UserGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperMapStruct {

    //Je créer le singleton
    UserMapperMapStruct INSTANCE = Mappers.getMapper( UserMapperMapStruct.class );
    //J'ignore les champs id et password
    @Mapping(target = "id", ignore = true)
    User userDtoToUser (UserCreateDto userCreateDto);

    UserGetDto userToUserGetDto (User user);

}
