package com.tour.driver.service.vehicleservice;

import com.tour.driver.dto.vehicledto.VehicleInformationDTO;
import com.tour.driver.entity.Driver;
import com.tour.driver.entity.vehicleentity.VehicleInformation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleInformationService {
    ResponseEntity<VehicleInformation> createVehicleInformation(VehicleInformationDTO vehicleInformationDTO);

    ResponseEntity<VehicleInformation> getVehicleById(long id);


    ResponseEntity<VehicleInformation> updateVehicleInformation(long id, VehicleInformationDTO vehicleInformationDTO);

    ResponseEntity<HttpStatus> deleteVehicleInformation(long id);

    ResponseEntity<HttpStatus> deleteAllVehicleInformation();

    ResponseEntity<List<VehicleInformation>> getAllVehicleInformation();

    ResponseEntity<List<VehicleInformation>> getVehicleInformationByModel(String model);
}
