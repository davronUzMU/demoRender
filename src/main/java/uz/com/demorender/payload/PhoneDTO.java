package uz.com.demorender.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PhoneDTO {

    @NotBlank(message = "Phone number required")
    private String phoneNumber;
}
