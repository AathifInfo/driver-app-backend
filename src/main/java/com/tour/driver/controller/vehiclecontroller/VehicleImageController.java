package com.tour.driver.controller.vehiclecontroller;


import com.tour.driver.dto.vehicledto.VehicleImageDTO;
import com.tour.driver.entity.vehicleentity.VehicleImage;
import com.tour.driver.service.vehicleservice.VehicleImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VehicleImageController {

    @Autowired
    VehicleImageService vehicleImageService;


    @PostMapping("/vehicleImage")
    public ResponseEntity<VehicleImage> createVehicleImage(@RequestBody VehicleImageDTO vehicleImageDTO){
        return vehicleImageService.createVehicleImage(vehicleImageDTO);
    }

    @GetMapping("/vehicleAllImage")
    public ResponseEntity<List<VehicleImage>> getAllVehicleImage(){
        return vehicleImageService.getAllVehicleImage();
    }

    @GetMapping("/vehicleImage/{id}")
    public ResponseEntity<VehicleImage> getVehicleImageById(@PathVariable("id") long id){
        return vehicleImageService.getVehicleImageById(id);
    }

    @PutMapping("vehicleImage/{id}")
    public ResponseEntity<VehicleImage> updateVehicleImage(@PathVariable("id") long id, @RequestBody VehicleImageDTO vehicleImageDTO){
        return vehicleImageService.updateVehicleImage(id, vehicleImageDTO);
    }

    @DeleteMapping("vehicleImage/{id}")
    public ResponseEntity<HttpStatus> deleteVehicleImageById(@PathVariable("id") long id){
        return vehicleImageService.deleteVehicleImageById(id);
    }

    @DeleteMapping("vehicleAllImage")
    public ResponseEntity<HttpStatus> deleteAllVehicleImages(){
        return vehicleImageService.deleteAllVehicleImages();
    }




}
