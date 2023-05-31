package be.technifutur.java.StarRide.models.form;

import be.technifutur.java.StarRide.models.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class RegistrationForm {
    @NotNull
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    @NotNull
    @Size(min = 4)
    private String confirmPassword;

    public User toEntity(){
        User user = new User();
        user.setUsername( username );
        user.setPassword( password );
        user.setRoles( Set.of("USER") );
        return user;
    }

}
