package com.tour.driver.serviceimpl;

import com.tour.driver.dto.DriverDTO;
import com.tour.driver.entity.Driver;
import com.tour.driver.repository.DriverRepository;
import com.tour.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;
    private static final Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);

    @Override
    public ResponseEntity<List<Driver>> getAllDrivers(String name) {
        try {
            logger.info("DriverServiceImpl -> getAllDrivers() -> started");
            List<Driver> drivers = new ArrayList<>();

            if(name == null)
                drivers.addAll(driverRepository.findAll());
            else
                drivers.addAll(driverRepository.findByNameContaining(name));

            if(drivers.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("DriverServiceImpl -> getAllDrivers() -> ended");
            return new ResponseEntity<>(drivers, HttpStatus.OK);

        } catch (Exception e){
            logger.error("DriverServiceImpl -> getAllDrivers() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Driver>> getDrivers() {
        try {
            logger.info("DriverServiceImpl -> getDrivers() -> started");
            List<Driver> drivers = new ArrayList<>(driverRepository.findAll());

            if(drivers.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("DriverServiceImpl -> getDrivers() -> ended");
            return new ResponseEntity<>(drivers, HttpStatus.OK);

        } catch (Exception e){
            logger.error("DriverServiceImpl -> getAllDrivers() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Driver> getDriverById(long id) {
        logger.info("DriverServiceImpl() -> getDriverById() -> started");
        Optional<Driver> driverData = driverRepository.findById(id);

        logger.info("DriverServiceImpl() -> getDriverById() -> ended");
        return driverData.map(driver -> new ResponseEntity<>(driver, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Driver> createDriver(DriverDTO driverDTO) {
        try {
            logger.info("DriverServiceImpl() -> createDriver() -> started");
            Driver driver = driverRepository
                    .save(new Driver(
                            driverDTO.getName(),
                            driverDTO.getEmail(),
                            driverDTO.getFullName(),
                            driverDTO.getMobileNumber(),
                            driverDTO.getDateOfBirth(),
                            driverDTO.getNicNo(),
                            driverDTO.getAddress(),
                            driverDTO.getEmergencyContact(),
                            driverDTO.getGender()));

            logger.info("DriverServiceImpl() -> createDriver() -> ended");
            return new ResponseEntity<>(driver, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("DriverServiceImpl() -> createDriver() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Driver> updateDriver(long id, DriverDTO driverDTO) {
        try {
            logger.info("DriverServiceImpl() -> updateDriver() -> started");
                Optional<Driver> driverData = driverRepository.findById(id);

            if (driverData.isPresent()){
                Driver driverList = getDriver(driverDTO, driverData);

                logger.info("DriverServiceImpl() -> updateDriver() -> ended");
                return new ResponseEntity<>(driverRepository.save(driverList), HttpStatus.OK);
            }else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e){
            logger.error("DriverServiceImpl() -> updateDriver() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static Driver getDriver(DriverDTO driverDTO, Optional<Driver> driverData) {
        logger.info("DriverServiceImpl() -> getDriver() -> started");
        if (driverData.isPresent()){
            Driver driver = driverData.get();
            driver.setName(driverDTO.getName());
            driver.setEmail(driverDTO.getEmail());
            driver.setFullName(driverDTO.getFullName());
            driver.setMobileNumber(driverDTO.getMobileNumber());
            driver.setDateOfBirth(driverDTO.getDateOfBirth());
            driver.setNicNo(driverDTO.getNicNo());
            driver.setAddress(driverDTO.getAddress());
            driver.setEmergencyContact(driverDTO.getEmergencyContact());
            driver.setGender(driverDTO.getGender());

            logger.info("DriverServiceImpl() -> getDriver() -> ended");
            return driver;
        }
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllDrivers() {
        try {
            logger.info("DriverServiceImpl() -> deleteAllDrivers() -> started");
            driverRepository.deleteAll();

            logger.info("DriverServiceImpl() -> deleteAllDrivers() -> ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("DriverServiceImpl() -> deleteAllDrivers() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteDriver(long id) {
        try {
            logger.info("DriverServiceImpl() -> deleteDriver() -> started");
            driverRepository.deleteById(id);

            logger.info("DriverServiceImpl() -> deleteDriver() -> ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("DriverServiceImpl() -> deleteDriver() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
