package uz.com.demorender.payload.locationPaylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.demorender.model.location.LocationRegion;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLocationCountryDTO {

    private Integer id;

    private String country;

    private Set<LocationRegion> regions;
}
