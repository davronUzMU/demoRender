package uz.com.demorender.model;

import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Qualifiers extends AbsIntegerEntity {
    private Set<Category> categorySet;
}
