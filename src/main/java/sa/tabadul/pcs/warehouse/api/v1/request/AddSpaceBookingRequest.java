package sa.tabadul.pcs.warehouse.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddSpaceBookingRequest {

    private Integer portContractorId;
    private String bondedArea;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Boolean shipmentType;
    private Integer approxVolTeus;
    private BigDecimal approxVolWeight;
    private Integer spaceRequiredCbm;
    private Integer spaceType;
    private Integer approvalStatusRID;

}
