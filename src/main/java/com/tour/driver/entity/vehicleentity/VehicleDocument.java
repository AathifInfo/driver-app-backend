package com.tour.driver.entity.vehicleentity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicle_document_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_document_id")
    private long vehicleDocumentId;

    @Column(name = "registration_no")
    private String registrationNo;

    @Column(name = "revenue_no")
    private String revenueNo;

    @Column(name = "insurance_no")
    private String insuranceNo;

    @Column(name = "inspection_no")
    private String inspectionNo;

    @Column(name = "proof_of_owner")
    private String proofOfOwnership;

    public VehicleDocument(String registrationNo, String revenueNo, String insuranceNo, String inspectionNo, String proofOfOwnership) {
        this.registrationNo = registrationNo;
        this.revenueNo = revenueNo;
        this.insuranceNo = insuranceNo;
        this.inspectionNo = inspectionNo;
        this.proofOfOwnership = proofOfOwnership;
    }
}
