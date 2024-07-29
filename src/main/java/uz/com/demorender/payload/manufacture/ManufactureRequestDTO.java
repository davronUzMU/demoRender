package uz.com.demorender.payload.manufacture;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManufactureRequestDTO {
   private Integer id;

   @NotBlank
   private String name;

   private String categories;

   public ManufactureRequestDTO(String name) {
      this.name = name;
   }


}
