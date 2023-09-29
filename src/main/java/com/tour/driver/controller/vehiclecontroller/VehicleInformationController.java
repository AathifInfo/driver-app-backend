package com.tour.driver.controller.vehiclecontroller;


import com.tour.driver.dto.vehicledto.VehicleInformationDTO;
import com.tour.driver.entity.vehicleentity.VehicleInformation;
import com.tour.driver.service.vehicleservice.VehicleInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class VehicleInformationController {
    @Autowired
    VehicleInformationService vehicleInformationService;

    @PostMapping("/vehicleInformation")
    public ResponseEntity<VehicleInformation> createVehicleInformation(@RequestBody VehicleInformationDTO vehicleInformationDTO){
        return vehicleInformationService.createVehicleInformation(vehicleInformationDTO);
    }

    @GetMapping("/vehicleInformationByMake")
    public ResponseEntity<List<VehicleInformation>> getVehicleInformationByModel(@RequestParam(required = false) String model){
        return vehicleInformationService.getVehicleInformationByModel(model);
    }


    @GetMapping("/vehicleInformation/{id}")
    public ResponseEntity<VehicleInformation> getVehicleById(@PathVariable("id") long id){
        return vehicleInformationService.getVehicleById(id);
    }

    @GetMapping("/vehicleAllInformation")
    public ResponseEntity<List<VehicleInformation>> getAllVehicleInformation(){
        return vehicleInformationService.getAllVehicleInformation();
    }

    @PutMapping("/vehicleInformation/update/{id}")
    public ResponseEntity<VehicleInformation> updateVehicleInformation(@PathVariable("id") long id, @RequestBody VehicleInformationDTO vehicleInformationDTO){
        return vehicleInformationService.updateVehicleInformation(id, vehicleInformationDTO);
    }

    @DeleteMapping("/vehicleInformation/{id}")
    public ResponseEntity<HttpStatus> deleteVehicleInformationById(@PathVariable("id") long id){
        return vehicleInformationService.deleteVehicleInformation(id);
    }

    @DeleteMapping("/vehicleInformation/all")
    public ResponseEntity<HttpStatus> deleteAllVehicleInformation(){
        return vehicleInformationService.deleteAllVehicleInformation();
    }
}
