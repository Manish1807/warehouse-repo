package sa.tabadul.pcs.warehouse.actuate.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.tabadul.pcs.warehouse.service.ValidationGroup;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonEntityLocalDateTime {

    @Column(name = "created_by")
    @Size(max = 72, message = ConstantValues.CREATED_BY, groups = ValidationGroup.class)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    @Size(max = 72, message = ConstantValues.UPDATED_BY, groups = ValidationGroup.class)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_active")
    private boolean isActive;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

}
