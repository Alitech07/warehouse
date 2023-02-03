package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.warehouse.payload.Result;
import spring.warehouse.payload.UserDto;
import spring.warehouse.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Result add(@RequestBody UserDto userDto){
        Result result = userService.addUser(userDto);
        return result;
    }
}
