package com.mirasoft.mike.userservice.dto.mapper;

import com.mirasoft.mike.userservice.dto.request.UserAuthPostRequestDto;
import com.mirasoft.mike.userservice.dto.response.UserResponseDto;
import com.mirasoft.mike.userservice.model.User;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto map(User user);

    User map(UserAuthPostRequestDto userAuthPostRequestDto);

    default Set<UserResponseDto> toSet(Set<User> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}
