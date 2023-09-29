package com.tour.driver.controller.vehiclecontroller;


import com.tour.driver.dto.vehicledto.VehicleDocumentDTO;
import com.tour.driver.entity.vehicleentity.VehicleDocument;
import com.tour.driver.service.vehicleservice.VehicleDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VehicleDocumentController {

    @Autowired
    VehicleDocumentService vehicleDocumentService;

    @PostMapping("/vehicleDocument")
    ResponseEntity<VehicleDocument> createVehicleDocument(@RequestBody VehicleDocumentDTO vehicleDocumentDTO){
        return vehicleDocumentService.createVehicleDocument(vehicleDocumentDTO);
    }

    @GetMapping("/vehicleAllDocument")
    ResponseEntity<List<VehicleDocument>> getAllDocuments(){
        return vehicleDocumentService.getAllDocuments();
    }

    @GetMapping("vehicleDocument/{id}")
    ResponseEntity<VehicleDocument> getVehicleDocumentById(@PathVariable("id") long id){
        return vehicleDocumentService.getVehicleDocumentById(id);
    }

    @PutMapping("/vehicleDocument/{id}")
    ResponseEntity<VehicleDocument> updateVehicleDocument(@PathVariable("id") long id, @RequestBody VehicleDocumentDTO vehicleDocumentDTO){
        return vehicleDocumentService.updateVehicleDocument(id, vehicleDocumentDTO);
    }

    @DeleteMapping("/vehicleDocument/{id}")
    ResponseEntity<HttpStatus> deleteVehicleDocumentById(@PathVariable("id") long id){
        return vehicleDocumentService.deleteVehicleDocumentById(id);
    }

    @DeleteMapping("/vehicleDocument")
    ResponseEntity<HttpStatus> deleteAllVehicleDocuments(){
        return vehicleDocumentService.deleteAllVehicleDocuments();
    }

}
