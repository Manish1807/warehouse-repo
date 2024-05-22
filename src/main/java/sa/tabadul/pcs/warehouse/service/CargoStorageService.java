package sa.tabadul.pcs.warehouse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sa.tabadul.pcs.warehouse.actuate.common.ApiResponse;
import sa.tabadul.pcs.warehouse.api.v1.request.CargoStorageRequest;
import sa.tabadul.pcs.warehouse.domain.CargoStorageEntity;
import sa.tabadul.pcs.warehouse.domain.enums.SuccessCodes;
import sa.tabadul.pcs.warehouse.repository.CargoStorageRepository;
import sa.tabadul.pcs.warehouse.util.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CargoStorageService {

    @Autowired
    private CargoStorageRepository cargoStorageRepository;

    @Autowired
    private Utils utils;

    public ResponseEntity<ApiResponse<?>> addUpdateCargoStorageRequest(CargoStorageRequest cargoStorageRequest){
        log.info("CargoStorageService - Inside addUpdateCargoStorageRequest method");
        ApiResponse<Map<String, Object>> apiResponse = new ApiResponse<>();
        Optional<CargoStorageEntity> optionalCargoStorageEntity = cargoStorageRepository.findByCrn(cargoStorageRequest.getCrn());
        if (optionalCargoStorageEntity.isEmpty()){
            //add cargo request code:
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            CargoStorageEntity cargoStorageEntity = new CargoStorageEntity();
            cargoStorageEntity.setCrn(utils.generateCRN());
            cargoStorageEntity.setShipmentType(cargoStorageRequest.getShipmentType());
            cargoStorageEntity.setDischargeLoadDate(LocalDateTime.parse(cargoStorageRequest.getDischargeLoadDate(), dateTimeFormatter));
            cargoStorageEntity.setLoadType(cargoStorageRequest.getLoadType());
            cargoStorageEntity.setFromDate(LocalDateTime.parse(cargoStorageRequest.getFromDate(), dateTimeFormatter));
            cargoStorageEntity.setToDate(LocalDateTime.parse(cargoStorageRequest.getToDate(), dateTimeFormatter));
            cargoStorageEntity.setCargoType(cargoStorageRequest.getCargoType());
            cargoStorageEntity.setCargoWeight(cargoStorageRequest.getCargoWeight());
            cargoStorageEntity.setTotalVolume(cargoStorageRequest.getTotalVolume());
            cargoStorageEntity.setApprovalStatus(cargoStorageRequest.getApprovalStatus());
            cargoStorageEntity.setCreatedBy(cargoStorageRequest.getCreatedBy());
            cargoStorageEntity.setUpdatedBy(cargoStorageRequest.getUpdatedBy());
            cargoStorageEntity.setActive(cargoStorageRequest.getIsActive());
            cargoStorageRepository.save(cargoStorageEntity);

            Map<String, Object> result = new HashMap<>();
            result.put("Generated CRN", cargoStorageEntity.getCrn());
            apiResponse.setResponseCode(HttpStatus.OK.value());
            apiResponse.setResponseMessage(SuccessCodes.SUCCESSFULL_CARGO_STORAGE_REQUEST_INSERT.getMessage());
            apiResponse.setData(result);
        }
        else{
            //update cargo request code:
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            CargoStorageEntity cargoStorageEntity = optionalCargoStorageEntity.get();
            cargoStorageEntity.setShipmentType(cargoStorageRequest.getShipmentType());
            cargoStorageEntity.setDischargeLoadDate(LocalDateTime.parse(cargoStorageRequest.getDischargeLoadDate(), dateTimeFormatter));
            cargoStorageEntity.setLoadType(cargoStorageRequest.getLoadType());
            cargoStorageEntity.setFromDate(LocalDateTime.parse(cargoStorageRequest.getFromDate(), dateTimeFormatter));
            cargoStorageEntity.setToDate(LocalDateTime.parse(cargoStorageRequest.getToDate(), dateTimeFormatter));
            cargoStorageEntity.setCargoType(cargoStorageRequest.getCargoType());
            cargoStorageEntity.setCargoWeight(cargoStorageRequest.getCargoWeight());
            cargoStorageEntity.setTotalVolume(cargoStorageRequest.getTotalVolume());
            cargoStorageEntity.setApprovalStatus(cargoStorageRequest.getApprovalStatus());
            cargoStorageEntity.setCreatedBy(cargoStorageRequest.getCreatedBy());
            cargoStorageEntity.setUpdatedBy(cargoStorageRequest.getUpdatedBy());
            cargoStorageEntity.setUpdatedDate(LocalDateTime.now());
            cargoStorageEntity.setActive(cargoStorageRequest.getIsActive());
            cargoStorageRepository.save(cargoStorageEntity);

            Map<String, Object> result = new HashMap<>();
            result.put("Generated CRN", cargoStorageEntity.getCrn());
            apiResponse.setResponseCode(HttpStatus.OK.value());
            apiResponse.setResponseMessage(SuccessCodes.SUCCESSFULL_CARGO_STORAGE_REQUEST_INSERT.getMessage());
            apiResponse.setData(result);
        }
        return ResponseEntity.ok(apiResponse);
    }
}
