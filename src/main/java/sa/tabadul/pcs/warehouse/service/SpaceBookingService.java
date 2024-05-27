package sa.tabadul.pcs.warehouse.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sa.tabadul.pcs.warehouse.actuate.common.ApiResponse;
import sa.tabadul.pcs.warehouse.domain.SpaceBookingEntity;
import sa.tabadul.pcs.warehouse.domain.enums.ExceptionCodes;
import sa.tabadul.pcs.warehouse.domain.enums.SuccessCodes;
import sa.tabadul.pcs.warehouse.exception.DataNotFoundException;
import sa.tabadul.pcs.warehouse.repository.SpaceBookingRepository;
import sa.tabadul.pcs.warehouse.util.Utils;

import java.util.Optional;

import javax.persistence.criteria.Predicate;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class SpaceBookingService {

    @Autowired
    private SpaceBookingRepository spaceBookingRepository;
    @Autowired
    Utils util;

    public String addUpdateSpaceBook(AddSpaceBookingRequest addSpaceBookingRequest){
        SpaceBookingEntity spaceBookingEntity = new SpaceBookingEntity();
        Optional<SpaceBookingEntity> spaceBookingEntity1 = spaceBookingRepository.findByCRN(addSpaceBookingRequest.getCrn());
        if(spaceBookingEntity1.isEmpty()) {
            Long crn = util.generateCRN();
            spaceBookingEntity.setCRN(crn);
        } else {
            spaceBookingEntity = spaceBookingEntity1.get();
        }
        spaceBookingEntity.setPortContractorId(addSpaceBookingRequest.getPortContractorId());
        spaceBookingEntity.setBondedArea(addSpaceBookingRequest.getBondedArea());
        spaceBookingEntity.setFromDate(addSpaceBookingRequest.getFromDate());
        spaceBookingEntity.setToDate(addSpaceBookingRequest.getToDate());
        spaceBookingEntity.setShipmentType(addSpaceBookingRequest.getShipmentType());
        spaceBookingEntity.setApproxVolTeus(addSpaceBookingRequest.getApproxVolTeus());
        spaceBookingEntity.setApproxVolWeight(addSpaceBookingRequest.getApproxVolWeight());
        spaceBookingEntity.setSpaceRequiredCbm(addSpaceBookingRequest.getSpaceRequiredCbm());
        spaceBookingEntity.setSpaceType(addSpaceBookingRequest.getSpaceType());
        spaceBookingEntity.setApprovalStatusRID(addSpaceBookingRequest.getApprovalStatusRID());
        spaceBookingEntity.setUpdatedBy(addSpaceBookingRequest.getUpdatedBy());
        spaceBookingEntity.setCreatedBy(addSpaceBookingRequest.getCreatedBy());
        spaceBookingRepository.save(spaceBookingEntity);
        return spaceBookingEntity.getCRN().toString();
    }

    public ResponseEntity<ApiResponse<?>> getSpaceBookingDetails(Long crn){
        Optional<SpaceBookingEntity> optionalSpaceBookingEntity = spaceBookingRepository.findByCrn(crn);
        if (optionalSpaceBookingEntity.isEmpty()){
            throw new DataNotFoundException(ExceptionCodes.DATA_NOT_FOUND);
        }
        ApiResponse<SpaceBookingEntity> apiResponse = new ApiResponse<>(HttpStatus.OK.value(),
                SuccessCodes.SUCCESSFULL_SPACE_BOOKING_REQUEST_INSERT.getMessage(), optionalSpaceBookingEntity.get());
        return ResponseEntity.ok(apiResponse);
    }

}

