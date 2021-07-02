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
public class Mall {
    @Id
    private UUID mallId;

    private String name;
    private String description;
    private String contactEmail;
    private String urlMallImage;
    private boolean status;

}
