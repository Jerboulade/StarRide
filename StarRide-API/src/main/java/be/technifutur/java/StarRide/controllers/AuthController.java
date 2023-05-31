package be.technifutur.java.StarRide.controllers;

import be.technifutur.java.StarRide.config.jwt.JWTHolder;
import be.technifutur.java.StarRide.models.form.LoginForm;
import be.technifutur.java.StarRide.models.form.RegistrationForm;
import be.technifutur.java.StarRide.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public JWTHolder login(@RequestBody @Valid LoginForm form) {
        //System.out.println("coucou");
        return authService.login(form);
    }

    @PostMapping("/register")
    public JWTHolder register(@RequestBody @Valid RegistrationForm form) {
        return authService.register(form);
    }
}
