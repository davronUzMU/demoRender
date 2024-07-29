package uz.com.demorender.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainPathImg extends AbsIntegerEntity {

    @OneToMany
    private Set<ImgUrl> imgUrlSet;

    private boolean mainImg;
}
