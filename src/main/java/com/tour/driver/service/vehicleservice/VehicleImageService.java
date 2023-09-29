package com.tour.driver.service.vehicleservice;

import com.tour.driver.dto.vehicledto.VehicleImageDTO;
import com.tour.driver.entity.vehicleentity.VehicleImage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleImageService {
    ResponseEntity<VehicleImage> createVehicleImage(VehicleImageDTO vehicleImageDTO);

    ResponseEntity<List<VehicleImage>> getAllVehicleImage();


    ResponseEntity<VehicleImage> getVehicleImageById(long id);

    ResponseEntity<VehicleImage> updateVehicleImage(long id, VehicleImageDTO vehicleImageDTO);

    ResponseEntity<HttpStatus> deleteVehicleImageById(long id);

    ResponseEntity<HttpStatus> deleteAllVehicleImages();
}
