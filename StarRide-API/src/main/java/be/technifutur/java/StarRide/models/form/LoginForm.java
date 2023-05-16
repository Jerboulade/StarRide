package be.technifutur.java.StarRide.models.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
