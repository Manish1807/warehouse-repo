package sa.tabadul.pcs.warehouse.api.v1.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.tabadul.pcs.warehouse.actuate.common.ApiResponse;
import sa.tabadul.pcs.warehouse.api.v1.request.CargoStorageRequest;
import sa.tabadul.pcs.warehouse.service.CargoStorageService;

@RestController
@RequestMapping("/cargostorage")
@Slf4j
public class CargoStorageController {

    @Autowired
    private CargoStorageService cargoStorageService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addUpdateCargoStorageRequest(@RequestBody CargoStorageRequest cargoStorageRequest){
        log.info("CargoStorageController - Inside addUpdateCargoStorageRequest method");
        return cargoStorageService.addUpdateCargoStorageRequest(cargoStorageRequest);
    }

}
