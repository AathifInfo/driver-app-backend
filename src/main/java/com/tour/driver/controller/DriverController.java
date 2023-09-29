package com.tour.driver.controller;


import com.tour.driver.dto.DriverDTO;
import com.tour.driver.entity.Driver;
import com.tour.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping("/driversWithNames")
    public ResponseEntity<List<Driver>> getAllDrivers(@RequestParam(required = false) String name){
        return driverService.getAllDrivers(name);
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getDrivers(){
        return driverService.getDrivers();
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id") long id){
        return driverService.getDriverById(id);
    }

    @PostMapping("/driver")
    public ResponseEntity<Driver> createDriver(@RequestBody DriverDTO driverDTO){
        return driverService.createDriver(driverDTO);
    }

    @PutMapping("/driver/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") long id, @RequestBody DriverDTO driverDTO){
        return driverService.updateDriver(id, driverDTO);
    }

    @DeleteMapping("/drivers")
    public ResponseEntity<HttpStatus> deleteAllDrivers(){
        return driverService.deleteAllDrivers();
    }

    @DeleteMapping("/driver/{id}")
    public ResponseEntity<HttpStatus> deleteDriver(@PathVariable("id") long id){
        return driverService.deleteDriver(id);
    }

}
