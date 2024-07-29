package uz.com.demorender.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.*;
import uz.com.demorender.model.enams.EnumType;
import uz.com.demorender.model.enams.PermissionEnum;
import uz.com.demorender.model.template.AbsIntegerEntity;

import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Role extends AbsIntegerEntity {
    @Column(nullable = false,unique = true)
    private String name;

    @Column(length = 500, nullable = false)
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<PermissionEnum> permissionEnumSet;

    @Column(nullable = false)
    private EnumType roleEnumType;


}
