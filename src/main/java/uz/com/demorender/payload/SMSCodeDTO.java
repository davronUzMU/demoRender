package uz.com.demorender.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SMSCodeDTO {

    @NotBlank(message = "Phone number required")
    private String phoneNumber;

    @NotBlank(message = "SMS code required")
    private String code;
}
