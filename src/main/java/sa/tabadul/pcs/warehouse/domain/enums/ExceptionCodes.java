package sa.tabadul.pcs.warehouse.domain.enums;
public enum ExceptionCodes {

    ERROR_MESSAGE("something_went_wrong"),
    INVALID_USERTYPE("invalid_user_type"),
    ORGID_REQUIRED("orgid_required"),
    ORGID_BRANCHID_REQUIRED("orgid_and_branchid_required"),
    ID_NOT_FOUND("id_not_found"),
    INVALID_OPERATION("invalid_operation"),
    ENTITY_NOT_FOUND("entity_not_found"),
    UPDATE_FAILED("update_failed"),
    INSERT_FAILED("insert_failed"),
    CRN_NOT_FOUND("crn_not_found"),
    DATA_NOT_FOUND("data_not_found"),
    ERROR("error"),
    INVALID_APPROVAL_STATUS("invalid_approval_status"),
    ERROR_PROCESSING_ADD_UPDATE("add_update_error"),
    EXCEPTION("exception"),
    STACKTRACE("stacktrace"),
    INVALID_KEYS("invalid_keys"),
    INVALID("invalid Operation Type");

    private final String message;

    private ExceptionCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}