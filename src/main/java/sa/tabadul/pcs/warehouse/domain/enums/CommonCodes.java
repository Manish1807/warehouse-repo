package sa.tabadul.pcs.warehouse.domain.enums;

public enum CommonCodes {
    CRN_FORMAT("yyyyMMddHHmmss");
    private final String message;

    private CommonCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
