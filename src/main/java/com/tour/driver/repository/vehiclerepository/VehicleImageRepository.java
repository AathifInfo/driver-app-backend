package com.tour.driver.repository.vehiclerepository;


import com.tour.driver.entity.vehicleentity.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface VehicleImageRepository extends JpaRepository<VehicleImage, Long> {
}
