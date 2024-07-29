package uz.com.demorender.payload.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.com.demorender.model.enams.EnumType;
import uz.com.demorender.model.enams.PermissionEnum;

import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class RoleResponseDTO {

    private Integer id;

    private String name;

    private String description;

    private Set<PermissionEnum> permissions;

    private EnumType roleType;
}
