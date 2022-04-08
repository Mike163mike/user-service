package com.mirasoft.mike.userservice.dto.mapper;

import com.mirasoft.mike.userservice.dto.request.UserAuthPostRequestDto;
import com.mirasoft.mike.userservice.dto.request.UserGetRequestDto;
import com.mirasoft.mike.userservice.dto.request.UserLoginRequestDto;
import com.mirasoft.mike.userservice.dto.request.UserSignInPostRequestDto;
import com.mirasoft.mike.userservice.dto.response.UserResponseDto;
import com.mirasoft.mike.userservice.model.User;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto map(User user);

    User map(UserSignInPostRequestDto userPostRequestDto);

    User map(UserAuthPostRequestDto userAuthPostRequestDto);

    User map(UserGetRequestDto userGetRequestDto);

    User map(UserLoginRequestDto userLoginRequestDto);

    default Set<UserResponseDto> toSet(Set<User> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}
