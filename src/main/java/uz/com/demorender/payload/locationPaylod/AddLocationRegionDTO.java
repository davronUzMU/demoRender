package uz.com.demorender.payload.locationPaylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddLocationRegionDTO {
    @NotBlank()
    @Max(25)
    @Min(2)
    private String region;

    private Integer regionParentId;

    private Set<Integer> locationCitySet;
}
