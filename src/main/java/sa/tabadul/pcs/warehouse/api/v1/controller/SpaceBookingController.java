package sa.tabadul.pcs.warehouse.api.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.tabadul.pcs.warehouse.actuate.common.ApiResponse;
import sa.tabadul.pcs.warehouse.api.v1.request.AddSpaceBookingRequest;
import sa.tabadul.pcs.warehouse.service.SpaceBookingService;

@RestController
@RequestMapping("/spacebooking")
@Slf4j
public class SpaceBookingController {
    @Autowired
    private SpaceBookingService spaceBookingService;


    @PostMapping("/addupdate")
    public ResponseEntity<?> addUpdateSpaceBook(@RequestBody AddSpaceBookingRequest addSpaceBookingRequest){
        ApiResponse apiResponse = new ApiResponse();
        String data = spaceBookingService.addUpdateSpaceBook(addSpaceBookingRequest);
        apiResponse.setResponseCode(HttpStatus.OK.value());
        String message = "Successfully saved details";
        apiResponse.setResponseMessage(message);
        apiResponse.setData(data);
        return ResponseEntity.ok(apiResponse);
    }
}
