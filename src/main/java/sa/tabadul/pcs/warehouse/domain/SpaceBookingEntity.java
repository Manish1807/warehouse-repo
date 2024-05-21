package sa.tabadul.pcs.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKING.SPACE_BOOKING")
public class SpaceBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CRN")
    private Long CRN;

    @Column(name = "port_contractor_id")
    private Integer portContractorId;

    @Column(name = "bonded_area")
    private String bondedArea;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "shipment_type")
    private Boolean shipmentType;

    @Column(name = "approx_vol_teus")
    private Integer approxVolTeus;

    @Column(name = "approx_vol_weight")
    private BigDecimal approxVolWeight;

    @Column(name = "space_required_cbm")
    private Integer spaceRequiredCbm;

    @Column(name = "space_type")
    private Integer spaceType;

    @Column(name = "approval_status_RID")
    private Integer approvalStatusRID;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_active")
    private Boolean isActive;
}
