package be.technifutur.java.StarRide.models.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistrationForm {
    @NotNull
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;

}
