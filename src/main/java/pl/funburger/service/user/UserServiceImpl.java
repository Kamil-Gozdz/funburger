package pl.funburger.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.funburger.model.dto.UserCreateDto;
import pl.funburger.model.dto.UserDto;
import pl.funburger.model.entity.User;
import pl.funburger.model.mapper.UserMapper;
import pl.funburger.repository.RoleRepository;
import pl.funburger.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDto createUser(UserCreateDto createDto) {
        User user = userMapper.toNewEntity(createDto);
        user.setRoles(List.of(roleRepository.findById(2L).orElseThrow()));

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user in database by provided name"));
        return new CustomUserDetails(user);
    }

    @Override
    public UserDto getLoggedInUser() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return  userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
