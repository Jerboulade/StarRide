package be.technifutur.java.StarRide.utils;

import be.technifutur.java.StarRide.models.entity.User;
import be.technifutur.java.StarRide.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements InitializingBean {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public DataInit(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;

        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setEmail("jer@hot.com");
        user.setUsername("Jerome");
        user.setPassword(encoder.encode("pass"));
        userRepository.save(user);
    }
}
