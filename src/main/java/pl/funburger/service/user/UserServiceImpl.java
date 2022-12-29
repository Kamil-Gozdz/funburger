package pl.funburger.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.funburger.model.dto.UserCreateDto;
import pl.funburger.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.funburger.model.dto.UserDto;
import pl.funburger.model.mapper.UserMapper;
import pl.funburger.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    @Transactional
    public UserDto createUser(UserCreateDto createDto) {
        return userMapper.toDto(userRepository.save(userMapper.toNewEntity(createDto)));
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("No user in database by provided name"));
        return new CustomUserDetails(user);
    }
    @Override
    public UserDto getLoggedInUser() {
        var user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.toDto(user);
    }
}
