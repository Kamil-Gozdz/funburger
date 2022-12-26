package pl.funburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.funburger.model.dto.UserDto;
import pl.funburger.service.user.UserService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public UserDto saveUser(UserDto userDto){
       return userService.createUser(userDto);
    }
    @DeleteMapping("/delete")
    public void deleteUser(UserDto userDto){
        userService.deleteUser(userDto);
    }
}
