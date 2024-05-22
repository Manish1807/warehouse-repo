package sa.tabadul.pcs.warehouse.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoStorageRequest {

    private Long crn;

    private String shipmentType;

    private String dischargeLoadDate;

    private int loadType;

    private String fromDate;

    private String toDate;

    private Long cargoType;

    private Double cargoWeight;

    private Double totalVolume;

    private Long approvalStatus;

    private String createdBy;

    private String createdDate;

    private String updatedBy;

    private String updatedDate;

    private Boolean isActive;
}
