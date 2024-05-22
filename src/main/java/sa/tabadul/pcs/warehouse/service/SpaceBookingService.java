package sa.tabadul.pcs.warehouse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sa.tabadul.pcs.warehouse.domain.SpaceBookingEntity;
import sa.tabadul.pcs.warehouse.repository.SpaceBookingRepository;

import javax.persistence.criteria.Predicate;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class SpaceBookingService {

    @Autowired
    private SpaceBookingRepository spaceBookingRepository;

    public SpaceBookingEntity getSpaceBookingDetails(Long crn){
        Optional<SpaceBookingEntity> optionalSpaceBookingEntity = spaceBookingRepository.findByCrn(crn);
        return optionalSpaceBookingEntity.get();
    }


//    public Map<String, Object> listSpaceBookings(Paginator<SpaceBookingFilter> pageRequest) {
//        if (pageRequest == null) {
//            throw new IllegalArgumentException("Paginator object cannot be null");
//        }
//
//        Integer page = pageRequest.getPage();
//        if (page == null) {
//            page = 0; // default page number
//        }
//
//        Integer length = pageRequest.getLength();
//        if (length == null) {
//            length = 10; // default page size
//        }
//
//        String sort = pageRequest.getSort();
//        String sortDir = pageRequest.getSortDir();
//
//        SpaceBookingFilter filter = pageRequest.getFilter();
//        if (filter == null) {
//            filter = new SpaceBookingFilter();
//        }
//
//        Pageable pageable;
//        if (sort != null && sortDir != null) {
//            Sort.Direction direction = Sort.Direction.fromString(sortDir);
//            pageable = PageRequest.of(page, length, Sort.by(direction, sort));
//        } else {
//            pageable = PageRequest.of(page, length);
//        }
//
//        Page<SpaceBookingEntity> spaceBookings = spaceBookingRepository.findAll(getSpaceBookingSpecification(filter), pageable);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("data", spaceBookings.getContent());
//        response.put("currentPage", spaceBookings.getNumber());
//        response.put("totalItems", spaceBookings.getTotalElements());
//        response.put("totalPages", spaceBookings.getTotalPages());
//
//        return response;
//    }
//
//    private Specification<SpaceBookingEntity> getSpaceBookingSpecification(SpaceBookingFilter filter) {
//        return (root, query, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//
//            Long CRN = filter.getCRN();
//            LocalDate fromDate = filter.getFromDate();
//            LocalDate toDate = filter.getToDate();
//
//            if (CRN != null) {
//                predicates.add(criteriaBuilder.equal(root.get("CRN"), CRN));
//            }
//            if (fromDate != null) {
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("fromDate"), fromDate));
//            }
//            if (toDate != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("toDate"), toDate));
//            }
//
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        };
//    }
}

