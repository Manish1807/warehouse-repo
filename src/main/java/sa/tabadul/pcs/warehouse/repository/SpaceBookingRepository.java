package sa.tabadul.pcs.warehouse.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sa.tabadul.pcs.warehouse.domain.SpaceBookingEntity;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface SpaceBookingRepository extends JpaRepository<SpaceBookingEntity, Integer>, JpaSpecificationExecutor<SpaceBookingEntity> {
    Optional<SpaceBookingEntity> findByCrn(Long crn);


    Page<SpaceBookingEntity> findAll(Specification<SpaceBookingEntity> spaceBookingSpecification, Pageable pageable);
}
