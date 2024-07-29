package uz.com.demorender.payload.manufacture;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManufactureResponseDTO {
    private Integer id;
    private String name;

    private String category;
}
