package sa.tabadul.pcs.warehouse.api.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<?> getSpaceBookingDetails(@RequestParam(name = "crn")Long crn){
        SpaceBookingEntity spaceBookingDetails = spaceBookingService.getSpaceBookingDetails(crn);
        return ResponseEntity.of(Optional.of(spaceBookingDetails));
    }



//
//    @PostMapping("/list")
//    public Map<String, Object> listSpaceBookings(@RequestBody Paginator<SpaceBookingFilter> pageRequest) {
//        return spaceBookingService.listSpaceBookings(pageRequest);
//    }
}

