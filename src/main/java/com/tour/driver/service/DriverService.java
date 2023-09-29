package com.tour.driver.service;


import com.tour.driver.dto.DriverDTO;
import com.tour.driver.entity.Driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DriverService {
    ResponseEntity<List<Driver>> getAllDrivers(String name);

    ResponseEntity<List<Driver>> getDrivers();

    ResponseEntity<Driver> createDriver(DriverDTO driverDTO);

    ResponseEntity<Driver> getDriverById(long id);

    ResponseEntity<Driver> updateDriver(long id, DriverDTO driverDTO);

    ResponseEntity<HttpStatus> deleteAllDrivers();

    ResponseEntity<HttpStatus> deleteDriver(long id);
}
