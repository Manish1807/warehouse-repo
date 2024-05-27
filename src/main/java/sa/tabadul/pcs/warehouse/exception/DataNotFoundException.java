package sa.tabadul.pcs.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sa.tabadul.pcs.warehouse.domain.enums.ExceptionCodes;

import java.util.List;
import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private long crn;
	private int id;

	public DataNotFoundException(long crn, String message) {
		super(message);
		this.crn = crn;
	}

	public DataNotFoundException(int id, String message) {
		super(message);
		this.id = id;
	}


	public DataNotFoundException(String string, String string2, Map<String, List<Object>> requestBody) {
		// TODO Auto-generated constructor stub
	}

	public DataNotFoundException(ExceptionCodes exceptionCodes) {
	}

	public long getCrn() {
		return crn;
	}

	public int getId() {
		return id;
	}
}
