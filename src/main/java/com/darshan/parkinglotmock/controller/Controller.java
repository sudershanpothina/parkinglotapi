package com.darshan.parkinglotmock.controller;

import com.darshan.parkinglotmock.service.PriceCalculation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type Controller.
 */
@RestController
public class Controller {

    /**
     * The Price calculation.
     */
    @Autowired
    PriceCalculation priceCalculation;

    /**
     * Gets parking lots.
     *
     * @return the parking lots
     * @throws JsonProcessingException the json processing exception
     */
    @GetMapping("/parkinglots")
    public String getParkingLots() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(priceCalculation.getParkingLots());
    }

    /**
     * Gets parking lot.
     *
     * @param zipcode the zipcode
     * @return the parking lot
     * @throws JsonProcessingException the json processing exception
     */
    @GetMapping("/parkinglots/{zipcode}")
    public String getParkingLot(@PathVariable String zipcode) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writeValueAsString(priceCalculation.getParkingLotsByZipCodes(zipcode));
            return result;
        } catch (Exception exception) {
            System.out.println(exception);;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Parking lot found for the zipcode " + zipcode, exception);
        }
    }
}
