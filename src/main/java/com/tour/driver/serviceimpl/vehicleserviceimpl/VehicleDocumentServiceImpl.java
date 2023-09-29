package com.tour.driver.serviceimpl.vehicleserviceimpl;

import com.tour.driver.dto.vehicledto.VehicleDocumentDTO;
import com.tour.driver.entity.vehicleentity.VehicleDocument;
import com.tour.driver.repository.vehiclerepository.VehicleDocumentRepository;
import com.tour.driver.service.vehicleservice.VehicleDocumentService;
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
public class VehicleDocumentServiceImpl implements VehicleDocumentService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleDocumentServiceImpl.class);

    @Autowired
    VehicleDocumentRepository vehicleDocumentRepository;

    @Override
    public ResponseEntity<VehicleDocument> createVehicleDocument(VehicleDocumentDTO vehicleDocumentDTO) {
        try {
            logger.info("VehicleDocumentServiceImpl() ->  createVehicleDocument() -> started");
            VehicleDocument vehicleDocument = new VehicleDocument(
                vehicleDocumentDTO.getRegistrationNo(),
                vehicleDocumentDTO.getRevenueNo(),
                vehicleDocumentDTO.getInsuranceNo(),
                vehicleDocumentDTO.getInspectionNo(),
                vehicleDocumentDTO.getProofOfOwnership()
            );
            vehicleDocumentRepository.save(vehicleDocument);

            logger.info("VehicleDocumentServiceImpl() ->  createVehicleDocument() -> ended");
            return new ResponseEntity<>(vehicleDocument, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("VehicleDocumentServiceImpl() ->  createVehicleDocument() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<VehicleDocument>> getAllDocuments() {
        try {
            logger.info("VehicleDocumentServiceImpl() ->  getAllDocuments() -> started");
            List<VehicleDocument> vehicleDocumentList = new ArrayList<>(vehicleDocumentRepository.findAll());

            if (vehicleDocumentList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("VehicleDocumentServiceImpl() ->  getAllDocuments() -> ended");
            return new ResponseEntity<>(vehicleDocumentList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("VehicleDocumentServiceImpl() ->  getAllDocuments() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<VehicleDocument> getVehicleDocumentById(long id) {
        try {
            logger.info("VehicleDocumentServiceImpl() ->  getVehicleDocumentById() -> started");
            Optional<VehicleDocument> vehicleDocument = vehicleDocumentRepository.findById(id);

            if (vehicleDocument.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.info("VehicleDocumentServiceImpl() ->  getVehicleDocumentById() -> ended");
            return new ResponseEntity<>(vehicleDocument.get(), HttpStatus.OK);

        } catch (Exception e){
            logger.error("VehicleDocumentServiceImpl() ->  getVehicleDocumentById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<VehicleDocument> updateVehicleDocument(long id, VehicleDocumentDTO vehicleDocumentDTO) {
        try {
            logger.info("VehicleDocumentServiceImpl() ->  updateVehicleDocument() -> started");
            Optional<VehicleDocument> vehicleDocumentData = vehicleDocumentRepository.findById(id);

            if (vehicleDocumentData.isPresent()){
                VehicleDocument vehicleDocument = getVehicleDocumentData(vehicleDocumentData, vehicleDocumentDTO);

                logger.info("VehicleDocumentServiceImpl() ->  updateVehicleDocument() -> ended");
                return new ResponseEntity<>(vehicleDocumentRepository.save(vehicleDocument), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleDocumentServiceImpl() ->  updateVehicleDocument() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static VehicleDocument getVehicleDocumentData(Optional<VehicleDocument> vehicleDocumentData, VehicleDocumentDTO vehicleDocumentDTO) {
        if (vehicleDocumentData.isPresent()){
            VehicleDocument vehicleDocument = vehicleDocumentData.get();

            vehicleDocument.setRegistrationNo(vehicleDocumentDTO.getRegistrationNo());
            vehicleDocument.setRevenueNo(vehicleDocumentDTO.getRevenueNo());
            vehicleDocument.setInsuranceNo(vehicleDocumentDTO.getInsuranceNo());
            vehicleDocument.setInspectionNo(vehicleDocumentDTO.getInspectionNo());
            vehicleDocument.setProofOfOwnership(vehicleDocumentDTO.getProofOfOwnership());

            return vehicleDocument;
        }
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteVehicleDocumentById(long id) {
        try {
            logger.info("VehicleDocumentServiceImpl() ->  deleteVehicleDocumentById() -> started");
            vehicleDocumentRepository.deleteById(id);

            logger.info("VehicleDocumentServiceImpl() ->  deleteVehicleDocumentById() -> started");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleDocumentServiceImpl() ->  deleteVehicleDocumentById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllVehicleDocuments() {
        try {
            logger.info("VehicleDocumentServiceImpl() ->  deleteAllVehicleDocuments() -> started");
            vehicleDocumentRepository.deleteAll();

            logger.info("VehicleDocumentServiceImpl() ->  deleteAllVehicleDocuments() -> started");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("VehicleDocumentServiceImpl() ->  deleteVehicleDocumentById() -> error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
