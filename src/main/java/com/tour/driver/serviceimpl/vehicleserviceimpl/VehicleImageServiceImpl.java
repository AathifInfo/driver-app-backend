package com.tour.driver.serviceimpl.vehicleserviceimpl;


import com.tour.driver.dto.vehicledto.VehicleImageDTO;
import com.tour.driver.entity.vehicleentity.VehicleImage;
import com.tour.driver.repository.vehiclerepository.VehicleImageRepository;
import com.tour.driver.service.vehicleservice.VehicleImageService;
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
public class VehicleImageServiceImpl implements VehicleImageService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleImageServiceImpl.class);

    @Autowired
    VehicleImageRepository vehicleImageRepository;

    @Override
    public ResponseEntity<VehicleImage> createVehicleImage(VehicleImageDTO vehicleImageDTO) {
        try {
            logger.info("VehicleImageServiceImpl() ->  createVehicleImage() -> started");
            VehicleImage vehicleImage = new VehicleImage(
              vehicleImageDTO.getFrontImage(),
              vehicleImageDTO.getRearImage(),
              vehicleImageDTO.getSideImage(),
              vehicleImageDTO.getTopImage()
            );
            vehicleImageRepository.save(vehicleImage);

            logger.info("VehicleImageServiceImpl() ->  createVehicleImage() -> ended");
            return new ResponseEntity<>(vehicleImage, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("VehicleImageServiceImpl() ->  createVehicleImage() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<VehicleImage>> getAllVehicleImage() {
        try {
            logger.info("VehicleImageServiceImpl() ->  getAllVehicleImage() -> started");
            List<VehicleImage> vehicleImageList = new ArrayList<>(vehicleImageRepository.findAll());

            if (vehicleImageList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("VehicleImageServiceImpl() ->  getAllVehicleImage() -> ended");
            return new ResponseEntity<>(vehicleImageList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("VehicleImageServiceImpl() ->  getAllVehicleImage() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<VehicleImage> getVehicleImageById(long id) {
        try {
            logger.info("VehicleImageServiceImpl() ->  getVehicleImageById() -> started");
            Optional<VehicleImage> vehicleImageData = vehicleImageRepository.findById(id);

            if (vehicleImageData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("VehicleImageServiceImpl() ->  getVehicleImageById() -> ended");
            return new ResponseEntity<>(vehicleImageData.get(), HttpStatus.OK);
        } catch (Exception e){
            logger.error("VehicleImageServiceImpl() ->  getVehicleImageById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<VehicleImage> updateVehicleImage(long id, VehicleImageDTO vehicleImageDTO) {
        try {
            logger.info("VehicleImageServiceImpl() ->  getVehicleImageById() -> started");
            Optional<VehicleImage> vehicleImageData = vehicleImageRepository.findById(id);

            if (vehicleImageData.isPresent()){
                VehicleImage vehicleImage = getVehicleImageData(vehicleImageData, vehicleImageDTO);

                logger.info("VehicleImageServiceImpl() ->  getVehicleImageById() -> ended");
                return new ResponseEntity<>(vehicleImageRepository.save(vehicleImage), HttpStatus.OK);

            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleImageServiceImpl() ->  getVehicleImageById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static VehicleImage getVehicleImageData(Optional<VehicleImage> vehicleImageData, VehicleImageDTO vehicleImageDTO) {
        if (vehicleImageData.isPresent()){
            VehicleImage vehicleImage = vehicleImageData.get();

            vehicleImage.setFrontImage(vehicleImageDTO.getFrontImage());
            vehicleImage.setRearImage(vehicleImageDTO.getRearImage());
            vehicleImage.setSideImage(vehicleImageDTO.getSideImage());
            vehicleImage.setTopImage(vehicleImageDTO.getTopImage());

            return vehicleImage;
        }
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteVehicleImageById(long id) {
        try {
            logger.info("VehicleImageServiceImpl() ->  deleteVehicleImageById() -> started");
            vehicleImageRepository.deleteById(id);

            logger.info("VehicleImageServiceImpl() ->  deleteVehicleImageById() -> ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleImageServiceImpl() ->  deleteVehicleImageById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllVehicleImages() {
        try {
            logger.info("VehicleImageServiceImpl() ->  deleteAllVehicleImages() -> started");
            vehicleImageRepository.deleteAll();

            logger.info("VehicleImageServiceImpl() ->  deleteAllVehicleImages() -> ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleImageServiceImpl() ->  deleteAllVehicleImages() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
