package com.tour.driver.entity.vehicleentity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Vehicle_Information_table")
@Getter
@Setter
@AllArgsConstructor
public class VehicleInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private long vehicleId;
    @Column(name = "vehicle_make")
    private String vehicleMake;
    @Column(name = "vehicle_model")
    private String model;
    @Column(name = "vehicle_year")
    private String vehicleYear;
    @Column(name = "vehicle_reg_no")
    private String vehicleRegNo;
    @Column(name = "vehicle_plate_no")
    private String vehiclePlateNo;
    @Column(name = "vehicle_insurance")
    private String vehicleInsurance;

    public VehicleInformation() {
    }

    public VehicleInformation(String vehicleMake, String vehicleModel, String vehicleYear, String vehicleRegNo, String vehiclePlateNo, String vehicleInsurance) {
        this.vehicleMake = vehicleMake;
        this.model = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleRegNo = vehicleRegNo;
        this.vehiclePlateNo = vehiclePlateNo;
        this.vehicleInsurance = vehicleInsurance;
    }
}
