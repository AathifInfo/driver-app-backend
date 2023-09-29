package com.tour.driver.dto.vehicledto;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class VehicleInformationDTO {

    private String vehicleMake;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleRegNo;
    private String vehiclePlateNo;
    private String vehicleInsurance;

}
