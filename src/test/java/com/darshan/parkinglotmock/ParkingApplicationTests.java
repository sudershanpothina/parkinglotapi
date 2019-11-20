package com.darshan.parkinglotmock;

import com.darshan.parkinglotmock.model.ParkingInfo;
import com.darshan.parkinglotmock.repository.ParkingRepository;
import com.darshan.parkinglotmock.service.PriceCalculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingApplicationTests {

    @Mock
    ParkingRepository parkingRepository;

    @Mock
    PriceCalculation priceCalculation_mock;

    @InjectMocks
    private PriceCalculation priceCalculation;

    List<ParkingInfo> parkingInfos;

    @BeforeEach
    void setup() {
        parkingInfos = new ArrayList<>();
        parkingInfos.add(new ParkingInfo());
        parkingInfos.add(new ParkingInfo());
        parkingInfos.add(new ParkingInfo());
        parkingInfos.add(new ParkingInfo());

    }
    @Test
    void testRandomNumberTest() {
        assertThat(priceCalculation.getRandomNumber(), instanceOf(Integer.class));
    }
    @Test
    void testParkingLotNumber() {
        assertThat(priceCalculation_mock.getParkingLotNumber(), instanceOf(Integer.class));
    }
    @Test
    void testgetParkingPrice() {
        assertThat(priceCalculation.getParkingPrice(), instanceOf(Double.class));
    }
    @Test
    void testNumberOfParkingLots() {
        when(parkingRepository.findAll()).thenReturn(parkingInfos);
        assertEquals(priceCalculation.getParkingLots().size(), 4);
    }
    @Test
    void testNumberOfParkingLotsByZipCode() {
        when(parkingRepository.findByZipCode("53719")).thenReturn(new ParkingInfo());
        assertEquals(priceCalculation.getParkingLot("53719").getId(), 0);
        Assertions.assertThrows(NullPointerException.class, () -> {
            priceCalculation.getParkingLot("53711");
        });
    }
}
