package sa.tabadul.pcs.warehouse.domain.enums;

public enum CommonCodes {

    CRN("crn"),
    VCN("vcn"),
    IMO("imo"),
    SEARCH_BOX_VCN("searchVcn"),
    SEARCH_BOX_IMO("searchImo"),
    SEARCH_BOX_VESSEL_NAME("searchVesselName"),
    SEARCH_BOX_ETA("searchEta"),
    SEARCH_BOX_ETD("searchEtd"),
    ETA("eta"),
    ETD("etd"),
    IMO_NO("imoNo"),
    VESSEL_NAME("vesselName"),
    VESSEL_NAME_ENGLISH("vesselNameEnglish"),
    VESSEL_NAME_ARABIC("vesselNameArabic"),
    VESSEL_TYPE_NAME("vesselTypeName"),
    PORT_NAME("portNameEnglish"),
    VOYAGE_ID("voyageID"),
    DOCK_REF_NO("docRefNo"),
    VOYAGE_RID("voyageRid"),
    MANIFEST_TYPE("manifestType"),
    MANIFEST("manifest"),
    AGENT("agent"),
    SHIPPING_AGENT_NAME("shippingAgentName"),
    IMPORT("IMPORT"),
    EXPORT("EXPORT"),
    MESSAGE("message"),
    SUBMITTED("Submitted"),
    DRAFTED("Drafted"),
    DRAFT("Draft"),
    APPROVED("Approved"),
    REJECT("Rejected"),
    CANCELLED("Cancelled"),
    CRN_FORMAT("yyyyMMddHHmmss"),
    INVALID_SORT_DIRECTION("Invalid sort direction: "),
    INVALID_SORT_FIELD("Invalid sort field: "),
    INVALID_FIELD("Invalid Field"),
    INVALID("invalid"),
    INVALID_GATE_IN_OUT("Invalid"),
    INVALID_VCN("Invalid vcn"),
    REQUIRED_FIELD("Required Field"),
    YYYYMMDD("yyyy-MM-dd"),
    DDMMYYYY("dd-MM-yyyy"),
    DD_MM_YYYY_HH_MM("dd-MM-yyyy HH:mm"),
    DD_MM_YYYY_HH_MM_SS("dd-MM-yyyy HH:mm:ss"),
    YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),
    ASC("ASC"),
    DESC("DESC"),
    POST("POST"),
    INDEX("index"),
    CONTENT_TYPE("Content-Type"),
    APPLICATION_JSON("application/json"),
    DATA("data"),
    CHILD_COUNT("childCount"),
    PORTNAME("portName"),
    OPERATION_FAILED(" Insert Operation Failed"),
    ERROR(""),

    RESUBMIT("Resubmit"),
    UNKNOWN("Unknown"),
    PORT_ID("portId"),
    ID("id"),
    PORT_NAME_ENGLISH("codeDescriptionEnglish"),

    CONTAINER("Container"),
    CARGO("Cargo"),
    VESSEL("Vessel"),


    CONTAINER_NO("containerNo"),
    ARRIVAL_DATE_TIME("arrivalDateTime"),

    ENTRY("entry"),
    RETRIVAL("retrival"),

    DAMAGE_INDICATION_YES("yes"),
    DAMAGE_INDICATION_NO("no"),

    NOTIFICATION_TYPE_IN("Gate In"),
    NOTIFICATION_TYPE_OUT("Gate Out"),

    ECL_APPROVED("ECL Approved"),
    ECL_REJECTED("ECL Rejected"),
    ECL_SUBMITTED("ECL Submitted");





    private final String message;

    private CommonCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
