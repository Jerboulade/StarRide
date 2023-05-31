package be.technifutur.java.StarRide.services;


import be.technifutur.java.StarRide.config.jwt.JWTHolder;
import be.technifutur.java.StarRide.models.form.LoginForm;
import be.technifutur.java.StarRide.models.form.RegistrationForm;

public interface AuthService {

    JWTHolder login(LoginForm form);
    JWTHolder register(RegistrationForm form);
}
