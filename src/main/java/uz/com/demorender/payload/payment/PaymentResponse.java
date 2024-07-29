package uz.com.demorender.payload.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.com.demorender.model.TransactionCard;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private Integer id;

    private String nameCard;

    private String number;

    private String address;

    private Double billValue;

    private String cardNumber;

    private String cardHolder;

    private String dateValue;

    private Set<TransactionCard> transactionCardSet;
}
