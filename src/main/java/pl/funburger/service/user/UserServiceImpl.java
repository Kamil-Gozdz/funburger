package pl.funburger.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.funburger.model.dto.UserDto;
import pl.funburger.model.mapper.UserMapper;
import pl.funburger.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.toNewEntity(userDto)));
    }

    @Override
    @Transactional
    public void deleteUser(UserDto userDto) {
        userRepository.delete(userMapper.toNewEntity(userDto));
    }
}
