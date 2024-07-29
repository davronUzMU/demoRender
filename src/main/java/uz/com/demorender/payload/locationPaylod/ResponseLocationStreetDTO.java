package uz.com.demorender.payload.locationPaylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.com.demorender.model.location.LocationHouse;

import java.util.Set;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLocationStreetDTO {

    private Integer id;

    private String street;

    private Integer streetParentId;

    private Set<LocationHouse> locationHouseSet;
}
