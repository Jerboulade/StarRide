package be.technifutur.java.StarRide.utils;

import be.technifutur.java.StarRide.models.entity.User;
import be.technifutur.java.StarRide.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements InitializingBean {
    private final UserRepository userRepository;

    public DataInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setUsername("Jerome");
        user.setPassword("pass");
        userRepository.save(user);
    }
}
