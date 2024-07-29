package uz.com.demorender.payload.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCardResponse {

    private Integer id;

    private Integer amount;

    private Long serviceId;

    private Long transactionId;

    private String phoneNumber;

    private Integer state;

    private Timestamp createdAt;

    private Integer paymentId;

    private Timestamp transactionTime;
}
