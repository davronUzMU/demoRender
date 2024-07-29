package uz.com.demorender.payload.category;

import lombok.*;
import uz.com.demorender.payload.manufacture.ManufactureResponseDTO;

import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryResponseDTO {
    private Integer Id;

    private String name;

    private String url;
    private CategoryResponseDTO parent;

    private Set<ManufactureResponseDTO> manufactures;
}
