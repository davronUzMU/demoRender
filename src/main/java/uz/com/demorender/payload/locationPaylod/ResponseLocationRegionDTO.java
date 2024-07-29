package uz.com.demorender.payload.locationPaylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.com.demorender.model.location.LocationCity;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLocationRegionDTO {

    private Integer id;

    private String region;

    private Integer regionParentId;

    private Set<LocationCity> locationCitySet;
}
