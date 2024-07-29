package uz.com.demorender.payload.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCardRequest {

    private Integer amount;

    private String phoneNumber;

    private Integer state;

    private Integer paymentId;

}
