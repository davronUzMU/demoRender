package uz.com.demorender.payload;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SetPasswordDTO {

    @NotBlank
    @Size(min = 8 ,max = 12)
    @Pattern(regexp = "[A-Z]{2}[0-9]")
    private String  password;

    @NotBlank
    @Size(min = 8 ,max = 12)
    @Pattern(regexp = "[A-Z]{2}[0-9]")
    private String prePassword;
}
