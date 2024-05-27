package sa.tabadul.pcs.warehouse.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer code = HttpStatus.BAD_REQUEST.value();

	public BusinessException(Integer code, String message) {

		super(message);
		this.code = code;
	}

	public BusinessException(String message) {

		super(message);

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
