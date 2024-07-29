package uz.com.demorender.payload.category;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRequestDTO {

     private Integer parentId;

     @NotBlank(message = "Name cannot be null")
     private String name;

     @NotBlank(message = "Url cannot be null")
     private String url;

     private Set<Integer> manufactures=new HashSet<>();
}
