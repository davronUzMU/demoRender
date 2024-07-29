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
@AllArgsConstructor@NoArgsConstructor
public class AddLocationStreetDTO {
    @NotBlank
    @Max(25)
    @Min(2)
    private String street;

    private Integer streetParentId;

    private Set<Integer> locationHouseSet;
}
