package com.darshan.parkinglotmock.service;

import com.darshan.parkinglotmock.model.Lots;
import com.darshan.parkinglotmock.model.ParkingInfo;
import com.darshan.parkinglotmock.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The type Price calculation.
 */
@Service
public class PriceCalculation {

    /**
     * The Parking repository.
     */
    @Autowired
    ParkingRepository parkingRepository;

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    /**
     * Gets parking lot number.
     *
     * @return the parking lot number
     */
    public int getParkingLotNumber() {
        return getRandomNumber();
    }

    /**
     * Gets parking price.
     *
     * @return the parking price
     */
    public Double getParkingPrice() {
        Random random = new Random();
        Double result = 2 * getRandomNumber() * random.nextDouble();
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Gets parking lots.
     *
     * @return the parking lots
     */
    public List<Lots> getParkingLots() {
        List<ParkingInfo> parkingInfos =parkingRepository.findAll();
        List<Lots> lots = new ArrayList<>();
        for (ParkingInfo parkingInfo : parkingInfos) {
            Lots lot = new Lots(parkingInfo.getId(), parkingInfo.getName(), parkingInfo.getDescription(), getParkingPrice(), getParkingLotNumber());
            lots.add(lot);
        }
        return lots;
    }

    /**
     * Gets parking lot.
     *
     * @param zipCode the zip code
     * @return the parking lot
     */
    public Lots getParkingLot(String zipCode) {
        ParkingInfo parkingInfo =  parkingRepository.findByZipCode(zipCode);
        return new Lots(parkingInfo.getId(), parkingInfo.getName(), parkingInfo.getDescription(), getParkingPrice(), getParkingLotNumber());
    }

    /**
     * Gets parking lots by zip codes.
     *
     * @param delimZipCodes the delimited zip codes
     * @return the parking lots by zip codes
     */
    public List<Lots> getParkingLotsByZipCodes(String delimZipCodes) {
        List<Lots> lots = new ArrayList<>();
        String[] zipCodes = delimZipCodes.split(",");
        for(String zipCode : zipCodes) {
            try {
                lots.add(getParkingLot(zipCode));
            } catch (Exception ex) {
                System.out.println("No Parking lot found for " + zipCode    );
            }
        }
        return lots;
    }
}
