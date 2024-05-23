package sa.tabadul.pcs.warehouse.actuate.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.tabadul.pcs.warehouse.service.ValidationGroup;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class CommonEntity {
    @Column(name = "created_by")
    @Size(max = 36, message = ConstantValues.CREATED_BY, groups = ValidationGroup.class)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_by")
    @Size(max = 36, message = ConstantValues.UPDATED_BY, groups = ValidationGroup.class)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "is_active")
    private boolean isActive;

    @PrePersist
    private void prePersist() {
        createdDate = LocalDate.now();
        isActive=true;
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDate.now();
    }

}
