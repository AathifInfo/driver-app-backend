package com.tour.driver.dto.vehicledto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleImageDTO {

    private long vehicleImageId;
    private String frontImage;
    private String rearImage;
    private String sideImage;
    private String topImage;
}
