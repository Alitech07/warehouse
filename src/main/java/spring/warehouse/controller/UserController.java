package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.entity.User;
import spring.warehouse.payload.Result;
import spring.warehouse.payload.UserDto;
import spring.warehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public Result add(@RequestBody UserDto userDto){
        Result result = userService.addUser(userDto);
        return result;
    }

    @GetMapping
    public List<User> getUser(){
        List<User> users = userService.getUsers();
        return users;
    }

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Integer id){
        Result result = userService.getUser(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editUserById(@RequestBody UserDto userDto,@PathVariable Integer id){
        Result result = userService.editUser(userDto,id);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteUserById(@PathVariable Integer id){
        Result result = userService.deleteUser(id);
        return result;
    }
}
