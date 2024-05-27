package sa.tabadul.pcs.warehouse.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Key {

    private int portID;
    private Integer portContractor;
    private String orgID;
    private String vcn;
    private String branchID;
    private String shippingAgent;
    private List<Integer> status;
    private String shippingAgentBranchId;

    private String containerNumber;
    private String transporterName;


    private String shipmentType;
    private String containerSize;
    private String containerStatus;
    private String cargoType;

    private String containerAgentCode;
}
