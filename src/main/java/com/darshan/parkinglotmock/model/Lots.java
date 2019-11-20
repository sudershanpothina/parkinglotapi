package com.darshan.parkinglotmock.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Lots.
 */
@Data
@AllArgsConstructor
public class Lots {
    private int id;
    private String name;
    private String description;
    private Double price;
    private int availableLots;
}
