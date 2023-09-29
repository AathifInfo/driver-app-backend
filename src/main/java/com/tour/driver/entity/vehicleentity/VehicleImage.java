package com.tour.driver.entity.vehicleentity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Vehicle_image_table")
@AllArgsConstructor
@NoArgsConstructor
public class VehicleImage {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "vehicle_image_id")
    private long vehicleImageId;

    @Column(name = "front_image")
    private String frontImage;

    @Column(name = "rear_image")
    private String rearImage;

    @Column(name = "side_image")
    private String sideImage;

    @Column(name = "top_image")
    private String topImage;

    public VehicleImage(String frontImage, String rearImage, String sideImage, String topImage) {
        this.frontImage = frontImage;
        this.rearImage = rearImage;
        this.sideImage = sideImage;
        this.topImage = topImage;
    }
}
