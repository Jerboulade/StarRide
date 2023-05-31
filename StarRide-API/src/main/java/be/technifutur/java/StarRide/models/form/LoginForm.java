package be.technifutur.java.StarRide.models.form;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LoginForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
