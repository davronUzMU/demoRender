package uz.com.demorender.model.location;

import jakarta.persistence.Entity;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "location-house")
public class LocationHouse extends AbsIntegerEntity {

    @NotBlank
    @Max(25)
    @Min(5)
    private String houseAddress;

    private Integer parentId;
}
