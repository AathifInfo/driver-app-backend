package com.tour.driver.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "driver_table")
@Getter
@Setter
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver id")
    private long driverId;

    @Column(name = "driver_name")
    private String name;

    @Column(name = "driver_email")
    private String email;

    @Column(name = "driver_fullName")
    private String fullName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "nic_no")
    private String nicNo;

    @Column(name = "driver_address")
    private String address;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "gender")
    private String gender;

    public Driver() {
    }

    public Driver(String name, String email, String fullName, String mobileNumber, String dateOfBirth, String nicNo, String address, String emergencyContact, String gender) {
        this.name = name;
        this.email = email;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.nicNo = nicNo;
        this.address = address;
        this.emergencyContact = emergencyContact;
        this.gender = gender;
    }
}
