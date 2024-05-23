package sa.tabadul.pcs.warehouse.exception;

public class GeneralException extends RuntimeException{
	
	 public GeneralException(String message) {
	        super(message);
	    }

	    public GeneralException(Throwable ex) {
	        super(ex);
	    }
}
