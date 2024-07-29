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
@Entity(name = "location-city")
public class LocationCity extends AbsIntegerEntity {


    @NotBlank
    @Max(25)
    @Min(2)
    private String city;

    private Integer cityParentId;

    @OneToMany
    @JoinTable(
            name = "city-street",
            joinColumns = {@JoinColumn(name = "city_id")},
            inverseJoinColumns = {@JoinColumn(name = "street_id")}
    )
    private Set<LocationStreet> locationStreetSet;

    public LocationCity(String city, Integer cityParentId) {
        this.city = city;
        this.cityParentId = cityParentId;
    }
}
