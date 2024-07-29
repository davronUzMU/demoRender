package uz.com.demorender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import uz.com.demorender.model.template.AbsUUIDEntity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsCode extends AbsUUIDEntity {

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String code;

    private boolean used;

    private boolean usedResetPassword;

}
