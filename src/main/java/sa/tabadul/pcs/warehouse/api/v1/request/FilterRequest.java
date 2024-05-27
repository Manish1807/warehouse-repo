package sa.tabadul.pcs.warehouse.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequest {

    private Long crn;
    private String VCN;
    private String activity;
    private String vesselName;
    private String imoNo;
    private String status;
    private String fromDate;
    private String toDate;
    private String resourceRequiredDate;
    private String croNo;
    private String shippingAgentName;
    private String commodityName;
    private Integer portId;
    private String portName;
    private Integer shippingAgentID;
    private Integer longStandingDate;
    private Integer commodityID;
    private String eta;
    private String etd;
    private String serviceName;
    private String permitType;
    private String shippingAgent;
    private String portContractorByOrg;
    private String portContractorByBranch;
    private String portContractor;
    private String shipmentType;
    private String cargoType;
    private String containerStatus;
    private Integer longLastingDays;

    /////////////////////


//    private String containerNumber;
//
//    //
//    //////////////////////////Container GateIn-GateOut////////////////////////////////////////////////
//    private String loadType;
//    private String notificationType;


}
