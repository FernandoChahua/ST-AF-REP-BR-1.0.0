package com.softech.appforo.rest.dao.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreCampus {
    @Id
    private UUID storeCampusId;

    private Store store;
    private MallCampus mallCampus;

    private String name;
    private String description;
    private String storeCampusUrl;
    private double longitude;
    private double latitude;

    private Integer currentCapacity;
    private Integer capacityLimit;
    private boolean state;

}
