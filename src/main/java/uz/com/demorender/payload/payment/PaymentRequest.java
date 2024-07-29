package uz.com.demorender.payload.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @NotBlank(message = "null bo'lishi mumkin emas")
    @Min(2)
    @Max(25)
    private String nameCard;

    @NotBlank(message = "null bo'lishi mumkin emas")
    @Pattern(regexp = "[0-9]{9}")
    private String number;

    @NotBlank(message = "null bo'lishi mumkin emas")
    @Min(2)
    @Max(50)
    private String address;

    @NotBlank(message = "null bo'lishi mumkin emas")
    private Double billValue;

    @NotBlank(message = "null bo'lishi mumkin emas")
    @Pattern(regexp = "[0-9]{16}",message = "xato qiymat")
    private String cardNumber;

    @NotBlank(message = "null bo'lishi mumkin emas")
    private String cardHolder;

    @NotBlank(message = "null bo'lishi mumkin emas")
    private String dateValue;

    private Set<Integer> transactionCardSet;
}
