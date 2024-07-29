package uz.com.demorender.model;

import lombok.*;
import uz.com.demorender.model.template.AbsUUIDEntity;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket extends AbsUUIDEntity {

    private Set<Category> categorySet;

    private Double total;

}
