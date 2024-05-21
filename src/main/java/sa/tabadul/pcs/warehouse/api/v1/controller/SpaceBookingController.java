package sa.tabadul.pcs.warehouse.api.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.tabadul.pcs.warehouse.service.SpaceBookingService;

@RestController
@RequestMapping("/spacebooking")
@Slf4j
public class SpaceBookingController {
    @Autowired
    private SpaceBookingService spaceBookingService;
    
}
