package sa.tabadul.pcs.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.tabadul.pcs.warehouse.domain.CargoStorageEntity;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CargoStorageRepository extends JpaRepository<CargoStorageEntity, Integer> {

    Optional<CargoStorageEntity> findByCrn(Long crn);
}
