package uz.com.demorender.model;

import jakarta.persistence.*;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;
import java.util.List;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "parent_id"})
})
public class Category extends AbsIntegerEntity {
    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String url;

    @ManyToOne
    private Category parent;
    @ManyToMany
    private Set<Category> categorySet;
    @ManyToMany
    @JoinTable(
            name = "category_manufacture",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "manufacture_id")}
    )
    private Set<Manufacture> manufactures;
    @OneToMany
    private List<Category> categoryListChildren;

}
