package uz.com.demorender.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import java.util.Set;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends AbsIntegerEntity {

    private String name;

    @OneToMany
    private Set<ImgUrl> imgUrlSet;

    private Double prise;

    private boolean availability;

    private Integer numberOfProducts;

    private String aboutProduct;

    @ManyToOne
    private Color color;

    @ManyToOne(optional = false)
    private Manufacture manufacture;
}
