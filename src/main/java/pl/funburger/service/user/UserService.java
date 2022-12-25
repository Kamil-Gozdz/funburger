package pl.funburger.service.user;

import pl.funburger.model.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    void deleteUser(UserDto userDto);
}
