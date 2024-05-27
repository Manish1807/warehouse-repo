package sa.tabadul.pcs.warehouse.exception;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sa.tabadul.pcs.warehouse.actuate.common.ApiResponse;
import sa.tabadul.pcs.warehouse.domain.enums.CommonCodes;
import sa.tabadul.pcs.warehouse.domain.enums.ExceptionCodes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;


@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandlerConfig extends ResponseEntityExceptionHandler {

	 private static final int RANDOM_LOWER = 1000;
	    private static final int RANDOM_UPPER = 9000;

	    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonCodes.DD_MM_YYYY_HH_MM.getMessage());

	    @ExceptionHandler({ BusinessException.class })
	    public ResponseEntity<?> businessException(BusinessException ex, HttpServletRequest request) {

	    	 generateLogs(request, ex, null);
	    	 return new ResponseEntity<>(
	                 new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage(), ExceptionCodes.DATA_NOT_FOUND.getMessage()),
	                 HttpStatus.NOT_FOUND);
	    }

		@ExceptionHandler({ GeneralException.class })
	    public ResponseEntity<?> generalException(GeneralException ex, HttpServletRequest request) {

	        String errorId = getErrorId();
	        generateLogs(request, ex, errorId);
	        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), errorId), HttpStatus.OK);
	    }

	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ApiResponse<String>> dataException(RuntimeException ex, HttpServletRequest request) {

	        String errorId = getErrorId();
	        generateLogs(request, ex, errorId);
	        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorId),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiResponse<String>> generalException(Exception ex, HttpServletRequest request) {

	        String errorId = getErrorId();
	        generateLogs(request, ex, errorId);
	        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorId),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    public String getErrorId() {

	        return "C&C " + formatter.format(LocalDateTime.now())
	                + (new SecureRandom().nextInt(RANDOM_UPPER) + RANDOM_LOWER);
	    }

	    private String generateLogs(HttpServletRequest request, Exception ex, String errorId) {

	        StringBuilder result = new StringBuilder("ERROR ID IS: " + errorId + " \n");
	        result.append("### URL : (" + request.getMethod() + ") " + request.getRequestURI()
	                + (request.getQueryString() != null ? "?" + request.getQueryString() : "") + "\n");

	        if (StringUtils.equalsAnyIgnoreCase(request.getMethod(), "POST", "PUT")) {
	            try {
	                result.append("### POST Data : "
	                        + request.getReader().lines().collect(Collectors.joining(System.lineSeparator())) + "\n");
	            } catch (IOException e1) {
	            }
	        }

	        log.error(result.toString(), ex);
	        return errorId;
	    }
}
