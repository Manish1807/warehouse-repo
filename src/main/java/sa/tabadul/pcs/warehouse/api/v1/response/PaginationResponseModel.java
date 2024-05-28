package sa.tabadul.pcs.warehouse.api.v1.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaginationResponseModel {

    private Long crn;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Boolean shipmentType;

    private Integer approxVolTeus;

    private BigDecimal approxVolWeight;

    private Long cargoType;

    private Integer approvalStatusRID;
}