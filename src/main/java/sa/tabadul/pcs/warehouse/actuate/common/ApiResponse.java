package sa.tabadul.pcs.warehouse.actuate.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private int responseCode;
    private String responseMessage;
    private T data;

    public ApiResponse(int responseCode, String responseMessage) {

        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public static <T> ApiResponse<T> createResponseWithData(T data, String message) {

        return new ApiResponse<T>(HttpStatus.OK.value(), message, data);
    }

}
