package uz.com.demorender.payload.color;

import lombok.*;

@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class ColorResponseDTO {
    private Integer id;

    private String color;
}
