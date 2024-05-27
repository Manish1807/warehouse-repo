package sa.tabadul.pcs.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sa.tabadul.pcs.warehouse.actuate.common.CommonEntityLocalDateTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARGO_STORAGE_REQUEST", schema = "STORAGE")
public class CargoStorageEntity extends CommonEntityLocalDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CRN")
    private Long crn;

    @Column(name = "shipment_type")
    private String shipmentType;

    @Column(name = "discharge_load_date")
    private LocalDateTime dischargeLoadDate;

    @Column(name = "load_type")
    private int loadType;

    @Column(name = "from_date")
    private LocalDateTime fromDate;

    @Column(name = "to_date")
    private LocalDateTime toDate;

    @Column(name = "cargo_type_RID")
    private Long cargoType;

    @Column(name = "cargo_weight")
    private Double cargoWeight;

    @Column(name = "total_volume")
    private Double totalVolume;

    @Column(name = "approval_status_RID")
    private Long approvalStatus;

    @Column(name = "org_RID")
    private String orgID;

    @Column(name = "branch_RID")
    private String branchID;

    @Column(name = "port_RID")
    private Integer portID;

//    @Column(name = "created_by", nullable = false)
//    private String createdBy;
//
//    @Column(name = "created_date", nullable = false)
//    private LocalDateTime createdDate;
//
//    @Column(name = "updated_by")
//    private String updatedBy;
//
//    @Column(name = "updated_date")
//    private LocalDateTime updatedDate;
//
//    @Column(name = "is_active", nullable = false)
//    private Boolean isActive;
}
