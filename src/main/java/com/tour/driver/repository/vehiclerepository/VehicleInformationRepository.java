package com.tour.driver.repository.vehiclerepository;



import com.tour.driver.entity.vehicleentity.VehicleInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface VehicleInformationRepository extends JpaRepository<VehicleInformation, Long> {
    List<VehicleInformation> findByModel(String model);

}

