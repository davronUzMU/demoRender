package uz.com.demorender.model;


import jakarta.persistence.Entity;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ImgUrl extends AbsIntegerEntity {

    private String name;

    private long size;

    private String type;

    private String fileOriginalName;
}
