package com.tour.driver.serviceimpl.vehicleserviceimpl;


import com.tour.driver.dto.vehicledto.VehicleInformationDTO;
import com.tour.driver.entity.vehicleentity.VehicleInformation;
import com.tour.driver.repository.vehiclerepository.VehicleInformationRepository;
import com.tour.driver.service.vehicleservice.VehicleInformationService;
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
public class VehicleInformationServiceImpl implements VehicleInformationService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleInformationServiceImpl.class);

    @Autowired
    VehicleInformationRepository vehicleInformationRepository;

    @Override
    public ResponseEntity<VehicleInformation> createVehicleInformation(VehicleInformationDTO vehicleInformationDTO) {
        try {
            logger.info("VehicleInformationServiceImpl -> createVehicleInformation() -> started");
            VehicleInformation vehicleInformation = new VehicleInformation(
                    vehicleInformationDTO.getVehicleMake(),
                    vehicleInformationDTO.getVehicleModel(),
                    vehicleInformationDTO.getVehicleYear(),
                    vehicleInformationDTO.getVehicleRegNo(),
                    vehicleInformationDTO.getVehiclePlateNo(),
                    vehicleInformationDTO.getVehicleInsurance()
            );
            vehicleInformationRepository.save(vehicleInformation);

            logger.info("VehicleInformationServiceImpl -> createVehicleInformation() -> ended");
            return new ResponseEntity<>(vehicleInformation, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> createVehicleInformation() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<VehicleInformation> getVehicleById(long id) {
        try {
            Optional<VehicleInformation> vehicleInformationData = vehicleInformationRepository.findById(id);

            if (vehicleInformationData.isPresent()){
                logger.info("VehicleInformationServiceImpl -> getVehicleInformationWithName() -> started");
                return new ResponseEntity<>(vehicleInformationData.get(), HttpStatus.OK);
            }else {
                logger.info("VehicleInformationServiceImpl -> getVehicleInformationWithName() -> ended");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> getVehicleById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<VehicleInformation> updateVehicleInformation(long id, VehicleInformationDTO vehicleInformationDTO) {
        try {
            logger.info("VehicleInformationServiceImpl -> getVehicleInformationWithName() -> started");
            Optional<VehicleInformation> vehicleInformationData = vehicleInformationRepository.findById(id);

            if (vehicleInformationData.isPresent()){
                VehicleInformation vehicleInformationList = getVehicleInformation(vehicleInformationDTO, vehicleInformationData);

                logger.info("VehicleInformationServiceImpl -> getVehicleInformationWithName() -> ended");
                return new ResponseEntity<>(vehicleInformationRepository.save(vehicleInformationList), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> updateVehicleInformation() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static VehicleInformation getVehicleInformation(VehicleInformationDTO vehicleInformationDTO, Optional<VehicleInformation> vehicleInformationData) {
        if (vehicleInformationData.isPresent()){
            logger.info("VehicleInformationServiceImpl -> getVehicleInformation() -> start");
            VehicleInformation vehicleInformation = vehicleInformationData.get();
            vehicleInformation.setVehicleMake(vehicleInformationDTO.getVehicleMake());
            vehicleInformation.setModel(vehicleInformationDTO.getVehicleModel());
            vehicleInformation.setVehicleYear(vehicleInformationDTO.getVehicleYear());
            vehicleInformation.setVehicleRegNo(vehicleInformationDTO.getVehicleRegNo());
            vehicleInformation.setVehiclePlateNo(vehicleInformationDTO.getVehiclePlateNo());
            vehicleInformation.setVehicleInsurance(vehicleInformationDTO.getVehicleInsurance());
            logger.info("VehicleInformationServiceImpl -> getVehicleInformation() -> ended");
            return vehicleInformation;
        }
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteVehicleInformation(long id) {
        try {
            logger.info("VehicleInformationServiceImpl() -> deleteVehicleInformation() -> started");
            vehicleInformationRepository.deleteById(id);

            logger.info("VehicleInformationServiceImpl() -> deleteVehicleInformation() -> ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> deleteVehicleInformation() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllVehicleInformation() {
        try {
            logger.info("VehicleInformationServiceImpl() -> deleteAllVehicleInformation() -> started");
            vehicleInformationRepository.deleteAll();

            logger.info("VehicleInformationServiceImpl() -> deleteAllVehicleInformation() -> ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> deleteAllVehicleInformation() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<VehicleInformation>> getAllVehicleInformation() {
        try {
            logger.info("VehicleInformationServiceImpl() -> getAllVehicleInformation() -> started");
            List<VehicleInformation> vehicleInformation = new ArrayList<>(vehicleInformationRepository.findAll());

            if (vehicleInformation.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("VehicleInformationServiceImpl() -> getAllVehicleInformation() -> ended");
            return new ResponseEntity<>(vehicleInformation, HttpStatus.OK);
        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> deleteAllVehicleInformation() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<VehicleInformation>> getVehicleInformationByModel(String model) {
        try {
            logger.info("VehicleInformationServiceImpl() -> getVehicleInformationByName() -> started");
            List<VehicleInformation> vehicleInformationList = new ArrayList<>();

            if (model == null)
                vehicleInformationList.addAll(vehicleInformationRepository.findAll());
            else
                vehicleInformationList.addAll(vehicleInformationRepository.findByModel(model));
            if (vehicleInformationList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("VehicleInformationServiceImpl() -> getVehicleInformationByName() -> ended");
            return new ResponseEntity<>(vehicleInformationList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("VehicleInformationServiceImpl -> getVehicleInformationByName() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
