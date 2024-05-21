package sa.tabadul.pcs.warehouse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.tabadul.pcs.warehouse.repository.SpaceBookingRepository;

@Service
@Slf4j
public class SpaceBookingService {

    @Autowired
    private SpaceBookingRepository spaceBookingRepository;
}
