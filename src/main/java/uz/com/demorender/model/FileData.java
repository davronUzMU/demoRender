package uz.com.demorender.model;

import jakarta.persistence.Entity;
import lombok.*;
import uz.com.demorender.model.template.AbsIntegerEntity;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData extends AbsIntegerEntity {
   private String name;

   private String type;

   private String filePath;
}
