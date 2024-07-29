package uz.com.demorender.model.template;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsEntity implements Serializable {
    @CreatedDate
    @Column()
    private LocalDateTime createDataTime;

    @LastModifiedBy
    @Column(updatable = false)
    private LocalDateTime lastModifiedTime;

    @CreatedBy
    @Column(updatable = false,name = "create_by_id")
    private UUID createById;

    @LastModifiedBy
    @Column(updatable = false,name = "update_by_id")
    private UUID updateById;

}
