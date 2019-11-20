package com.darshan.parkinglotmock.repository;

import com.darshan.parkinglotmock.model.ParkingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<ParkingInfo, Long> {
    ParkingInfo findByZipCode(String zipCode);
}
