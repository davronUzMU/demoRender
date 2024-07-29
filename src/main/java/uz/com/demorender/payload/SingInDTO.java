package uz.com.demorender.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SingInDTO {
    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;
}
