package pl.funburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.funburger.model.dto.UserCreateDto;
import pl.funburger.model.dto.UserDto;
import pl.funburger.service.user.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public UserDto saveUser(@RequestBody UserCreateDto createDto){
       return userService.createUser(createDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }
    @GetMapping("/all")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }
}
