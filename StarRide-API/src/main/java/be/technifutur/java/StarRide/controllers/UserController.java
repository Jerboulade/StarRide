package be.technifutur.java.StarRide.controllers;

import be.technifutur.java.StarRide.models.dto.UserDTO;
import be.technifutur.java.StarRide.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{id}")
    public UserDTO getUserProfile(@PathVariable UUID id) {
        return userService.getUserProfileById(id);
    }

}
