package uz.com.demorender.model.location;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "location-street")
public class LocationStreet extends AbsIntegerEntity {


    @NotBlank
    @Max(25)
    @Min(2)
    private String street;

    private Integer streetParentId;

    @OneToMany
    @JoinTable(
            name = "street-house",
            joinColumns = {@JoinColumn(name = "street_id")},
            inverseJoinColumns = {@JoinColumn(name = "house_id")}
    )
    private Set<LocationHouse> locationHouseSet;
}
