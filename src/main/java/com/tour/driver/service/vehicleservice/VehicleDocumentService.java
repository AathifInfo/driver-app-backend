package com.tour.driver.service.vehicleservice;

import com.tour.driver.dto.vehicledto.VehicleDocumentDTO;
import com.tour.driver.entity.vehicleentity.VehicleDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleDocumentService {
    ResponseEntity<VehicleDocument> createVehicleDocument(VehicleDocumentDTO vehicleDocumentDTO);

    ResponseEntity<List<VehicleDocument>> getAllDocuments();

    ResponseEntity<VehicleDocument> getVehicleDocumentById(long id);

    ResponseEntity<VehicleDocument> updateVehicleDocument(long id, VehicleDocumentDTO vehicleDocumentDTO);

    ResponseEntity<HttpStatus> deleteVehicleDocumentById(long id);

    ResponseEntity<HttpStatus> deleteAllVehicleDocuments();
}
