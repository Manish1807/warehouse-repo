package sa.tabadul.pcs.warehouse.domain.enums;

public enum SuccessCodes {

    SUCCESSFULL_CARGO_STORAGE_REQUEST_INSERT("Cargo Storage request Submitted Successfully"),
    SUCCESSFULL_SPACE_BOOKING_REQUEST_INSERT("Space Booking request Submitted Successfully");


    private final String message;

    private SuccessCodes(String message) {
        this.message = message;
    }
    //test

    public String getMessage() {
        return message;
    }


}

