package com.softech.appforo.rest.dao.collection;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MallCampus {
    @Id
    private UUID mallCampusId;

    private Mall mall;

    private String name;
    private String description;
    private String mallCampusUrl;
    private double longitude;
    private double latitude;
    private boolean state;

}
