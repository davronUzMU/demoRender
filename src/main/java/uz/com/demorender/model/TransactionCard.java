package uz.com.demorender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TransactionCard extends AbsIntegerEntity {

    private Integer amount;

    private Long serviceId;

    @Column(unique = true)
    private Long transactionId;


    private String phoneNumber;

    private Integer state;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    private Payment payment;

    private Timestamp transactionTime;

}
