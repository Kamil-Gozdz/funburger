package pl.funburger.model.mapper;

import org.springframework.stereotype.Component;
import pl.funburger.model.dto.UserDto;
import pl.funburger.model.entity.User;

@Component
public class UserMapper {

    public UserDto toDto (User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
    public User toNewEntity (UserDto userDto){
        return User.builder()
                .username(userDto.getUsername())
                .build();
    }
}
