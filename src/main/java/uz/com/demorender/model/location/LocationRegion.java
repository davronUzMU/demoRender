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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "location-region")
public class LocationRegion extends AbsIntegerEntity {

    @NotBlank()
    @Max(25)
    @Min(2)
    private String region;

    private Integer regionParentId;

    @OneToMany
    @JoinTable(
            name = "region-city",
            joinColumns = {@JoinColumn(name = "region_id")},
            inverseJoinColumns = {@JoinColumn(name = "city_id")}
    )
    private Set<LocationCity> locationCitySet;

}
