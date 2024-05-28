package sa.tabadul.pcs.warehouse.api.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import sa.tabadul.pcs.warehouse.actuate.common.ApiResponse;
import sa.tabadul.pcs.warehouse.api.v1.request.PaginationRequestModel;
import sa.tabadul.pcs.warehouse.domain.SpaceBookingEntity;
import sa.tabadul.pcs.warehouse.service.SpaceBookingService;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/spacebooking")
@Slf4j
public class SpaceBookingController {

    @Autowired
    private SpaceBookingService spaceBookingService;

    @GetMapping("/get-space-booking")
    public ResponseEntity<ApiResponse<?>> getSpaceBookingDetails(@RequestParam(name = "crn")Long crn){
        return spaceBookingService.getSpaceBookingDetails(crn);
    }

    @PostMapping("/space-booking-list")
	public ResponseEntity<?> paginationBy(@RequestBody PaginationRequestModel pagination,
			@RequestHeader Map<String, String> headers) throws JsonProcessingException {
                PaginationRequestModel listOfRORO = spaceBookingService.getAllPagination(pagination);
		return ResponseEntity.ok(listOfRORO);
	}
}

