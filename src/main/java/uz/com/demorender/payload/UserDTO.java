package uz.com.demorender.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    @NotBlank(message = "ism kiritilmadi")
    private String firstName;

    @NotBlank(message = "familiya kiritilmadi")
    private String lastName;

    @Column(unique = true, name = "phone_number")
    @Pattern(regexp = "[0-9]{9}")
    private String phoneNumber;

    @Email
    private String email;

    @Pattern(regexp = "[0-9]{5}")
    private String password;
}
