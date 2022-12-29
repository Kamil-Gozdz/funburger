package pl.funburger.service.user;

import pl.funburger.model.dto.UserCreateDto;
import pl.funburger.model.dto.UserDto;

public interface UserService {

    UserDto createUser(UserCreateDto createDto);

    void deleteUserById(Long id);

    UserDto getLoggedInUser();
}
