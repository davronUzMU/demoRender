package uz.com.demorender.payload.locationPaylod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.com.demorender.model.location.LocationStreet;
import java.util.Set;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLocationCityDTO {
    private Integer id;

    private String city;

    private Integer cityParentId;

    private Set<LocationStreet> locationStreetSet;

}
