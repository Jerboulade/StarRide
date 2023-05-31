package be.technifutur.java.StarRide.services.impl;

import be.technifutur.java.StarRide.config.jwt.JWTHolder;
import be.technifutur.java.StarRide.config.jwt.JWTProvider;
import be.technifutur.java.StarRide.models.entity.User;
import be.technifutur.java.StarRide.models.form.LoginForm;
import be.technifutur.java.StarRide.models.form.RegistrationForm;
import be.technifutur.java.StarRide.repositories.UserRepository;
import be.technifutur.java.StarRide.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTProvider           jwtProvider;
    private final UserRepository        userRepository;
    private final PasswordEncoder       passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTProvider jwtProvider, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JWTHolder register(RegistrationForm form) {
        System.out.println(form);
        if (!form.getPassword().equals(form.getConfirmPassword()))
            throw new RuntimeException("Not same password!"); // TODO  RegisterFormValidationException
        if (userRepository.existsByUsername(form.getUsername()))
            throw new RuntimeException("User already exists!");
        User user = form.toEntity();
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        userRepository.save(user);
        return login(new LoginForm(form.getUsername(), form.getPassword()));
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
