package uz.com.demorender.payload.locationPaylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddLocationCityDTO {

    private String city;

    private Integer cityParentId;

    private Set<Integer> locationStreetSet;
}
