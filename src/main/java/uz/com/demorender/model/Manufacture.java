package uz.com.demorender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Manufacture extends AbsIntegerEntity {

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToMany
    private Set<Category> categorySet;

    public Manufacture(String name) {
        this.name = name;
    }
}
