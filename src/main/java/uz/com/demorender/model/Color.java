package uz.com.demorender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Color extends AbsIntegerEntity {
    @Column(unique = true,nullable = false)
    private String color;

}
