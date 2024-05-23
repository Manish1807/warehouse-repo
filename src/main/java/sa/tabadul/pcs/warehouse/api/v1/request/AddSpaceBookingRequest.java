package sa.tabadul.pcs.warehouse.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.tabadul.pcs.warehouse.actuate.common.CommonEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddSpaceBookingRequest extends CommonEntity {
    private Long crn;
    private Integer portContractorId;
    private String bondedArea;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Boolean shipmentType;
    private Integer approxVolTeus;
    private BigDecimal approxVolWeight;
    private Integer spaceRequiredCbm;
    private Integer spaceType;
    private Integer approvalStatusRID;


}
