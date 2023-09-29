package com.tour.driver.dto.vehicledto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDocumentDTO {
    private long vehicleDocumentId;
    private String registrationNo;
    private String revenueNo;
    private String insuranceNo;
    private String inspectionNo;
    private String proofOfOwnership;
}
