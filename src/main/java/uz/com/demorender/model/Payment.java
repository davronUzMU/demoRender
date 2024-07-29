package uz.com.demorender.model;

import jakarta.persistence.*;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment extends AbsIntegerEntity {

    @Column(nullable = false)
    private String nameCard;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double billValue;

    @Column(nullable = false,unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private String cardHolder;

    @Column(nullable = false)
    private String dateValue;

    @OneToMany
    private Set<TransactionCard> transactionCardSet;

}
