package com.tour.driver.repository.vehiclerepository;


import com.tour.driver.entity.vehicleentity.VehicleDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface VehicleDocumentRepository extends JpaRepository<VehicleDocument, Long> {
}
