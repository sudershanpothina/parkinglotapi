package com.darshan.parkinglotmock.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * The type Parking info.
 */
@Entity
@Data
@Table(name = "parking_lots")
public class ParkingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
