package sa.tabadul.pcs.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.tabadul.pcs.warehouse.domain.SpaceBookingEntity;

@Repository
public interface SpaceBookingRepository extends JpaRepository<SpaceBookingEntity, Integer> {
}
