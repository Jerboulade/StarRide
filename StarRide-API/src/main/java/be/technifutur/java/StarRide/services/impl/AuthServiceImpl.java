package be.technifutur.java.StarRide.services.impl;

import be.technifutur.java.StarRide.config.jwt.JWTHolder;
import be.technifutur.java.StarRide.config.jwt.JWTProvider;
import be.technifutur.java.StarRide.models.form.LoginForm;
import be.technifutur.java.StarRide.models.form.RegistrationForm;
import be.technifutur.java.StarRide.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTProvider           jwtProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegistrationForm form) {


    }

    @Override
    public JWTHolder login(LoginForm form) {
        Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        authenticationManager.authenticate(auth);
        JWTHolder holder = new JWTHolder(jwtProvider.createToken(auth), form.getUsername());
        System.out.println(holder.getUsername() +" "+ holder.getToken());
        return holder;
    }
}
