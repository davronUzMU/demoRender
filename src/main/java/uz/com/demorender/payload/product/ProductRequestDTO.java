package uz.com.demorender.payload.product;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductRequestDTO {

    private Integer id;

    @NotNull
    @Min(2)
    @Max(50)
    private String productName;

    private List<Integer> imgId;

    @NotNull
    private Double prise;

    @NotNull
    private Boolean availability;

    private Integer numberOfProducts;

    private String aboutProduct;

    private Integer color;

    private Integer manufacture;

}
