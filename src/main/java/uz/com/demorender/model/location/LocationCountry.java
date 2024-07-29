package uz.com.demorender.model.location;

import jakarta.persistence.*;
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
@Entity(name = "location-country")
public class LocationCountry extends AbsIntegerEntity {

    @NotBlank()
    @Max(25)
    @Min(2)
    private String country;

    @OneToMany
    @JoinTable(
            name = "country-region",
            joinColumns = {@JoinColumn(name = "country_id")},
            inverseJoinColumns = {@JoinColumn(name = "region_id")}
    )
    private Set<LocationRegion> region;

}
